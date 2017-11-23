package cn.ckz.kumiweather.presenter.mainpager;

import android.content.Context;
import android.text.TextUtils;

import cn.ckz.kumiweather.bean.WeatherDataBean;
import cn.ckz.kumiweather.callback.OnWeatherDataGetListener;
import cn.ckz.kumiweather.module.mainPager.IWeatherModule;
import cn.ckz.kumiweather.module.mainPager.IWeatherXmfl;
import cn.ckz.kumiweather.utils.ACache;
import cn.ckz.kumiweather.view.mvpview.mainpager.IWeatherPagerView;

/**
 * Created by CKZ on 2017/11/9.
 */

public class IWeatnerPresenter {
    private Context context;
    IWeatherModule mModule;
    IWeatherPagerView mView;

    public IWeatnerPresenter(Context context,IWeatherPagerView mView){
        this.context =context;
        this.mView = mView;
        mModule = new IWeatherXmfl(context);
    }

    //刷新数据
    public void refreshData(String cityName){
        mModule.getNetWeatherData(cityName, new OnWeatherDataGetListener() {
            @Override
            public void onWeatherGet(WeatherDataBean result) {
                showUI(result);
            }

            @Override
            public void onFalied() {
                showError();
            }
        });
    }
    //获取本地数据
    public void getLocalData(String cityName){
        if (!TextUtils.isEmpty(cityName)){
            mModule.getLocalWeatherData(cityName);
        }
    }

    //获取数据
    public void getWeatherData(String cityName){
        if (mModule.getLastUpdateTime(cityName) == 0){
            mModule.getNetWeatherData(cityName, new OnWeatherDataGetListener() {
                @Override
                public void onWeatherGet(WeatherDataBean result) {
                    showUI(result);
                }

                @Override
                public void onFalied() {
                    showError();
                }

            });
        }else {
            long time = System.currentTimeMillis() - mModule.getLastUpdateTime(cityName);
            if (time>60*60*1000){
                mModule.getNetWeatherData(cityName, new OnWeatherDataGetListener() {
                    @Override
                    public void onWeatherGet(WeatherDataBean result) {
                        showUI(result);
                    }

                    @Override
                    public void onFalied() {
                        showError();
                    }

                });
            }else {
                showUI(mModule.getLocalWeatherData(cityName));
            }
        }
    }

    //显示数据
    private void showUI(WeatherDataBean bean){
        if (mView!=null){
            mView.showData(bean);
        }
    }
    private void showError(){
        if (mView!=null){
            mView.showError();
        }
    }
}
