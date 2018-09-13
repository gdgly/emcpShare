package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.Date;

public class PpfCustomerFeeMonthOther extends PpfCustomerFeeMonthOtherKey {
    private BigDecimal fee;

    private Short status;

    private BigDecimal usablemoney;

    private Date addtime;

    private Date billtime;

    private Short cutstatus;

    private Date cuttime;

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigDecimal getUsablemoney() {
        return usablemoney;
    }

    public void setUsablemoney(BigDecimal usablemoney) {
        this.usablemoney = usablemoney;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getBilltime() {
        return billtime;
    }

    public void setBilltime(Date billtime) {
        this.billtime = billtime;
    }

    public Short getCutstatus() {
        return cutstatus;
    }

    public void setCutstatus(Short cutstatus) {
        this.cutstatus = cutstatus;
    }

    public Date getCuttime() {
        return cuttime;
    }

    public void setCuttime(Date cuttime) {
        this.cuttime = cuttime;
    }
}