package cn.ckz.kumiweather.manager;

import android.app.Activity;
import android.util.Log;

import com.example.vuandroidadsdk.okhttp.CommonOkHttpClient;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataListener;
import com.example.vuandroidadsdk.okhttp.request.CommonRequest;

import java.util.List;

import cn.ckz.kumiweather.api.ApiCenter;
import cn.ckz.kumiweather.db.City;

/**
 * Created by CKZ on 2017/10/30.
 */

public class CityManager {
    private static CityManager manager;
    private Activity activity;
    private CityManager(Activity activity){
        this.activity = activity;
    }

    public static CityManager getInstance(Activity activity){
        if (manager == null){
            synchronized (CityManager.class){
                if (manager == null){
                    manager = new CityManager(activity);
                }
            }
        }
        return manager;
    }

    public void needGetNetData(){
        if (!hasSaved()){
            getNetCityData();
            Log.d(getClass().getSimpleName(),"netData");
        }else {
            Log.d(getClass().getSimpleName(),"localData");
        }
    }

    public boolean hasSaved(){
        List<City> cities = City.findAll(City.class);
        return cities.size() != 0;
    }

    private void getNetCityData(){
        CommonOkHttpClient.get(CommonRequest.createGetRequest(ApiCenter.cityApi,null),new DisposeDataHandle(new DisposeDataListener() {
            @Override
            public void onSuccess(final Object responseObj) {
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       saveCityToDb(responseObj.toString());
                   }
               }).start();
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        }));
    }

    private void saveCityToDb(String cityText){
        String[] result = cityText.substring(76,cityText.length()).split("\n");
        for (String cityList:result){
            String[] cityData = cityList.split("\t");
            City city = new City();
            city.setCityId(cityData[0]);
            city.setCityNameEn(cityData[1]);
            city.setCityNameCh(cityData[2]);
            city.setCountryCode(cityData[3]);
            city.setCountryNameEn(cityData[4]);
            city.setCountryNameCh(cityData[5]);
            city.setProvinceNameEn(cityData[6]);
            city.setProvinceNameCh(cityData[7]);
            city.setBelongCityEn(cityData[8]);
            city.setBelongCityCh(cityData[9]);
            city.setWeidu(cityData[10]);
            city.setJingdu(cityData[11]);
            city.save();



        }
    }
}
