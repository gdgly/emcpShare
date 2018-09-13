package com.holley.emcpshare.model.dcs;

import java.util.ArrayList;
import java.util.List;

public abstract class PackParamResultBaseBean {

    protected List<Integer>    rtuIdList    = new ArrayList<Integer>();
    protected String           pnStr;
    protected List<GWItemData> itemDataList = new ArrayList<GWItemData>();
    private String             validtime;
    private boolean            isSuccess    = true;
    private String             msg;

    public List<Integer> getRtuIdList() {
        return rtuIdList;
    }

    public void setRtuIdList(List<Integer> rtuIdList) {
        this.rtuIdList = rtuIdList;
    }

    public String getPnStr() {
        return pnStr;
    }

    public void setPnStr(String pnStr) {
        this.pnStr = pnStr;
    }

    public List<GWItemData> getItemDataList() {
        return itemDataList;
    }

    public void setItemDataList(List<GWItemData> itemDataList) {
        this.itemDataList = itemDataList;
    }

    public String getValidtime() {
        return validtime;
    }

    public void setValidtime(String validtime) {
        this.validtime = validtime;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
