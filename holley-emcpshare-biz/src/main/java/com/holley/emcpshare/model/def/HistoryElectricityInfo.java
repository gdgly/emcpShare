package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

/**
 * 电表历史数据
 * 
 * @author sc
 */
public class HistoryElectricityInfo {

    private String     pointId;
    private BigDecimal bm;      // 表码
    private String     dataTime; // yyyy-MM-dd HH:mm:ss数据时间

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

}
