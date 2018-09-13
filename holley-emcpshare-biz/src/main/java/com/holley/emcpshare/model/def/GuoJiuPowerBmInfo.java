package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

/**
 * 国久接口项目
 * 
 * @author lenovo
 */
public class GuoJiuPowerBmInfo {

    private String     dataTime;    // 地址
    private BigDecimal readingPower; // 表码
    private Short      tag;         // 总，尖，峰，平，谷

    public GuoJiuPowerBmInfo(String dataTime, BigDecimal readingPower, Short tag) {
        this.dataTime = dataTime;
        this.readingPower = readingPower;
        this.tag = tag;
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

    public Short getTag() {
        return tag;
    }

    public void setTag(Short tag) {
        this.tag = tag;
    }

}
