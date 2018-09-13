package com.holley.emcpshare.model.def;

import java.math.BigDecimal;
import java.util.Date;

public class HongQiaoJiChangPowerZhBmVO {

    private String     pointId;     // 表编码
    private Date       dataTime;    // 数据时间
    private Short      tarriftypeId; // 类型总，尖，峰，平，谷
    private BigDecimal pf;          // 功率因数
    private BigDecimal zhybm;       // 组合有bm
    private BigDecimal zhwbm;       // 组合无bm
    private String     rtuName;     // 终端名称

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Short getTarriftypeId() {
        return tarriftypeId;
    }

    public void setTarriftypeId(Short tarriftypeId) {
        this.tarriftypeId = tarriftypeId;
    }

    public BigDecimal getPf() {
        return pf;
    }

    public void setPf(BigDecimal pf) {
        this.pf = pf;
    }

    public BigDecimal getZhybm() {
        return zhybm;
    }

    public void setZhybm(BigDecimal zhybm) {
        this.zhybm = zhybm;
    }

    public BigDecimal getZhwbm() {
        return zhwbm;
    }

    public void setZhwbm(BigDecimal zhwbm) {
        this.zhwbm = zhwbm;
    }

    public String getRtuName() {
        return rtuName;
    }

    public void setRtuName(String rtuName) {
        this.rtuName = rtuName;
    }

}
