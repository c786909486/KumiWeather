package cn.ckz.kumiweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by CKZ on 2017/11/13.
 */

public class CitySave extends DataSupport {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitySave citySave = (CitySave) o;

        if (type != citySave.type) return false;
        if (city != null ? !city.equals(citySave.city) : citySave.city != null) return false;
        return belongProvince != null ? belongProvince.equals(citySave.belongProvince) : citySave.belongProvince == null;
    }

    @Override
    public int hashCode() {
        int result = type;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (belongProvince != null ? belongProvince.hashCode() : 0);
        return result;
    }

    private int type;

    private String city;

    private String belongProvince;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBelongProvince() {
        return belongProvince;
    }

    public void setBelongProvince(String belongProvince) {
        this.belongProvince = belongProvince;
    }
}
