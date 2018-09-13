package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

public class MonthlyWaterBillInfo {

    private String     pointId;         // 设备编码
    private String     dataTime;        // YYYY-MM
    private BigDecimal start;           // 起码
    private BigDecimal end;             // 止码
    private BigDecimal multiplyingPower; // 倍率
    private BigDecimal totalPower;      // 合计水量
    private BigDecimal totalMoney;      // 合计水费

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

    public BigDecimal getStart() {
        return start;
    }

    public void setStart(BigDecimal start) {
        this.start = start;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public void setEnd(BigDecimal end) {
        this.end = end;
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
