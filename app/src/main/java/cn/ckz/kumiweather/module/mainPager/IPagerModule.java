package cn.ckz.kumiweather.module.mainPager;

import cn.ckz.kumiweather.callback.CityGetListener;
import cn.ckz.kumiweather.callback.OnDataGetListener;

/**
 * Created by CKZ on 2017/11/13.
 */

public interface IPagerModule {
    //获取保存的城市
    void getSaveCity(CityGetListener listener);


}
