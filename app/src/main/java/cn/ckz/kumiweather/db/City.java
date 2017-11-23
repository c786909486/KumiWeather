package cn.ckz.kumiweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by CKZ on 2017/10/27.
 */

public class City  extends DataSupport {

    private String cityId;//城市编码

    private String cityNameEn;//城市英文名

    private String cityNameCh;//城市中文名

    private String countryCode;//国家代码

    private String countryNameEn;//国家英文名

    private String countryNameCh;//国家中文名

    private String provinceNameEn;//省英文名

    private String provinceNameCh;//省中文名

    private String belongCityEn;//所属上级市英文

    private String belongCityCh;//所属上级市中文

    private String jingdu;//经度

    private String weidu;//纬度

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }

    public String getCityNameCh() {
        return cityNameCh;
    }

    public void setCityNameCh(String cityNameCh) {
        this.cityNameCh = cityNameCh;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryNameEn() {
        return countryNameEn;
    }

    public void setCountryNameEn(String countryNameEn) {
        this.countryNameEn = countryNameEn;
    }

    public String getCountryNameCh() {
        return countryNameCh;
    }

    public void setCountryNameCh(String vountryNameCh) {
        this.countryNameCh = vountryNameCh;
    }

    public String getProvinceNameEn() {
        return provinceNameEn;
    }

    public void setProvinceNameEn(String provinceNameEn) {
        this.provinceNameEn = provinceNameEn;
    }

    public String getProvinceNameCh() {
        return provinceNameCh;
    }

    public void setProvinceNameCh(String provinceNameCh) {
        this.provinceNameCh = provinceNameCh;
    }

    public String getBelongCityEn() {
        return belongCityEn;
    }

    public void setBelongCityEn(String belongCityEn) {
        this.belongCityEn = belongCityEn;
    }

    public String getBelongCityCh() {
        return belongCityCh;
    }

    public void setBelongCityCh(String belongCityCh) {
        this.belongCityCh = belongCityCh;
    }

    public String getJingdu() {
        return jingdu;
    }

    public void setJingdu(String jingdu) {
        this.jingdu = jingdu;
    }

    public String getWeidu() {
        return weidu;
    }

    public void setWeidu(String weidu) {
        this.weidu = weidu;
    }
}
