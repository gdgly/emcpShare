package com.holley.emcpshare.model.bank;

import java.math.BigDecimal;
import java.util.Date;

public class BankSurchargeVo {

    private Integer    customerId;
    private BigDecimal fee;
    private Date       dataTime;
    private Integer    cutCount;
    private Date       addTime;
    private Date       updateTime;
    private Short      energyType;

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

    public Integer getCutCount() {
        return cutCount;
    }

    public void setCutCount(Integer cutCount) {
        this.cutCount = cutCount;
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

    public Short getEnergyType() {
        return energyType;
    }

    public void setEnergyType(Short energyType) {
        this.energyType = energyType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

}
