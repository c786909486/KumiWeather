package cn.ckz.kumiweather.adapter.citymanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.ckz.kumiweather.R;
import cn.ckz.kumiweather.bean.WeatherDataBean;
import cn.ckz.kumiweather.db.CitySave;
import cn.ckz.kumiweather.utils.ACache;
import cn.ckz.kumiweather.utils.LogUtils;

/**
 * Created by CKZ on 2017/11/15.
 */

public class CityManagerAdapter extends BaseAdapter {

    private List<CitySave> mData;
    private Context context;
    private ACache aCache;


    public CityManagerAdapter(Context context,List<CitySave> mData){
        this.context = context;
        this.mData = mData;
        aCache = ACache.get(context);
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_city,null);
            holder = new ViewHolder();
            holder.cityName = view.findViewById(R.id.city_name);
            holder.dragBtn = view.findViewById(R.id.drag_btn);
            holder.temp = view.findViewById(R.id.now_temp);
            holder.weatherBg = view.findViewById(R.id.weather_bg);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
//        LogUtils.d(getClass().getSimpleName(),mData.get(0).getBelongProvince());
        holder.dragBtn.setVisibility(View.VISIBLE);
//        if (mData.get(i).getType() == 1){
//            holder.dragBtn.setVisibility(View.GONE);
//        }
        WeatherDataBean bean = (WeatherDataBean) aCache.getAsObject(mData.get(i).getCity());
        holder.cityName.setText(mData.get(i).getCity());
       if (bean!=null){
           holder.temp.setText(bean.getHeWeather5().get(0).getNow().getTmp()+"°");
           String weather = bean.getHeWeather5().get(0).getNow().getCond().getTxt();
           if (weather.contains("晴") || weather.contains("云")){
               holder.weatherBg.setImageResource(R.drawable.sun_day_bg);
           }else if (weather.contains("雨") || weather.contains("阴")||weather.contains("雪")){
               holder.weatherBg.setImageResource(R.drawable.cloud_day_bg);
           }
       }
        return view;
    }

    class ViewHolder{

        ImageView weatherBg;
        TextView cityName;
        TextView temp;
        ImageView dragBtn;
    }
}
