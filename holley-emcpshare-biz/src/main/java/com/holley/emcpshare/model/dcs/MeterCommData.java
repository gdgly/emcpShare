package com.holley.emcpshare.model.dcs;

import java.util.HashMap;
import java.util.Map;

public class MeterCommData {

    private int                 number;     // 电表顺序号
    private String              commaddress; // 表号
    private int                 days;       // 连续日数
    private Map<String, String> dataMap;    // 数据项
    private int                 year;       // 年
    private int                 month;      // 月
    private int                 day;        // 日

    public MeterCommData() {
        dataMap = new HashMap<String, String>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Map<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    public String getCommaddress() {
        return commaddress;
    }

    public void setCommaddress(String commaddress) {
        this.commaddress = commaddress;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

}
