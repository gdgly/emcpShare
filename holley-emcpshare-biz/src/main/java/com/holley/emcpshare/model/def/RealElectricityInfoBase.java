package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

/**
 * 电表实时数据信息
 * 
 * @author sc
 */
public class RealElectricityInfoBase {

    private String     pointId;
    private BigDecimal bm;       // 表码
    private Integer    status;   // 拉合闸状态1：拉闸2：合闸
    private Integer    frequency; // 数据上报周期 15分钟，20分钟，60分钟
    private String     dataTime;

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public BigDecimal getBm() {
        return bm;
    }

    public void setBm(BigDecimal bm) {
        this.bm = bm;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

}
