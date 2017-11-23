package cn.ckz.kumiweather.application;

import android.app.Service;
import android.os.Vibrator;

import org.litepal.LitePalApplication;

import cn.ckz.kumiweather.service.LocationService;

/**
 * Created by CKZ on 2017/10/30.
 */

public class MyApplication extends LitePalApplication {
    private static MyApplication application = null;
    public LocationService locationService;
    public Vibrator mVibrator;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);

    }
    public static MyApplication getInstance(){return application;}
}
