package com.holley.emcpshare.model.def;

import java.util.List;

/**
 * 国久接口项目
 * 
 * @author lenovo
 */
public class GuoJiuOtherBmInfoBase {

    private String                       organizationCode; // 组织机构代码
    private List<GuoJiuPointOtherBmInfo> data;

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public List<GuoJiuPointOtherBmInfo> getData() {
        return data;
    }

    public void setData(List<GuoJiuPointOtherBmInfo> data) {
        this.data = data;
    }

}
