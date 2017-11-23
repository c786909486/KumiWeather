package cn.ckz.kumiweather.view.mvpview.addcity;

import java.util.List;

import cn.ckz.kumiweather.db.City;

/**
 * Created by CKZ on 2017/11/15.
 */

public interface IAddCityView {

    void showCityList(List<City> cityList);
}
