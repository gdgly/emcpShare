package com.holley.emcpshare.model.def;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 国久接口项目
 * 
 * @author lenovo
 */
public class GuoJiuPowerBmVO {

    private String     address;     // 地址
    private String     name;        // 表名称
    private String     pointId;     // 表编码
    private Date       dataTime;    // 地址
    private BigDecimal readingPower; // 表码
    private Short      tag;         // 总，尖，峰，平，谷

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

}
