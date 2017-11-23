package cn.ckz.kumiweather.module.mainPager;

import android.content.Context;

import org.litepal.crud.DataSupport;

import java.util.List;

import cn.ckz.kumiweather.callback.CityGetListener;
import cn.ckz.kumiweather.callback.OnDataGetListener;
import cn.ckz.kumiweather.db.City;
import cn.ckz.kumiweather.db.CitySave;

/**
 * Created by CKZ on 2017/11/14.
 */

public class IPagerXmfl implements IPagerModule {
    private Context context;
    public IPagerXmfl(Context context){
        this.context = context;
    }

    @Override
    public void getSaveCity(CityGetListener listener) {
        List<CitySave> mData = DataSupport.findAll(CitySave.class);
        listener.getSavedCity(mData);
    }
}
