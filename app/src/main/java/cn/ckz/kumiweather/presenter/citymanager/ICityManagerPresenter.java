package cn.ckz.kumiweather.presenter.citymanager;

import android.content.Context;

import java.util.List;

import cn.ckz.kumiweather.callback.CityGetListener;
import cn.ckz.kumiweather.db.CitySave;
import cn.ckz.kumiweather.module.citymanager.ICityManagerModule;
import cn.ckz.kumiweather.module.citymanager.ICityManagerXmfl;
import cn.ckz.kumiweather.utils.ACache;
import cn.ckz.kumiweather.view.mvpview.citymanager.ICityManagerView;

/**
 * Created by CKZ on 2017/11/15.
 */

public class ICityManagerPresenter {

    private Context context;
    ICityManagerView mView;
    ICityManagerModule mModule;

    public ICityManagerPresenter(Context context,ICityManagerView mView){
        this.context = context;
        this.mView = mView;
        mModule = new ICityManagerXmfl(context);
    }

    public void getCityList(){
        if (mModule!=null){
            mModule.getCityList(new CityGetListener() {
                @Override
                public void getSavedCity(List<CitySave> cityList) {
                    showCity(cityList);
                }
            });
        }
    }


    private void showCity(List<CitySave> cityList){
        if (mView!= null){
            mView.showCity(cityList);
        }
    }

    public void deleteCity(String city){
        if (mModule!=null){
            mModule.deleteCity(city);
        }
    }
}
