package cn.ckz.kumiweather.presenter.mainpager;

import android.content.Context;

import java.util.List;

import cn.ckz.kumiweather.callback.CityGetListener;
import cn.ckz.kumiweather.db.CitySave;
import cn.ckz.kumiweather.module.mainPager.IPagerModule;
import cn.ckz.kumiweather.module.mainPager.IPagerXmfl;
import cn.ckz.kumiweather.view.mvpview.mainpager.IPagerView;

/**
 * Created by CKZ on 2017/11/14.
 */

public class IPagerPresenter {

    IPagerView mView;
    IPagerModule mModule;
    Context context;

    public IPagerPresenter(Context context,IPagerView mView){
        this.context = context;
        this.mView = mView;
        mModule = new IPagerXmfl(context);
    }

    public void getCityList(){
        if (mModule!=null){
            mModule.getSaveCity(new CityGetListener() {
                @Override
                public void getSavedCity(List<CitySave> cityList) {
                    showFragment(cityList);
                }
            });
        }
    }

    private void showFragment(List<CitySave> cityList){
        if (mView!=null){
            mView.showFragment(cityList);
        }
    }
}
