package cn.ckz.kumiweather.module.citymanager;

import android.content.Context;

import java.util.List;

import cn.ckz.kumiweather.callback.CityGetListener;
import cn.ckz.kumiweather.db.CitySave;
import cn.ckz.kumiweather.utils.LogUtils;

/**
 * Created by CKZ on 2017/11/15.
 */

public class ICityManagerXmfl implements ICityManagerModule{

    private Context context;

    public ICityManagerXmfl(Context context){
        this.context = context;
    }

    @Override
    public void getCityList(CityGetListener listener) {
        List<CitySave> mData = CitySave.findAll(CitySave.class);
        LogUtils.d(getClass().getSimpleName(),mData.get(0).getCity());
        listener.getSavedCity(mData);
    }

    @Override
    public void deleteCity(String city) {
        CitySave.deleteAll(CitySave.class,"city like ?",city);
    }
}
