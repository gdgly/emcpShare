package com.holley.emcpshare.model;

import java.util.Date;

public class DatStaPointEnergyKey {
    private Short circletypeid;

    private Date datatime;

    private Integer pointid;

    private Short tarriftypeid;

    public Short getCircletypeid() {
        return circletypeid;
    }

    public void setCircletypeid(Short circletypeid) {
        this.circletypeid = circletypeid;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
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