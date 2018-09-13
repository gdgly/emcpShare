package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

public class DayPowerOrWaterDataInfo {

    private String     pointId;
    private String     dataTime;
    private BigDecimal data;

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

    public BigDecimal getData() {
        return data;
    }

    public void setData(BigDecimal data) {
        this.data = data;
    }

}
