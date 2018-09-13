package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.Date;

public class IcmPurchaseHis extends IcmPurchaseHisKey {
    private Integer buyCount;

    private BigDecimal surplusMoney;

    private BigDecimal totalBuyMoney;

    private BigDecimal surplusEnergy;

    private BigDecimal overdrawEnergy;

    private BigDecimal totalBuyEnergy;

    private BigDecimal creditEnergyLimit;

    private BigDecimal alarmEnergy;

    private BigDecimal faultEnergy;

    private BigDecimal rate;

    private Short dataSource;

    private Date addTime;

    private Date updateTime;

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public BigDecimal getSurplusMoney() {
        return surplusMoney;
    }

    public void setSurplusMoney(BigDecimal surplusMoney) {
        this.surplusMoney = surplusMoney;
    }

    public BigDecimal getTotalBuyMoney() {
        return totalBuyMoney;
    }

    public void setTotalBuyMoney(BigDecimal totalBuyMoney) {
        this.totalBuyMoney = totalBuyMoney;
    }

    public BigDecimal getSurplusEnergy() {
        return surplusEnergy;
    }

    public void setSurplusEnergy(BigDecimal surplusEnergy) {
        this.surplusEnergy = surplusEnergy;
    }

    public BigDecimal getOverdrawEnergy() {
        return overdrawEnergy;
    }

    public void setOverdrawEnergy(BigDecimal overdrawEnergy) {
        this.overdrawEnergy = overdrawEnergy;
    }

    public BigDecimal getTotalBuyEnergy() {
        return totalBuyEnergy;
    }

    public void setTotalBuyEnergy(BigDecimal totalBuyEnergy) {
        this.totalBuyEnergy = totalBuyEnergy;
    }

    public BigDecimal getCreditEnergyLimit() {
        return creditEnergyLimit;
    }

    public void setCreditEnergyLimit(BigDecimal creditEnergyLimit) {
        this.creditEnergyLimit = creditEnergyLimit;
    }

    public BigDecimal getAlarmEnergy() {
        return alarmEnergy;
    }

    public void setAlarmEnergy(BigDecimal alarmEnergy) {
        this.alarmEnergy = alarmEnergy;
    }

    public BigDecimal getFaultEnergy() {
        return faultEnergy;
    }

    public void setFaultEnergy(BigDecimal faultEnergy) {
        this.faultEnergy = faultEnergy;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Short getDataSource() {
        return dataSource;
    }

    public void setDataSource(Short dataSource) {
        this.dataSource = dataSource;
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