package com.holley.emcpshare.model;

import java.util.Date;

public class PpfSurchargeKey {
    private Integer customerId;

    private Date dataTime;

    private Short energyType;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Short getEnergyType() {
        return energyType;
    }

    public void setEnergyType(Short energyType) {
        this.energyType = energyType;
    }
}