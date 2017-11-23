package cn.ckz.kumiweather.module.mainPager;

import android.content.Context;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.ckz.kumiweather.api.ApiCenter;
import cn.ckz.kumiweather.bean.WeatherDataBean;
import cn.ckz.kumiweather.callback.OnDataGetListener;
import cn.ckz.kumiweather.callback.OnWeatherDataGetListener;
import cn.ckz.kumiweather.manager.DataManager;
import cn.ckz.kumiweather.utils.ACache;
import cn.ckz.kumiweather.utils.LogUtils;
import cn.ckz.kumiweather.utils.SPUtils;

/**
 * Created by CKZ on 2017/11/9.
 */

public class IWeatherXmfl implements IWeatherModule {
    private Context context;
    public IWeatherXmfl(Context context){
        this.context = context;
    }
    @Override
    public void getNetWeatherData(final String cityName, final OnWeatherDataGetListener listener) {
        DataManager.getInstance().getData(ApiCenter.weatherApi(cityName), new OnDataGetListener() {
            @Override
            public void onSuccess(Object object) {
                WeatherDataBean bean = JSON.parseObject(object.toString(), WeatherDataBean.class);
                listener.onWeatherGet(bean);
                LogUtils.d(getClass().getSimpleName(),"netdata");
                ACache.get(context).put(cityName,bean);
                try {
                    SPUtils.putlongSp(context,cityName+"time",Long.valueOf(dateToStamp(bean.getHeWeather5().get(0).getBasic().getUpdate().getLoc())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFalied(Object object) {
                listener.onFalied();
            }
        });
    }
    private String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        LogUtils.d(getClass().getSimpleName(),res);
        return res;
    }

    @Override
    public WeatherDataBean getLocalWeatherData(String cityName) {
        LogUtils.d(getClass().getSimpleName(),"localdata");
       return (WeatherDataBean) ACache.get(context).getAsObject(cityName);
    }

    @Override
    public long getLastUpdateTime(String city) {
        return SPUtils.getlongSp(context,city+"time");
    }
}
