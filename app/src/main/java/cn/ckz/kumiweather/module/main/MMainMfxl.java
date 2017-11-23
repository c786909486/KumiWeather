package cn.ckz.kumiweather.module.main;

import android.app.Activity;

import cn.ckz.kumiweather.manager.CityManager;
import cn.ckz.kumiweather.utils.SPUtils;

/**
 * Created by CKZ on 2017/10/30.
 */

public class MMainMfxl implements MMainModule {
    private Activity activity;

    public MMainMfxl (Activity activity){
        this.activity = activity;
    }

    @Override
    public void getNetCityData() {
        CityManager.getInstance(activity).needGetNetData();
    }

    @Override
    public boolean isFirstUse() {

        return SPUtils.getBooleanSp(activity,"isFirst");
    }
}
