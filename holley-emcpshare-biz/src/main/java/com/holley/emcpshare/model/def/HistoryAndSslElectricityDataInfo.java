package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

public class HistoryAndSslElectricityDataInfo {

    private String     pointId;
    private BigDecimal zongBm;     // 总表码
    private BigDecimal jianBm;     // 尖表码
    private BigDecimal fengBm;     // 峰表码
    private BigDecimal pingBm;     // 平表码
    private BigDecimal guBm;       // 谷表码
    private String     bmDataTime; // yyyy-MM-dd HH:mm:ss 表码数据时间
    private BigDecimal p;          // 有功功率
    private BigDecimal q;          // 无功功率
    private BigDecimal ia;         // A相电流
    private BigDecimal ib;         // B相电流
    private BigDecimal ic;         // C相电流
    private BigDecimal ua;         // A相电压
    private BigDecimal ub;         // B相电压
    private BigDecimal uc;         // C相电压
    private BigDecimal pf;         // 功率因数
    private String     sslDataTime; // yyyy-MM-dd HH:mm:ss 损失量数据时间

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public BigDecimal getZongBm() {
        return zongBm;
    }

    public void setZongBm(BigDecimal zongBm) {
        this.zongBm = zongBm;
    }

    public BigDecimal getJianBm() {
        return jianBm;
    }

    public void setJianBm(BigDecimal jianBm) {
        this.jianBm = jianBm;
    }

    public BigDecimal getFengBm() {
        return fengBm;
    }

    public void setFengBm(BigDecimal fengBm) {
        this.fengBm = fengBm;
    }

    public BigDecimal getPingBm() {
        return pingBm;
    }

    public void setPingBm(BigDecimal pingBm) {
        this.pingBm = pingBm;
    }

    public BigDecimal getGuBm() {
        return guBm;
    }

    public void setGuBm(BigDecimal guBm) {
        this.guBm = guBm;
    }

    public String getBmDataTime() {
        return bmDataTime;
    }

    public void setBmDataTime(String bmDataTime) {
        this.bmDataTime = bmDataTime;
    }

    public BigDecimal getP() {
        return p;
    }

    public void setP(BigDecimal p) {
        this.p = p;
    }

    public BigDecimal getQ() {
        return q;
    }

    public void setQ(BigDecimal q) {
        this.q = q;
    }

    public BigDecimal getIa() {
        return ia;
    }

    public void setIa(BigDecimal ia) {
        this.ia = ia;
    }

    public BigDecimal getIb() {
        return ib;
    }

    public void setIb(BigDecimal ib) {
        this.ib = ib;
    }

    public BigDecimal getIc() {
        return ic;
    }

    public void setIc(BigDecimal ic) {
        this.ic = ic;
    }

    public BigDecimal getUa() {
        return ua;
    }

    public void setUa(BigDecimal ua) {
        this.ua = ua;
    }

    public BigDecimal getUb() {
        return ub;
    }

    public void setUb(BigDecimal ub) {
        this.ub = ub;
    }

    public BigDecimal getUc() {
        return uc;
    }

    public void setUc(BigDecimal uc) {
        this.uc = uc;
    }

    public BigDecimal getPf() {
        return pf;
    }

    public void setPf(BigDecimal pf) {
        this.pf = pf;
    }

    public String getSslDataTime() {
        return sslDataTime;
    }

    public void setSslDataTime(String sslDataTime) {
        this.sslDataTime = sslDataTime;
    }

}
