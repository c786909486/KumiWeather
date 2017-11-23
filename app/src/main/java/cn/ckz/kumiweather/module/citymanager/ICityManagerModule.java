package cn.ckz.kumiweather.module.citymanager;

import cn.ckz.kumiweather.callback.CityGetListener;

/**
 * Created by CKZ on 2017/11/15.
 */

public interface ICityManagerModule {

    void getCityList(CityGetListener listener);

    void deleteCity(String city);
}
