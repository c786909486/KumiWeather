package cn.ckz.kumiweather.callback;

import cn.ckz.kumiweather.bean.WeatherDataBean;

/**
 * Created by CKZ on 2017/11/9.
 */

public interface OnWeatherDataGetListener {
    void onWeatherGet(WeatherDataBean result);
    void onFalied();
}
