package cn.ckz.kumiweather.module.addcity;

import android.content.Context;

import org.litepal.crud.DataSupport;
import org.w3c.dom.ProcessingInstruction;

import java.util.List;

import cn.ckz.kumiweather.db.City;
import cn.ckz.kumiweather.db.CitySave;
import cn.ckz.kumiweather.utils.LogUtils;

/**
 * Created by CKZ on 2017/11/15.
 */

public class IAddCityXmfl implements IAddCityModule {
    private Context context;

    public IAddCityXmfl(Context context){
        this.context = context;
    }

    @Override
    public void getCityList(String keyword,CityListListener listener) {
        List<City> cityList = DataSupport.where("cityNameCh like ?",keyword).find(City.class);

        listener.onSuccess(cityList);
    }

    @Override
    public void saveWeatherCity(String city, String province, int type) {
        CitySave citySave = new CitySave();
        citySave.setCity(city);
        citySave.setBelongProvince(province);
        citySave.setType(type);
        citySave.save();
    }
}
