package cn.ckz.kumiweather.manager;

import android.util.Log;

import com.example.vuandroidadsdk.okhttp.CommonOkHttpClient;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataListener;
import com.example.vuandroidadsdk.okhttp.request.CommonRequest;

import cn.ckz.kumiweather.callback.OnDataGetListener;
import cn.ckz.kumiweather.utils.LogUtils;


/**
 * Created by CKZ on 2017/11/9.
 */

public class DataManager {
    private String TAG = getClass().getSimpleName();
    private static DataManager manager;

    public static DataManager getInstance(){
        if (manager == null){
            synchronized (DataManager.class){
                if (manager == null){
                    manager = new DataManager();
                }
            }
        }
        return manager;
    }

    public DataManager getData(String url, final OnDataGetListener listener){
        CommonOkHttpClient.get(CommonRequest.createGetRequest(url,null),new DisposeDataHandle(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                listener.onSuccess(responseObj);
            }

            @Override
            public void onFailure(Object reasonObj) {
                LogUtils.d(TAG,reasonObj.toString());
            }
        }));
        return this;
    }

}
