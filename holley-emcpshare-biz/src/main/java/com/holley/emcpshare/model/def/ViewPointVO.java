package com.holley.emcpshare.model.def;

import com.holley.emcpshare.model.ViewPoint;

public class ViewPointVO extends ViewPoint {

    private String address;
    private String pointName;
    private String commaddr;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getCommaddr() {
        return commaddr;
    }

    public void setCommaddr(String commaddr) {
        this.commaddr = commaddr;
    }

}
