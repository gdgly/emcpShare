package com.holley.emcpshare.model.dcs;

import java.util.Map;

// 居民集抄 告警数据
public class LowPointALRData {

    private String              commaddress;
    private String              year;
    private String              mon;
    private String              day;
    private String              hour;
    private String              min;
    private String              alr;
    private Map<String, String> daMap;

    public String getCommaddress() {
        return commaddress;
    }

    public void setCommaddress(String commaddress) {
        this.commaddress = commaddress;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getAlr() {
        return alr;
    }

    public void setAlr(String alr) {
        this.alr = alr;
    }

    public Map<String, String> getDaMap() {
        return daMap;
    }

    public void setDaMap(Map<String, String> daMap) {
        this.daMap = daMap;
    }

}
