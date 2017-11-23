package cn.ckz.kumiweather.module.addcity;

import java.util.List;

import cn.ckz.kumiweather.db.City;

/**
 * Created by CKZ on 2017/11/15.
 */

public interface IAddCityModule {

    void getCityList(String keyword,CityListListener listListener);

    void saveWeatherCity(String city,String province,int type);

    public interface CityListListener{

        void onSuccess(List<City> cityList);
    }
}
