package com.holley.emcpshare.model;

import java.math.BigDecimal;

public class DatStaPointUsed extends DatStaPointUsedKey {
    private BigDecimal used;

    private Short prop;

    private String remark;

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    public Short getProp() {
        return prop;
    }

    public void setProp(Short prop) {
        this.prop = prop;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}