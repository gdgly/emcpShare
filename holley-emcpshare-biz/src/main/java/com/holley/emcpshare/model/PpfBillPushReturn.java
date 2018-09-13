package com.holley.emcpshare.model;

import java.util.Date;

public class PpfBillPushReturn {
    private Date addTime;

    private Short type;

    private Short energyType;

    private String content;

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getEnergyType() {
        return energyType;
    }

    public void setEnergyType(Short energyType) {
        this.energyType = energyType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}