package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

public class MonthlyPowerBillInfo {

    private String     pointId;         // 设备编码
    private String     dataTime;        // YYYY-MM

    private BigDecimal zongStart;       // 总起码
    private BigDecimal zongEnd;         // 总止码
    private BigDecimal zongPower;       // 总电量
    private BigDecimal zongMoney;       // 总金额

    private BigDecimal jianStart;       // 尖起码
    private BigDecimal jianEnd;         // 尖止码
    private BigDecimal jianPower;       // 尖电量
    private BigDecimal jianMoney;       // 尖金额

    private BigDecimal fengStart;       // 峰起码
    private BigDecimal fengEnd;         // 峰止码
    private BigDecimal fengPower;       // 峰电量
    private BigDecimal fengMoney;       // 峰金额

    private BigDecimal pingStart;       // 平起码
    private BigDecimal pingEnd;         // 平止码
    private BigDecimal pingPower;       // 平电量
    private BigDecimal pingMoney;       // 平金额

    private BigDecimal guStart;         // 谷起码
    private BigDecimal guEnd;           // 谷止码
    private BigDecimal guPower;         // 谷电量
    private BigDecimal guMoney;         // 谷金额

    private BigDecimal multiplyingPower; // 倍率
    private BigDecimal totalPower;      // 合计电量
    private BigDecimal totalMoney;      // 合计电费

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public BigDecimal getZongStart() {
        return zongStart;
    }

    public void setZongStart(BigDecimal zongStart) {
        this.zongStart = zongStart;
    }

    public BigDecimal getZongEnd() {
        return zongEnd;
    }

    public void setZongEnd(BigDecimal zongEnd) {
        this.zongEnd = zongEnd;
    }

    public BigDecimal getZongPower() {
        return zongPower;
    }

    public void setZongPower(BigDecimal zongPower) {
        this.zongPower = zongPower;
    }

    public BigDecimal getZongMoney() {
        return zongMoney;
    }

    public void setZongMoney(BigDecimal zongMoney) {
        this.zongMoney = zongMoney;
    }

    public BigDecimal getJianStart() {
        return jianStart;
    }

    public void setJianStart(BigDecimal jianStart) {
        this.jianStart = jianStart;
    }

    public BigDecimal getJianEnd() {
        return jianEnd;
    }

    public void setJianEnd(BigDecimal jianEnd) {
        this.jianEnd = jianEnd;
    }

    public BigDecimal getJianPower() {
        return jianPower;
    }

    public void setJianPower(BigDecimal jianPower) {
        this.jianPower = jianPower;
    }

    public BigDecimal getJianMoney() {
        return jianMoney;
    }

    public void setJianMoney(BigDecimal jianMoney) {
        this.jianMoney = jianMoney;
    }

    public BigDecimal getFengStart() {
        return fengStart;
    }

    public void setFengStart(BigDecimal fengStart) {
        this.fengStart = fengStart;
    }

    public BigDecimal getFengEnd() {
        return fengEnd;
    }

    public void setFengEnd(BigDecimal fengEnd) {
        this.fengEnd = fengEnd;
    }

    public BigDecimal getFengPower() {
        return fengPower;
    }

    public void setFengPower(BigDecimal fengPower) {
        this.fengPower = fengPower;
    }

    public BigDecimal getFengMoney() {
        return fengMoney;
    }

    public void setFengMoney(BigDecimal fengMoney) {
        this.fengMoney = fengMoney;
    }

    public BigDecimal getPingStart() {
        return pingStart;
    }

    public void setPingStart(BigDecimal pingStart) {
        this.pingStart = pingStart;
    }

    public BigDecimal getPingEnd() {
        return pingEnd;
    }

    public void setPingEnd(BigDecimal pingEnd) {
        this.pingEnd = pingEnd;
    }

    public BigDecimal getPingPower() {
        return pingPower;
    }

    public void setPingPower(BigDecimal pingPower) {
        this.pingPower = pingPower;
    }

    public BigDecimal getPingMoney() {
        return pingMoney;
    }

    public void setPingMoney(BigDecimal pingMoney) {
        this.pingMoney = pingMoney;
    }

    public BigDecimal getGuStart() {
        return guStart;
    }

    public void setGuStart(BigDecimal guStart) {
        this.guStart = guStart;
    }

    public BigDecimal getGuEnd() {
        return guEnd;
    }

    public void setGuEnd(BigDecimal guEnd) {
        this.guEnd = guEnd;
    }

    public BigDecimal getGuPower() {
        return guPower;
    }

    public void setGuPower(BigDecimal guPower) {
        this.guPower = guPower;
    }

    public BigDecimal getGuMoney() {
        return guMoney;
    }

    public void setGuMoney(BigDecimal guMoney) {
        this.guMoney = guMoney;
    }

    public BigDecimal getMultiplyingPower() {
        return multiplyingPower;
    }

    public void setMultiplyingPower(BigDecimal multiplyingPower) {
        this.multiplyingPower = multiplyingPower;
    }

    public BigDecimal getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(BigDecimal totalPower) {
        this.totalPower = totalPower;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

}
