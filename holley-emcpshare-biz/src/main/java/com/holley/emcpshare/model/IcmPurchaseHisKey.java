package com.holley.emcpshare.model;

import java.util.Date;

public class IcmPurchaseHisKey {
    private Date dataTime;

    private Integer pointId;

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }
}