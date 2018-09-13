package com.holley.emcpshare.model.dcs;

public class AlarmType {

    private String di;
    private String name;
    private String diName;

    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiName() {
        diName = di + ":" + name;
        return diName;
    }
}
