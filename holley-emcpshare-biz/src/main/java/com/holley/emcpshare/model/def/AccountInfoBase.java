package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

public class AccountInfoBase {

    private String     userId;      // hh
    private BigDecimal totalmoney;

    private BigDecimal usablemoney;

    private BigDecimal freezemoney;

    private BigDecimal freezemoney2;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    public BigDecimal getUsablemoney() {
        return usablemoney;
    }

    public void setUsablemoney(BigDecimal usablemoney) {
        this.usablemoney = usablemoney;
    }

    public BigDecimal getFreezemoney() {
        return freezemoney;
    }

    public void setFreezemoney(BigDecimal freezemoney) {
        this.freezemoney = freezemoney;
    }

    public BigDecimal getFreezemoney2() {
        return freezemoney2;
    }

    public void setFreezemoney2(BigDecimal freezemoney2) {
        this.freezemoney2 = freezemoney2;
    }

}
