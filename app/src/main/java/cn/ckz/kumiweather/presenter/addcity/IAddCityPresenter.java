package cn.ckz.kumiweather.presenter.addcity;

import android.content.Context;

import java.util.List;

import cn.ckz.kumiweather.db.City;
import cn.ckz.kumiweather.module.addcity.IAddCityModule;
import cn.ckz.kumiweather.module.addcity.IAddCityXmfl;
import cn.ckz.kumiweather.view.mvpview.addcity.IAddCityView;

/**
 * Created by CKZ on 2017/11/15.
 */

public class IAddCityPresenter {

    Context context;
    IAddCityModule mModule;
    IAddCityView mView;

    public IAddCityPresenter(Context context,IAddCityView mView){
        this.context = context;
        this.mView =mView;
        mModule = new IAddCityXmfl(context);
    }

    public void searchCity(String keyword){
        if (mModule!=null){
            mModule.getCityList(keyword, new IAddCityModule.CityListListener() {
                @Override
                public void onSuccess(List<City> cityList) {
                    showCityList(cityList);
                }
            });
        }
    }

    public void saveWeatherCity(String city,String province,int type){
        if (mModule!=null){
            mModule.saveWeatherCity(city,province,type);
        }
    }

    private void showCityList(List<City> cityList){
        if (mView!=null){
            mView.showCityList(cityList);
        }
    }
}
