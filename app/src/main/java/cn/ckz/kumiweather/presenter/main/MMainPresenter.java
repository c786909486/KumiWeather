package cn.ckz.kumiweather.presenter.main;

import android.app.Activity;

import cn.ckz.kumiweather.module.main.MMainMfxl;
import cn.ckz.kumiweather.module.main.MMainModule;
import cn.ckz.kumiweather.view.mvpview.main.MMainView;

/**
 * Created by CKZ on 2017/10/30.
 */

public class MMainPresenter {
    MMainView mView;
    MMainModule mModule;
    Activity activity;

    public MMainPresenter(Activity activity,MMainView view){
        this.activity = activity;
        this.mView = view;
        mModule = new MMainMfxl(activity);
    }

    //获取城市数据
    public void getCityData(){
        if (mModule!=null){
//           if (mModule.isFirstUse()){
               mModule.getNetCityData();
//           }
        }
    }

}
