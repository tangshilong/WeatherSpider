package po;

import java.io.Serializable;

/**
 * Created by tangshilong on 2017/5/15.
 */
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String num;
    private String stationName;
    private String city;
    private String lat;
    private String lon;
    private String height;
    private String selectName;

    public Station(String num, String stationName, String city, String lat, String lon, String height) {
        this.num = num;
        this.stationName = stationName;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                ", num='" + num + '\'' +
                ", stationName='" + stationName + '\'' +
                ", city='" + city + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", height='" + height + '\'' +
                ", selectName='" + selectName + '\'' +
                '}';
    }

    public Station(Integer id, String num, String stationName, String city, String lat, String lon, String height) {
        this.id = id;
        this.num = num;
        this.stationName = stationName;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
        this.height = height;
    }

    public Station() {
    }

    public String getSelectName() {
        return selectName;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
