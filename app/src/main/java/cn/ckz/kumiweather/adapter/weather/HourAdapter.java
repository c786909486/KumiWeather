package cn.ckz.kumiweather.adapter.weather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import cn.ckz.kumiweather.R;
import cn.ckz.kumiweather.api.ApiCenter;
import cn.ckz.kumiweather.bean.WeatherDataBean;

/**
 * Created by CKZ on 2017/11/10.
 */

public class HourAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<WeatherDataBean.HeWeather5Bean.HourlyForecastBean> mData;
    private Context context;

    public HourAdapter(Context context, List<WeatherDataBean.HeWeather5Bean.HourlyForecastBean> mData){
        this.context = context;
        this.mData = mData;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hourly_forest,parent,false);
        HourViewHolder hourViewHolder = new HourViewHolder(view);
        return hourViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HourViewHolder hourViewHolder = (HourViewHolder) holder;
        //设置时间
        hourViewHolder.mTime.setText(mData.get(position).getDate().substring(11));
        //设置温度
        hourViewHolder.mTemp.setText(mData.get(position).getTmp()+"°");
        //设置weatherLogo
        Glide.with(context).load(ApiCenter.weatherLogo(mData.get(position).getCond().getCode())).asBitmap()
                .dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL).into(hourViewHolder.mLogo);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class HourViewHolder extends RecyclerView.ViewHolder{
        private TextView mTime;
        private ImageView mLogo;
        private TextView mTemp;
        public HourViewHolder(View itemView) {
            super(itemView);
            mTime = itemView.findViewById(R.id.time);
            mLogo = itemView.findViewById(R.id.weather_logo);
            mTemp = itemView.findViewById(R.id.temp);
        }
    }
}
