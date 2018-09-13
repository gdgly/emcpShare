package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.Date;

public class DatBm extends DatBmKey {
    private BigDecimal bm;

    private Date olddatatime;

    public BigDecimal getBm() {
        return bm;
    }

    public void setBm(BigDecimal bm) {
        this.bm = bm;
    }

    public Date getOlddatatime() {
        return olddatatime;
    }

    public void setOlddatatime(Date olddatatime) {
        this.olddatatime = olddatatime;
    }
}