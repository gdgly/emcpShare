package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.Date;

public class PpfSurcharge extends PpfSurchargeKey {
    private Short calcCount;

    private BigDecimal fee;

    private BigDecimal money;

    private Date startTime;

    private Date endTime;

    private Date updateTime;

    public Short getCalcCount() {
        return calcCount;
    }

    public void setCalcCount(Short calcCount) {
        this.calcCount = calcCount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}