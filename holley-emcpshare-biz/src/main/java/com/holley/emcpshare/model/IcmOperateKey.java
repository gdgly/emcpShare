package com.holley.emcpshare.model;

import java.util.Date;

public class IcmOperateKey {
    private Date operateTime;

    private Integer pointId;

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }
}