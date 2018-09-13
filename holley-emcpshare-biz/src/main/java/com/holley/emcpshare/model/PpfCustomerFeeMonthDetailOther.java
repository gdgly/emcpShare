package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.Date;

public class PpfCustomerFeeMonthDetailOther extends PpfCustomerFeeMonthDetailOtherKey {
    private Date endtime;

    private BigDecimal used;

    private BigDecimal fee;

    private Short percent;

    private Integer priceid;

    private Date startbmtime;

    private BigDecimal startbm;

    private Date endbmtime;

    private BigDecimal endbm;

    private BigDecimal rate;

    private Short status;

    private Short energytype;

    private Date updatetime;

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Short getPercent() {
        return percent;
    }

    public void setPercent(Short percent) {
        this.percent = percent;
    }

    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }

    public Date getStartbmtime() {
        return startbmtime;
    }

    public void setStartbmtime(Date startbmtime) {
        this.startbmtime = startbmtime;
    }

    public BigDecimal getStartbm() {
        return startbm;
    }

    public void setStartbm(BigDecimal startbm) {
        this.startbm = startbm;
    }

    public Date getEndbmtime() {
        return endbmtime;
    }

    public void setEndbmtime(Date endbmtime) {
        this.endbmtime = endbmtime;
    }

    public BigDecimal getEndbm() {
        return endbm;
    }

    public void setEndbm(BigDecimal endbm) {
        this.endbm = endbm;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getEnergytype() {
        return energytype;
    }

    public void setEnergytype(Short energytype) {
        this.energytype = energytype;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}