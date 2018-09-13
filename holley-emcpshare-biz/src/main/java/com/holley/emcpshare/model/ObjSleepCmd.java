package com.holley.emcpshare.model;

import java.util.Date;

public class ObjSleepCmd extends ObjSleepCmdKey {
    private Short sendtype;

    private String params;

    private Short status;

    private Date executetime;

    private String remark;

    public Short getSendtype() {
        return sendtype;
    }

    public void setSendtype(Short sendtype) {
        this.sendtype = sendtype;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getExecutetime() {
        return executetime;
    }

    public void setExecutetime(Date executetime) {
        this.executetime = executetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}