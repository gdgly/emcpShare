package com.holley.emcpshare.model;

import java.util.Date;

import com.holley.emcpshare.model.def.ExtendPowerBmEid;

public class DatPowerBmKey extends ExtendPowerBmEid {

    private Date    datatime;

    private Short   phasetype;

    private Integer pointid;

    private Short   tarriftypeid;

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public Short getPhasetype() {
        return phasetype;
    }

    public void setPhasetype(Short phasetype) {
        this.phasetype = phasetype;
    }

    public Integer getPointid() {
        return pointid;
    }

    public void setPointid(Integer pointid) {
        this.pointid = pointid;
    }

    public Short getTarriftypeid() {
        return tarriftypeid;
    }

    public void setTarriftypeid(Short tarriftypeid) {
        this.tarriftypeid = tarriftypeid;
    }
}
