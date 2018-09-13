package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.Date;

public class DatBmReal extends DatBmRealKey {
    private Date datatime;

    private BigDecimal bm;

    private Date olddatatime;

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

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