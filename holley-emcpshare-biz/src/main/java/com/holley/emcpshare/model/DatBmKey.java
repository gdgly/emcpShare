package com.holley.emcpshare.model;

import java.util.Date;

public class DatBmKey {
    private Short dataitem;

    private Date datatime;

    private Short energytype;

    private Integer pointid;

    public Short getDataitem() {
        return dataitem;
    }

    public void setDataitem(Short dataitem) {
        this.dataitem = dataitem;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public Short getEnergytype() {
        return energytype;
    }

    public void setEnergytype(Short energytype) {
        this.energytype = energytype;
    }

    public Integer getPointid() {
        return pointid;
    }

    public void setPointid(Integer pointid) {
        this.pointid = pointid;
    }
}