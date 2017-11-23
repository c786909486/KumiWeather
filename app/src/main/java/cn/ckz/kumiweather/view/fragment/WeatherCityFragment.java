package cn.ckz.kumiweather.view.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import cn.ckz.kumiweather.R;
import cn.ckz.kumiweather.adapter.weather.DailyAdapter;
import cn.ckz.kumiweather.adapter.weather.HourAdapter;
import cn.ckz.kumiweather.api.ApiCenter;
import cn.ckz.kumiweather.bean.WeatherDataBean;
import cn.ckz.kumiweather.db.CitySave;
import cn.ckz.kumiweather.manager.LocationManager;
import cn.ckz.kumiweather.presenter.mainpager.IWeatnerPresenter;
import cn.ckz.kumiweather.utils.DateTools;
import cn.ckz.kumiweather.utils.LogUtils;
import cn.ckz.kumiweather.utils.SPUtils;
import cn.ckz.kumiweather.utils.StatusBarUtil;
import cn.ckz.kumiweather.view.activity.CityManagerActivity;
import cn.ckz.kumiweather.view.mvpview.mainpager.IWeatherPagerView;
import cn.ckz.kumiweather.view.view.MyListView;
import cn.ckz.kumiweather.view.view.ObservableScrollView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import permissions.dispatcher.NeedsPermission;

import static android.app.Activity.RESULT_OK;

/**
 * Created by CKZ on 2017/11/16.
 */

public class WeatherCityFragment extends Fragment implements IWeatherPagerView,View.OnClickListener{
    private static final int REQUEST_CODE = 0x123;
    public static final int LOCATION = 1;
    public static final int DA_SAVE = 2;
    private String TAG = getClass().getSimpleName();
    private ImageView showweatherbg;//天气背景
    private TextView cityname;//城市名
    private TextView nowtemp;//当前温度
    private ImageView weatherlogo;//天气logo
    private TextView weathernow;//当前天气
    private TextView mintomax;//最低温-最高温
    private TextView todayweek;//今日星期
    private RecyclerView hourforest;//每时预测
    private MyListView dailyforest;//七日预测
    private ObservableScrollView scrollview;//滑动空间
    private TwinklingRefreshLayout refreshlayout;//刷新控件
    private View bgView;//阴暗背景
    private TextView updateTime;//更新时间
    private LinearLayout rootLayout;//下沉view
    private ImageView addBtn;//添加按钮

    //空气质量
    private TextView aqi,co,no2,o3,pm10,pm25,qlty,so2;
    //生活指数
    private TextView uvF,uvText,dressF,dressText,sportF,sportText,fluF,fluText,carF,carText;
    private IWeatnerPresenter presenter;

    private HourAdapter hourAdapter;
    private List<WeatherDataBean.HeWeather5Bean.HourlyForecastBean> hourData;

    private DailyAdapter dailyAdapter;
    private List<WeatherDataBean.HeWeather5Bean.DailyForecastBean> dailyList;

    private String cityName;

    public void setCity(String cityName){
        this.cityName = cityName;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather,container,false);
        initView(view);
        StatusBarUtil.setTransparentForImageViewInFragment(getActivity(),rootLayout);
        presenter = new IWeatnerPresenter(getContext(),this);
        presenter.getWeatherData(cityName);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    private void initView(View view) {
        rootLayout = view.findViewById(R.id.root_layout);
        refreshlayout = (TwinklingRefreshLayout) view.findViewById(R.id.refresh_layout);
        scrollview =  view.findViewById(R.id.scroll_view);
        rootLayout.setVisibility(View.GONE);
        dailyforest = (MyListView) view.findViewById(R.id.daily_forest);
        hourforest = (RecyclerView) view.findViewById(R.id.hour_forest);
        todayweek = (TextView) view.findViewById(R.id.today_week);
        mintomax = (TextView) view.findViewById(R.id.min_to_max);
        weathernow = (TextView) view.findViewById(R.id.weather_now);
        weatherlogo = (ImageView) view.findViewById(R.id.weather_logo);
        nowtemp = (TextView) view.findViewById(R.id.now_temp);
        cityname = (TextView) view.findViewById(R.id.city_name);
        showweatherbg = (ImageView) view.findViewById(R.id.show_weather_bg);
        aqi = view.findViewById(R.id.aqi_data);
        co = view.findViewById(R.id.co_data);
        no2 = view.findViewById(R.id.no2_data);
        o3 = view.findViewById(R.id.o3_data);
        pm10 = view.findViewById(R.id.pm10_data);
        pm25 = view.findViewById(R.id.pm25_data);
        qlty = view.findViewById(R.id.qlty_data);
        so2 = view.findViewById(R.id.so_data);
        bgView = view.findViewById(R.id.bg_view);
        uvF = view.findViewById(R.id.uv_f);
        uvText = view.findViewById(R.id.uv_text);
        dressF = view.findViewById(R.id.dress_f);
        dressText = view.findViewById(R.id.dress_text);
        sportF = view.findViewById(R.id.sport_f);
        sportText = view.findViewById(R.id.sport_text);
        fluF = view.findViewById(R.id.flu_f);
        fluText = view.findViewById(R.id.flu_text);
        carF = view.findViewById(R.id.car_f);
        carText = view.findViewById(R.id.car_text);
        updateTime = view.findViewById(R.id.update_time);
        addBtn = view.findViewById(R.id.add_btn);
        addBtn.setOnClickListener(this);
        //刷新控件禁止加载
        refreshlayout.setEnableLoadmore(false);
        refreshlayout.setEnableRefresh(false);

        hourData = new ArrayList<>();
        hourAdapter = new HourAdapter(getContext(),hourData);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hourforest.setLayoutManager(layoutManager);
        hourforest.setAdapter(hourAdapter);

        dailyList = new ArrayList<>();
        dailyAdapter = new DailyAdapter(getContext(),dailyList);
        dailyforest.setAdapter(dailyAdapter);
        setScroll();
        //刷新
        refreshlayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {

                presenter.refreshData(cityName);
            }
        });
    }
    //设置滚动阴影
    private void setScroll() {
        scrollview.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                if (y>1800){
                    bgView.setAlpha(y);
                }else {
                    bgView.setAlpha(0);
                }
            }
        });
    }

    @Override
    public void showData(final WeatherDataBean bean) {
        getActivity().runOnUiThread(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                refreshlayout.finishRefreshing();
                WeatherDataBean.HeWeather5Bean weather5Bean = bean.getHeWeather5().get(0);
                cityname.setText(cityName);
                nowtemp.setText(weather5Bean.getNow().getTmp()+"°");
                weathernow.setText(weather5Bean.getNow().getCond().getTxt());
                mintomax.setText(weather5Bean.getDailyForecast().get(0).getTmp().getMin()+"°"+"~"+
                        weather5Bean.getDailyForecast().get(0).getTmp().getMax()+"°");
                todayweek.setText(DateTools.dateToWeek(weather5Bean.getDailyForecast().get(0).getDate()));
                //天气logo
                Glide.with(getContext()).load(ApiCenter.weatherLogo(weather5Bean.getNow().getCond().getCode()))
                        .asBitmap().dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(weatherlogo);
                //每时预报
                hourData.clear();
                hourData.addAll(weather5Bean.getHourlyForecast());
                hourAdapter.notifyDataSetChanged();
                //每日预报
                dailyList.clear();
                dailyList.addAll(weather5Bean.getDailyForecast());
                dailyAdapter.notifyDataSetChanged();
                //空气质量
                setQuality(weather5Bean);
                //生活指数
                setLifeStyle(weather5Bean);
                //更新时间
                updateTime.setText("更新时间："+weather5Bean.getBasic().getUpdate().getLoc().substring(11));
                rootLayout.setVisibility(View.VISIBLE);
            }
        });
    }
    //生活指数
    private void setLifeStyle(WeatherDataBean.HeWeather5Bean weather5Bean) {
        WeatherDataBean.HeWeather5Bean.SuggestionBean bean = weather5Bean.getSuggestion();
        //uv
        uvF.setText(bean.getUv().getBrf());
        uvText.setText(bean.getUv().getTxt());
        //穿衣
        dressF.setText(bean.getDrsg().getBrf());
        dressText.setText(bean.getDrsg().getTxt());
        //运动
        sportF.setText(bean.getSport().getBrf());
        sportText.setText(bean.getSport().getTxt());
        //感冒
        fluF.setText(bean.getFlu().getBrf());
        fluText.setText(bean.getFlu().getTxt());
        //洗车
        carF.setText(bean.getCw().getBrf());
        carText.setText(bean.getCw().getTxt());
    }
    //空气质量
    private void setQuality(WeatherDataBean.HeWeather5Bean weather5Bean) {
        aqi.setText(weather5Bean.getAqi().getCity().getAqi());
        co.setText(weather5Bean.getAqi().getCity().getCo());
        no2.setText(weather5Bean.getAqi().getCity().getNo2());
        o3.setText(weather5Bean.getAqi().getCity().getO3());
        pm10.setText(weather5Bean.getAqi().getCity().getPm10());
        pm25.setText(weather5Bean.getAqi().getCity().getPm25());
        qlty.setText(weather5Bean.getAqi().getCity().getQlty());
        so2.setText(weather5Bean.getAqi().getCity().getSo2());
    }

    @Override
    public void showError() {
        Snackbar.make(showweatherbg,"网络错误，请检查网络",Snackbar.LENGTH_SHORT).show();
//        Toast.makeText(getContext(),"",Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_btn:
                Intent intent = new Intent(getContext(), CityManagerActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_CODE:
                if (resultCode == RESULT_OK){
                    int position = data.getIntExtra("POSITION",0);
                    listener.onPageCallback(position);
                    LogUtils.d(TAG,"返回"+position);
                }
        }
    }

    private WeatherFragment.FragmentCallback listener;

    public void setFragmentCallback(WeatherFragment.FragmentCallback callback){
        this.listener = callback;
    }

    public interface FragmentCallback{
        void onPageCallback(int position);
    }
}

