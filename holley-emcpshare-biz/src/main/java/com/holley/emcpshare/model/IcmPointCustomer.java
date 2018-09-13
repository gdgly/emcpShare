package com.holley.emcpshare.model;

import java.util.Date;

public class IcmPointCustomer extends IcmPointCustomerKey {
    private Date endTime;

    private Date addTime;

    private Date updateTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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