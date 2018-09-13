package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

/**
 * 国久接口项目
 * 
 * @author lenovo
 */
public class GuoJiuOtherBmInfo {

    private String     dataTime;    // 地址
    private BigDecimal readingPower; // 表码

    public GuoJiuOtherBmInfo(String dataTime, BigDecimal readingPower) {
        this.dataTime = dataTime;
        this.readingPower = readingPower;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public BigDecimal getReadingPower() {
        return readingPower;
    }

    public void setReadingPower(BigDecimal readingPower) {
        this.readingPower = readingPower;
    }

}
