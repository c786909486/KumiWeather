package cn.ckz.kumiweather.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by CKZ on 2017/10/26.
 */

public class WeatherDataBean implements Serializable{
    @JSONField(name = "HeWeather5")
    private List<HeWeather5Bean> HeWeather5;

    public List<HeWeather5Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather5Bean implements Serializable{
        /**
         * aqi : {"city":{"aqi":"68","co":"1","no2":"48","o3":"127","pm10":"75","pm25":"49","qlty":"良","so2":"11"}}
         * basic : {"city":"杭州","cnty":"中国","id":"CN101210101","lat":"30.28745842","lon":"120.15357971","update":{"loc":"2017-10-26 16:46","utc":"2017-10-26 08:46"}}
         * daily_forecast : [{"astro":{"mr":"11:27","ms":"22:10","sr":"06:09","ss":"17:17"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-10-26","hum":"64","pcpn":"0.0","pop":"0","pres":"1021","tmp":{"max":"23","min":"13"},"uv":"6","vis":"16","wind":{"deg":"39","dir":"东北风","sc":"微风","spd":"6"}},{"astro":{"mr":"12:12","ms":"23:01","sr":"06:09","ss":"17:17"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-10-27","hum":"63","pcpn":"0.0","pop":"0","pres":"1019","tmp":{"max":"23","min":"13"},"uv":"6","vis":"20","wind":{"deg":"100","dir":"东风","sc":"3-4","spd":"17"}},{"astro":{"mr":"12:55","ms":"23:54","sr":"06:10","ss":"17:16"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-10-28","hum":"62","pcpn":"0.0","pop":"0","pres":"1021","tmp":{"max":"22","min":"13"},"uv":"6","vis":"20","wind":{"deg":"42","dir":"东北风","sc":"微风","spd":"5"}},{"astro":{"mr":"13:36","ms":"08:45","sr":"06:11","ss":"17:15"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2017-10-29","hum":"64","pcpn":"0.0","pop":"0","pres":"1026","tmp":{"max":"21","min":"12"},"uv":"5","vis":"20","wind":{"deg":"350","dir":"北风","sc":"微风","spd":"16"}},{"astro":{"mr":"14:14","ms":"00:49","sr":"06:12","ss":"17:14"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-10-30","hum":"59","pcpn":"0.0","pop":"0","pres":"1027","tmp":{"max":"18","min":"11"},"uv":"6","vis":"20","wind":{"deg":"2","dir":"北风","sc":"3-4","spd":"19"}},{"astro":{"mr":"14:52","ms":"01:47","sr":"06:12","ss":"17:13"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-10-31","hum":"62","pcpn":"0.0","pop":"0","pres":"1023","tmp":{"max":"20","min":"10"},"uv":"5","vis":"20","wind":{"deg":"1","dir":"北风","sc":"微风","spd":"3"}},{"astro":{"mr":"15:30","ms":"02:45","sr":"06:13","ss":"17:12"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2017-11-01","hum":"65","pcpn":"0.0","pop":"0","pres":"1020","tmp":{"max":"20","min":"12"},"uv":"6","vis":"20","wind":{"deg":"36","dir":"东北风","sc":"微风","spd":"6"}}]
         * hourly_forecast : [{"cond":{"code":"100","txt":"晴"},"date":"2017-10-26 19:00","hum":"72","pop":"0","pres":"1019","tmp":"19","wind":{"deg":"90","dir":"东风","sc":"微风","spd":"10"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-10-26 22:00","hum":"75","pop":"0","pres":"1021","tmp":"17","wind":{"deg":"86","dir":"东风","sc":"微风","spd":"6"}}]
         * now : {"cond":{"code":"101","txt":"多云"},"fl":"25","hum":"58","pcpn":"0","pres":"1018","tmp":"22","vis":"10","wind":{"deg":"86","dir":"东风","sc":"3-4","spd":"12"}}
         * status : ok
         * suggestion : {"air":{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"},"comf":{"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},"cw":{"brf":"较不宜","txt":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"},"drsg":{"brf":"舒适","txt":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"},"flu":{"brf":"较易发","txt":"昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。"},"sport":{"brf":"适宜","txt":"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。"},"trav":{"brf":"适宜","txt":"天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。"},"uv":{"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}}
         */

        @JSONField(name = "aqi")
        private AqiBean aqi;
        @JSONField(name = "basic")
        private BasicBean basic;
        @JSONField(name = "now")
        private NowBean now;
        @JSONField(name = "status")
        private String status;
        @JSONField(name = "suggestion")
        private SuggestionBean suggestion;
        @JSONField(name = "daily_forecast")
        private List<DailyForecastBean> dailyForecast;
        @JSONField(name = "hourly_forecast")
        private List<HourlyForecastBean> hourlyForecast;

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastBean> getDailyForecast() {
            return dailyForecast;
        }

        public void setDailyForecast(List<DailyForecastBean> dailyForecast) {
            this.dailyForecast = dailyForecast;
        }

        public List<HourlyForecastBean> getHourlyForecast() {
            return hourlyForecast;
        }

        public void setHourlyForecast(List<HourlyForecastBean> hourlyForecast) {
            this.hourlyForecast = hourlyForecast;
        }

        public static class AqiBean implements Serializable{
            /**
             * city : {"aqi":"68","co":"1","no2":"48","o3":"127","pm10":"75","pm25":"49","qlty":"良","so2":"11"}
             */

            @JSONField(name = "city")
            private CityBean city;

            public CityBean getCity() {
                return city;
            }

            public void setCity(CityBean city) {
                this.city = city;
            }

            public static class CityBean implements Serializable{
                /**
                 * aqi : 68
                 * co : 1
                 * no2 : 48
                 * o3 : 127
                 * pm10 : 75
                 * pm25 : 49
                 * qlty : 良
                 * so2 : 11
                 */

                @JSONField(name = "aqi")
                private String aqi;
                @JSONField(name = "co")
                private String co;
                @JSONField(name = "no2")
                private String no2;
                @JSONField(name = "o3")
                private String o3;
                @JSONField(name = "pm10")
                private String pm10;
                @JSONField(name = "pm25")
                private String pm25;
                @JSONField(name = "qlty")
                private String qlty;
                @JSONField(name = "so2")
                private String so2;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }
            }
        }

        public static class BasicBean implements Serializable{
            /**
             * city : 杭州
             * cnty : 中国
             * id : CN101210101
             * lat : 30.28745842
             * lon : 120.15357971
             * update : {"loc":"2017-10-26 16:46","utc":"2017-10-26 08:46"}
             */

            @JSONField(name = "city")
            private String city;
            @JSONField(name = "cnty")
            private String cnty;
            @JSONField(name = "id")
            private String id;
            @JSONField(name = "lat")
            private String lat;
            @JSONField(name = "lon")
            private String lon;
            @JSONField(name = "update")
            private UpdateBean update;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public UpdateBean getUpdate() {
                return update;
            }

            public void setUpdate(UpdateBean update) {
                this.update = update;
            }

            public static class UpdateBean implements Serializable{
                /**
                 * loc : 2017-10-26 16:46
                 * utc : 2017-10-26 08:46
                 */

                @JSONField(name = "loc")
                private String loc;
                @JSONField(name = "utc")
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class NowBean implements Serializable{
            /**
             * cond : {"code":"101","txt":"多云"}
             * fl : 25
             * hum : 58
             * pcpn : 0
             * pres : 1018
             * tmp : 22
             * vis : 10
             * wind : {"deg":"86","dir":"东风","sc":"3-4","spd":"12"}
             */

            @JSONField(name = "cond")
            private CondBean cond;
            @JSONField(name = "fl")
            private String fl;
            @JSONField(name = "hum")
            private String hum;
            @JSONField(name = "pcpn")
            private String pcpn;
            @JSONField(name = "pres")
            private String pres;
            @JSONField(name = "tmp")
            private String tmp;
            @JSONField(name = "vis")
            private String vis;
            @JSONField(name = "wind")
            private WindBean wind;

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class CondBean implements Serializable{
                /**
                 * code : 101
                 * txt : 多云
                 */

                @JSONField(name = "code")
                private String code;
                @JSONField(name = "txt")
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindBean implements Serializable{
                /**
                 * deg : 86
                 * dir : 东风
                 * sc : 3-4
                 * spd : 12
                 */

                @JSONField(name = "deg")
                private String deg;
                @JSONField(name = "dir")
                private String dir;
                @JSONField(name = "sc")
                private String sc;
                @JSONField(name = "spd")
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class SuggestionBean implements Serializable{
            /**
             * air : {"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}
             * comf : {"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"}
             * cw : {"brf":"较不宜","txt":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"}
             * drsg : {"brf":"舒适","txt":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"}
             * flu : {"brf":"较易发","txt":"昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。"}
             * sport : {"brf":"适宜","txt":"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。"}
             * trav : {"brf":"适宜","txt":"天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。"}
             * uv : {"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}
             */

            @JSONField(name = "air")
            private AirBean air;
            @JSONField(name = "comf")
            private ComfBean comf;
            @JSONField(name = "cw")
            private CwBean cw;
            @JSONField(name = "drsg")
            private DrsgBean drsg;
            @JSONField(name = "flu")
            private FluBean flu;
            @JSONField(name = "sport")
            private SportBean sport;
            @JSONField(name = "trav")
            private TravBean trav;
            @JSONField(name = "uv")
            private UvBean uv;

            public AirBean getAir() {
                return air;
            }

            public void setAir(AirBean air) {
                this.air = air;
            }

            public ComfBean getComf() {
                return comf;
            }

            public void setComf(ComfBean comf) {
                this.comf = comf;
            }

            public CwBean getCw() {
                return cw;
            }

            public void setCw(CwBean cw) {
                this.cw = cw;
            }

            public DrsgBean getDrsg() {
                return drsg;
            }

            public void setDrsg(DrsgBean drsg) {
                this.drsg = drsg;
            }

            public FluBean getFlu() {
                return flu;
            }

            public void setFlu(FluBean flu) {
                this.flu = flu;
            }

            public SportBean getSport() {
                return sport;
            }

            public void setSport(SportBean sport) {
                this.sport = sport;
            }

            public TravBean getTrav() {
                return trav;
            }

            public void setTrav(TravBean trav) {
                this.trav = trav;
            }

            public UvBean getUv() {
                return uv;
            }

            public void setUv(UvBean uv) {
                this.uv = uv;
            }

            public static class AirBean implements Serializable{
                /**
                 * brf : 中
                 * txt : 气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
                 */

                @JSONField(name = "brf")
                private String brf;
                @JSONField(name = "txt")
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class ComfBean implements Serializable{
                /**
                 * brf : 舒适
                 * txt : 白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。
                 */

                @JSONField(name = "brf")
                private String brf;
                @JSONField(name = "txt")
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class CwBean implements Serializable{
                /**
                 * brf : 较不宜
                 * txt : 较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。
                 */

                @JSONField(name = "brf")
                private String brf;
                @JSONField(name = "txt")
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class DrsgBean implements Serializable{
                /**
                 * brf : 舒适
                 * txt : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
                 */

                @JSONField(name = "brf")
                private String brf;
                @JSONField(name = "txt")
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class FluBean implements Serializable{
                /**
                 * brf : 较易发
                 * txt : 昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。
                 */

                @JSONField(name = "brf")
                private String brf;
                @JSONField(name = "txt")
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class SportBean implements Serializable{
                /**
                 * brf : 适宜
                 * txt : 天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。
                 */

                @JSONField(name = "brf")
                private String brf;
                @JSONField(name = "txt")
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class TravBean implements Serializable{
                /**
                 * brf : 适宜
                 * txt : 天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。
                 */

                @JSONField(name = "brf")
                private String brf;
                @JSONField(name = "txt")
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class UvBean implements Serializable{
                /**
                 * brf : 弱
                 * txt : 紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。
                 */

                @JSONField(name = "brf")
                private String brf;
                @JSONField(name = "txt")
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastBean implements Serializable{
            /**
             * astro : {"mr":"11:27","ms":"22:10","sr":"06:09","ss":"17:17"}
             * cond : {"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"}
             * date : 2017-10-26
             * hum : 64
             * pcpn : 0.0
             * pop : 0
             * pres : 1021
             * tmp : {"max":"23","min":"13"}
             * uv : 6
             * vis : 16
             * wind : {"deg":"39","dir":"东北风","sc":"微风","spd":"6"}
             */

            @JSONField(name = "astro")
            private AstroBean astro;
            @JSONField(name = "cond")
            private CondBeanX cond;
            @JSONField(name = "date")
            private String date;
            @JSONField(name = "hum")
            private String hum;
            @JSONField(name = "pcpn")
            private String pcpn;
            @JSONField(name = "pop")
            private String pop;
            @JSONField(name = "pres")
            private String pres;
            @JSONField(name = "tmp")
            private TmpBean tmp;
            @JSONField(name = "uv")
            private String uv;
            @JSONField(name = "vis")
            private String vis;
            @JSONField(name = "wind")
            private WindBeanX wind;

            public AstroBean getAstro() {
                return astro;
            }

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

            public CondBeanX getCond() {
                return cond;
            }

            public void setCond(CondBeanX cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public String getUv() {
                return uv;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBeanX getWind() {
                return wind;
            }

            public void setWind(WindBeanX wind) {
                this.wind = wind;
            }

            public static class AstroBean implements Serializable{
                /**
                 * mr : 11:27
                 * ms : 22:10
                 * sr : 06:09
                 * ss : 17:17
                 */

                @JSONField(name = "mr")
                private String mr;
                @JSONField(name = "ms")
                private String ms;
                @JSONField(name = "sr")
                private String sr;
                @JSONField(name = "ss")
                private String ss;

                public String getMr() {
                    return mr;
                }

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public String getMs() {
                    return ms;
                }

                public void setMs(String ms) {
                    this.ms = ms;
                }

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondBeanX implements Serializable{
                /**
                 * code_d : 101
                 * code_n : 101
                 * txt_d : 多云
                 * txt_n : 多云
                 */

                @JSONField(name = "code_d")
                private String codeD;
                @JSONField(name = "code_n")
                private String codeN;
                @JSONField(name = "txt_d")
                private String txtD;
                @JSONField(name = "txt_n")
                private String txtN;

                public String getCodeD() {
                    return codeD;
                }

                public void setCodeD(String codeD) {
                    this.codeD = codeD;
                }

                public String getCodeN() {
                    return codeN;
                }

                public void setCodeN(String codeN) {
                    this.codeN = codeN;
                }

                public String getTxtD() {
                    return txtD;
                }

                public void setTxtD(String txtD) {
                    this.txtD = txtD;
                }

                public String getTxtN() {
                    return txtN;
                }

                public void setTxtN(String txtN) {
                    this.txtN = txtN;
                }
            }

            public static class TmpBean implements Serializable{
                /**
                 * max : 23
                 * min : 13
                 */

                @JSONField(name = "max")
                private String max;
                @JSONField(name = "min")
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }

            public static class WindBeanX implements Serializable{
                /**
                 * deg : 39
                 * dir : 东北风
                 * sc : 微风
                 * spd : 6
                 */

                @JSONField(name = "deg")
                private String deg;
                @JSONField(name = "dir")
                private String dir;
                @JSONField(name = "sc")
                private String sc;
                @JSONField(name = "spd")
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class HourlyForecastBean implements Serializable{
            /**
             * cond : {"code":"100","txt":"晴"}
             * date : 2017-10-26 19:00
             * hum : 72
             * pop : 0
             * pres : 1019
             * tmp : 19
             * wind : {"deg":"90","dir":"东风","sc":"微风","spd":"10"}
             */

            @JSONField(name = "cond")
            private CondBeanXX cond;
            @JSONField(name = "date")
            private String date;
            @JSONField(name = "hum")
            private String hum;
            @JSONField(name = "pop")
            private String pop;
            @JSONField(name = "pres")
            private String pres;
            @JSONField(name = "tmp")
            private String tmp;
            @JSONField(name = "wind")
            private WindBeanXX wind;

            public CondBeanXX getCond() {
                return cond;
            }

            public void setCond(CondBeanXX cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public WindBeanXX getWind() {
                return wind;
            }

            public void setWind(WindBeanXX wind) {
                this.wind = wind;
            }

            public static class CondBeanXX implements Serializable{
                /**
                 * code : 100
                 * txt : 晴
                 */

                @JSONField(name = "code")
                private String code;
                @JSONField(name = "txt")
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindBeanXX implements Serializable{
                /**
                 * deg : 90
                 * dir : 东风
                 * sc : 微风
                 * spd : 10
                 */

                @JSONField(name = "deg")
                private String deg;
                @JSONField(name = "dir")
                private String dir;
                @JSONField(name = "sc")
                private String sc;
                @JSONField(name = "spd")
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }
    }
}
