package com.holley.emcpshare.model.def;

import java.util.List;

/**
 * 国久接口项目
 * 
 * @author lenovo
 */
public class GuoJiuPowerBmInfoBase {

    private String                       organizationCode; // 组织机构代码
    private List<GuoJiuPointPowerBmInfo> data;

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public List<GuoJiuPointPowerBmInfo> getData() {
        return data;
    }

    public void setData(List<GuoJiuPointPowerBmInfo> data) {
        this.data = data;
    }

}
