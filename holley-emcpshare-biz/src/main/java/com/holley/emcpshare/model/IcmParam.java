package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.Date;

public class IcmParam {

    private Integer    pointId;

    private String     meterNo;

    private String     factoryNo;

    private BigDecimal alarmEnergyLimit;

    private BigDecimal hoardEnergyLimit;

    private BigDecimal creditEnergyLimit;

    private BigDecimal pLimit;

    private String     registerNo;

    private Date       startTime;

    private Integer    customerId;

    private String     customerNo;

    private Integer    cardCount;

    private Integer    buyCount;

    private BigDecimal surplusEnergy;

    private BigDecimal overdrawEnergy;

    private BigDecimal totalBuyEnergy;

    private BigDecimal rate;

    private Date       updateTime;

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo == null ? null : meterNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public BigDecimal getAlarmEnergyLimit() {
        return alarmEnergyLimit;
    }

    public void setAlarmEnergyLimit(BigDecimal alarmEnergyLimit) {
        this.alarmEnergyLimit = alarmEnergyLimit;
    }

    public BigDecimal getHoardEnergyLimit() {
        return hoardEnergyLimit;
    }

    public void setHoardEnergyLimit(BigDecimal hoardEnergyLimit) {
        this.hoardEnergyLimit = hoardEnergyLimit;
    }

    public BigDecimal getCreditEnergyLimit() {
        return creditEnergyLimit;
    }

    public void setCreditEnergyLimit(BigDecimal creditEnergyLimit) {
        this.creditEnergyLimit = creditEnergyLimit;
    }

    public BigDecimal getpLimit() {
        return pLimit;
    }

    public void setpLimit(BigDecimal pLimit) {
        this.pLimit = pLimit;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo == null ? null : registerNo.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    public Integer getCardCount() {
        return cardCount;
    }

    public void setCardCount(Integer cardCount) {
        this.cardCount = cardCount;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
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

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
