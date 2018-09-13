package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

/**
 * 虹桥机场接口项目
 * 
 * @author lenovo
 */
public class HongQiaoJiChangPowerZhBmInfo {

    private String     rtuName;  // 终端名称
    private String     pointId;  // 表编码
    private String     dataTime; // 数据时间
    private BigDecimal pf;       // 功率因数
    private BigDecimal zongZhybm; // 组合有功总
    private BigDecimal jianZhybm; // 组合有功尖
    private BigDecimal fengZhybm; // 组合有功峰
    private BigDecimal pingZhybm; // 组合有功平
    private BigDecimal guZhybm;  // 组合有功谷
    private BigDecimal zongZhwbm; // 组合无功总
    private BigDecimal jianZhwbm; // 组合无功尖
    private BigDecimal fengZhwbm; // 组合无功峰
    private BigDecimal pingZhwbm; // 组合无功平
    private BigDecimal guZhwbm;  // 组合无功谷

    public String getRtuName() {
        return rtuName;
    }

    public void setRtuName(String rtuName) {
        this.rtuName = rtuName;
    }

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

    public BigDecimal getPf() {
        return pf;
    }

    public void setPf(BigDecimal pf) {
        this.pf = pf;
    }

    public BigDecimal getZongZhybm() {
        return zongZhybm;
    }

    public void setZongZhybm(BigDecimal zongZhybm) {
        this.zongZhybm = zongZhybm;
    }

    public BigDecimal getJianZhybm() {
        return jianZhybm;
    }

    public void setJianZhybm(BigDecimal jianZhybm) {
        this.jianZhybm = jianZhybm;
    }

    public BigDecimal getFengZhybm() {
        return fengZhybm;
    }

    public void setFengZhybm(BigDecimal fengZhybm) {
        this.fengZhybm = fengZhybm;
    }

    public BigDecimal getPingZhybm() {
        return pingZhybm;
    }

    public void setPingZhybm(BigDecimal pingZhybm) {
        this.pingZhybm = pingZhybm;
    }

    public BigDecimal getGuZhybm() {
        return guZhybm;
    }

    public void setGuZhybm(BigDecimal guZhybm) {
        this.guZhybm = guZhybm;
    }

    public BigDecimal getZongZhwbm() {
        return zongZhwbm;
    }

    public void setZongZhwbm(BigDecimal zongZhwbm) {
        this.zongZhwbm = zongZhwbm;
    }

    public BigDecimal getJianZhwbm() {
        return jianZhwbm;
    }

    public void setJianZhwbm(BigDecimal jianZhwbm) {
        this.jianZhwbm = jianZhwbm;
    }

    public BigDecimal getFengZhwbm() {
        return fengZhwbm;
    }

    public void setFengZhwbm(BigDecimal fengZhwbm) {
        this.fengZhwbm = fengZhwbm;
    }

    public BigDecimal getPingZhwbm() {
        return pingZhwbm;
    }

    public void setPingZhwbm(BigDecimal pingZhwbm) {
        this.pingZhwbm = pingZhwbm;
    }

    public BigDecimal getGuZhwbm() {
        return guZhwbm;
    }

    public void setGuZhwbm(BigDecimal guZhwbm) {
        this.guZhwbm = guZhwbm;
    }

}
