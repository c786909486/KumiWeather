package cn.ckz.kumiweather.view.mvpview.mainpager;

import java.util.List;

import cn.ckz.kumiweather.db.CitySave;

/**
 * Created by CKZ on 2017/11/14.
 */

public interface IPagerView {

    void showFragment(List<CitySave> cityList);
}
