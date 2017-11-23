package cn.ckz.kumiweather.module.mainPager;

import cn.ckz.kumiweather.bean.WeatherDataBean;
import cn.ckz.kumiweather.callback.OnWeatherDataGetListener;

/**
 * Created by CKZ on 2017/11/9.
 */

public interface IWeatherModule {
    void getNetWeatherData(String cityName, OnWeatherDataGetListener listener);
    WeatherDataBean getLocalWeatherData(String cityName);
    long getLastUpdateTime(String key);
}
