package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.Date;

public class IcmOperate extends IcmOperateKey {
    private Short operateType;

    private String meterNo;

    private String factoryNo;

    private BigDecimal buyMoney;

    private BigDecimal buyEnergy;

    private Integer buyCount;

    private BigDecimal alarmEnergyLimit;

    private BigDecimal hoardEnergyLimit;

    private BigDecimal creditEnergyLimit;

    private BigDecimal pLimit;

    private Integer customerId;

    private String customerNo;

    private String registerNo;

    private String operatorNo;

    private BigDecimal rate;

    private Short operateMode;

    private String account;

    private Short status;

    private String errorCode;

    private String errorMsg;

    private Date addTime;

    private Date updateTime;

    public Short getOperateType() {
        return operateType;
    }

    public void setOperateType(Short operateType) {
        this.operateType = operateType;
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

    public BigDecimal getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(BigDecimal buyMoney) {
        this.buyMoney = buyMoney;
    }

    public BigDecimal getBuyEnergy() {
        return buyEnergy;
    }

    public void setBuyEnergy(BigDecimal buyEnergy) {
        this.buyEnergy = buyEnergy;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
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

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo == null ? null : registerNo.trim();
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Short getOperateMode() {
        return operateMode;
    }

    public void setOperateMode(Short operateMode) {
        this.operateMode = operateMode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
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