package com.holley.emcpshare.model.common;

import com.holley.emcpshare.model.SysAccount;

public class SysAccountDetailVO extends SysAccount {

    private String enterpriseName;// 企业名称

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

}
