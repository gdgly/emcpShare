package com.holley.emcpshare.model.dcs;

public class RtuPackParamResultBean extends PackParamResultBaseBean {

    private String pointStr;
    private String pointTypeStr;
    private String portStr;
    private String commaddressStr;
    private String baud = "";
    private String result;        // 结果返回

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPointStr() {
        return pointStr;
    }

    public void setPointStr(String pointStr) {
        this.pointStr = pointStr;
    }

    public String getPointTypeStr() {
        return pointTypeStr;
    }

    public void setPointTypeStr(String pointTypeStr) {
        this.pointTypeStr = pointTypeStr;
    }

    public String getPortStr() {
        return portStr;
    }

    public void setPortStr(String portStr) {
        this.portStr = portStr;
    }

    public String getCommaddressStr() {
        return commaddressStr;
    }

    public void setCommaddressStr(String commaddressStr) {
        this.commaddressStr = commaddressStr;
    }

    public String getBaud() {
        return baud;
    }

    public void setBaud(String baud) {
        this.baud = baud;
    }

}
