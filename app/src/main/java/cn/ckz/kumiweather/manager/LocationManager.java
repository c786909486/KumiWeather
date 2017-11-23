package cn.ckz.kumiweather.manager;

import android.app.Activity;
import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import cn.ckz.kumiweather.application.MyApplication;
import cn.ckz.kumiweather.service.LocationService;

/**
 * Created by CKZ on 2017/11/13.
 */

public class LocationManager {

    private Activity activity;
    private LocationService locationService;

    public LocationManager(Activity activity,BDLocationListener mListener){
        this.activity = activity;
        locationService = ((MyApplication)activity.getApplication()).locationService;
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        //注册监听
        int type = activity.getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }
    }

    public void start(){
        if (locationService!=null){
            locationService.start();
        }
    }

    public void stop(){
        if (locationService!=null){
            locationService.stop();
        }
    }

}
