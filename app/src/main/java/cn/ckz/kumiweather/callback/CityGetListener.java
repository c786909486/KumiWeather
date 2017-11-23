package cn.ckz.kumiweather.callback;

import java.util.List;

import cn.ckz.kumiweather.db.CitySave;

/**
 * Created by CKZ on 2017/11/14.
 */

public interface CityGetListener {
    void getSavedCity(List<CitySave> cityList);
}
