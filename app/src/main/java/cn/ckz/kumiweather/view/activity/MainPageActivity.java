package cn.ckz.kumiweather.view.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

import java.util.ArrayList;
import java.util.List;

import cn.ckz.kumiweather.R;
import cn.ckz.kumiweather.adapter.MainPagerAdapter;
import cn.ckz.kumiweather.application.MyApplication;
import cn.ckz.kumiweather.db.CitySave;
import cn.ckz.kumiweather.manager.LocationManager;
import cn.ckz.kumiweather.presenter.mainpager.IPagerPresenter;
import cn.ckz.kumiweather.service.LocationService;
import cn.ckz.kumiweather.utils.ACache;
import cn.ckz.kumiweather.utils.LogUtils;
import cn.ckz.kumiweather.utils.StatusBarUtil;
import cn.ckz.kumiweather.view.fragment.WeatherCityFragment;
import cn.ckz.kumiweather.view.fragment.WeatherFragment;
import cn.ckz.kumiweather.view.mvpview.mainpager.IPagerView;
import cn.ckz.kumiweather.view.view.NoPreloadViewPager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

public class MainPageActivity extends AppCompatActivity implements IPagerView,WeatherFragment.FragmentCallback{
    private String TAG = getClass().getSimpleName();
    private NoPreloadViewPager mPager;
    private MainPagerAdapter mAdapter;
    private List<Fragment> mList;

    private IPagerPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        presenter = new IPagerPresenter(this,this);
        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d(TAG,"清空数据");
       Observable.create(new ObservableOnSubscribe<Integer>() {
           @Override
           public void subscribe(ObservableEmitter<Integer> e) throws Exception {
               e.onNext(1);
               e.onComplete();
           }
       }).subscribe(new Observer<Integer>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(Integer integer) {
               mList.clear();
               getPage();
               presenter.getCityList();

           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onComplete() {
               getNewCity();
           }
       });

    }

    private void initView() {
        mPager = findViewById(R.id.weather_view_pager);
        mPager.setPageMargin(80);
        mList = new ArrayList<>();
        mAdapter = new MainPagerAdapter(getSupportFragmentManager(), mList);
        mPager.setAdapter(mAdapter);
    }

    private void getPage(){
        WeatherFragment fragment = new WeatherFragment();
        fragment.setType(WeatherFragment.LOCATION);
        fragment.setFragmentCallback(this);
        mList.add(0,fragment);
        mAdapter.notifyDataSetChanged();

    }
    private int position = -1;

    private void getNewCity(){
        String newCity = ACache.get(this).getAsString("new_city");

        if (!TextUtils.isEmpty(newCity)){
            mPager.setCurrentItem(mList.size(),false);
            ACache.get(this).remove("new_city");
            LogUtils.d(TAG,newCity);
        }else {
            LogUtils.d(TAG,"无跳转");
        }

    }

    @Override
    public void showFragment(List<CitySave> cityList) {

        for (CitySave city : cityList){
            if (city.getType() == 2){
                WeatherCityFragment fragment = new WeatherCityFragment();
                fragment.setCity(city.getCity());
                fragment.setFragmentCallback(this);
                mList.add(fragment);
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPageCallback(int position) {

        mPager.setCurrentItem(position,false);
        LogUtils.d(TAG,"滑动"+position);
    }
}
