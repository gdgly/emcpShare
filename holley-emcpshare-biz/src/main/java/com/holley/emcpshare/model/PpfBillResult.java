package com.holley.emcpshare.model;

import java.util.Date;

public class PpfBillResult extends PpfBillResultKey {
    private Short cutCount;

    private String returnInfo;

    private Date addTime;

    private Date updateTime;

    public Short getCutCount() {
        return cutCount;
    }

    public void setCutCount(Short cutCount) {
        this.cutCount = cutCount;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo == null ? null : returnInfo.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}