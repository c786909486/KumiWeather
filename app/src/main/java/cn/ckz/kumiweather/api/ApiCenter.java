package cn.ckz.kumiweather.api;

/**
 * Created by CKZ on 2017/10/24.
 */

public class ApiCenter {
    public static String weatherApi(String city){
        return "https://free-api.heweather.com/v5/weather?city="+city+
                "&key="+KeyCenter.WEATHER_KEY;
    }
    public static String weatherApi(int cityId){
        return "https://free-api.heweather.com/v5/weather?city="+cityId+
                "&key="+KeyCenter.WEATHER_KEY;
    }

    public static final String cityApi = "https://cdn.heweather.com/china-city-list.txt";

    public static String weatherLogo(String code){
        return "https://cdn.heweather.com/cond_icon/"+code+".png";
    }
}
