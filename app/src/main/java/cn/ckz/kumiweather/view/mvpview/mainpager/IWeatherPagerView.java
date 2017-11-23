package cn.ckz.kumiweather.view.mvpview.mainpager;

import cn.ckz.kumiweather.bean.WeatherDataBean;

/**
 * Created by CKZ on 2017/11/9.
 */

public interface IWeatherPagerView {
    //刷新界面数据
    void showData(WeatherDataBean bean);
    //显示错误界面
    void showError();

}
