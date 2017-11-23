package cn.ckz.kumiweather.adapter.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import cn.ckz.kumiweather.R;
import cn.ckz.kumiweather.api.ApiCenter;
import cn.ckz.kumiweather.bean.WeatherDataBean;
import cn.ckz.kumiweather.utils.DateTools;

/**
 * Created by CKZ on 2017/11/10.
 */

public class DailyAdapter extends BaseAdapter {
    private List<WeatherDataBean.HeWeather5Bean.DailyForecastBean> mData;
    private Context context;
    public DailyAdapter(Context context, List<WeatherDataBean.HeWeather5Bean.DailyForecastBean> mData){
        this.context = context;
        this.mData = mData;
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_daily_forest,viewGroup,false);
            holder = new ViewHolder();
            holder.weekName = view.findViewById(R.id.week_name);
            holder.weatherLogo = view.findViewById(R.id.weather_logo);
            holder.minTemp = view.findViewById(R.id.temp_min);
            holder.maxTemp = view.findViewById(R.id.temp_max);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //设置星期
        holder.weekName.setText(DateTools.dateToWeek(mData.get(i).getDate()));
        //设置最低最高温
        holder.minTemp.setText(mData.get(i).getTmp().getMin());
        holder.maxTemp.setText(mData.get(i).getTmp().getMax());
        //设置logo
        Glide.with(context).load(ApiCenter.weatherLogo(mData.get(i).getCond().getCodeD())).asBitmap()
                .dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.weatherLogo);
        return view;
    }

    class ViewHolder{
        TextView weekName;
        ImageView weatherLogo;
        TextView minTemp;
        TextView maxTemp;
    }
}
