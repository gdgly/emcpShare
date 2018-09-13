package com.holley.emcpshare.model;

public class ViewPoint extends ViewPointKey {
    private String objname;

    private String ownername;

    public String getObjname() {
        return objname;
    }

    public void setObjname(String objname) {
        this.objname = objname == null ? null : objname.trim();
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername == null ? null : ownername.trim();
    }
}