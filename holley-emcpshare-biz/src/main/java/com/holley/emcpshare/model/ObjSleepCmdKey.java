package com.holley.emcpshare.model;

import java.util.Date;

public class ObjSleepCmdKey {
    private Short cmdtype;

    private Date createtime;

    private Integer objid;

    private Short objtype;

    public Short getCmdtype() {
        return cmdtype;
    }

    public void setCmdtype(Short cmdtype) {
        this.cmdtype = cmdtype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }

    public Short getObjtype() {
        return objtype;
    }

    public void setObjtype(Short objtype) {
        this.objtype = objtype;
    }
}