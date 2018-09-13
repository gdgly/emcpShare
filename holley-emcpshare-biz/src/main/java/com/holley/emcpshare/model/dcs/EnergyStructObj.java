package com.holley.emcpshare.model.dcs;

import com.holley.emcp.common.dataobjects.TreeNode;

public class EnergyStructObj extends TreeNode {

    private Integer ownerid;
    private Short   ownertype;

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public Short getOwnertype() {
        return ownertype;
    }

    public void setOwnertype(Short ownertype) {
        this.ownertype = ownertype;
    }

}
