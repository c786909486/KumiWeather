package cn.ckz.kumiweather.view.mvpview.citymanager;

import java.util.List;

import cn.ckz.kumiweather.db.CitySave;

/**
 * Created by CKZ on 2017/11/15.
 */

public interface ICityManagerView {

    void showCity(List<CitySave> cityList);
}
