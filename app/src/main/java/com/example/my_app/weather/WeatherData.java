package com.example.my_app.weather;

import com.google.gson.annotations.SerializedName;

public class WeatherData {
    //获得日期 天气 最高温 最低温
    @SerializedName("date")
    private String date;
    @SerializedName("wea")
    private String weather;
    @SerializedName("tem")
    private String tem;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
