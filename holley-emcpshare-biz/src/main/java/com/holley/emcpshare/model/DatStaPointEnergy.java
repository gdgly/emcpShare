package com.holley.emcpshare.model;

import java.math.BigDecimal;

public class DatStaPointEnergy extends DatStaPointEnergyKey {
    private BigDecimal energyQ;

    private BigDecimal energyP;

    private BigDecimal energyZy;

    private BigDecimal energyFy;

    private BigDecimal energyZw;

    private BigDecimal energyFw;

    private Short prop;

    private String remark;

    public BigDecimal getEnergyQ() {
        return energyQ;
    }

    public void setEnergyQ(BigDecimal energyQ) {
        this.energyQ = energyQ;
    }

    public BigDecimal getEnergyP() {
        return energyP;
    }

    public void setEnergyP(BigDecimal energyP) {
        this.energyP = energyP;
    }

    public BigDecimal getEnergyZy() {
        return energyZy;
    }

    public void setEnergyZy(BigDecimal energyZy) {
        this.energyZy = energyZy;
    }

    public BigDecimal getEnergyFy() {
        return energyFy;
    }

    public void setEnergyFy(BigDecimal energyFy) {
        this.energyFy = energyFy;
    }

    public BigDecimal getEnergyZw() {
        return energyZw;
    }

    public void setEnergyZw(BigDecimal energyZw) {
        this.energyZw = energyZw;
    }

    public BigDecimal getEnergyFw() {
        return energyFw;
    }

    public void setEnergyFw(BigDecimal energyFw) {
        this.energyFw = energyFw;
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