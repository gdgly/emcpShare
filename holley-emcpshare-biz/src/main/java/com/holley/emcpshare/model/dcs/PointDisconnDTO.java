package com.holley.emcpshare.model.dcs;

public class PointDisconnDTO {

    private Integer pointid;
    private String  disc;
    private Integer pn;                // 测量点号
    private Integer commport;          // 通信端口号
    private Integer commrate;          // 通信速率
    private Integer protocol;          // 表规约
    private String  commaddr;          // 通信地址
    private String  commpwd;           // 通信密码
    private String  typenum;           // 表类型
    private Short   disconnectmode;    // 拉合闸模式
    private String  disconnectmodename; // 拉合闸模式名称
    private String  safetylevel;       // 安全认证等级(密级)
    private String  safetypwd;         // 密码
    private Short   powerstatus;       // 上电状态
    private String  powerstatusname;   // 上电状态描述

    public Integer getPointid() {
        return pointid;
    }

    public void setPointid(Integer pointid) {
        this.pointid = pointid;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public Integer getPn() {
        return pn;
    }

    public void setPn(Integer pn) {
        this.pn = pn;
    }

    public Integer getCommport() {
        return commport;
    }

    public void setCommport(Integer commport) {
        this.commport = commport;
    }

    public Integer getCommrate() {
        return commrate;
    }

    public void setCommrate(Integer commrate) {
        this.commrate = commrate;
    }

    public Integer getProtocol() {
        return protocol;
    }

    public void setProtocol(Integer protocol) {
        this.protocol = protocol;
    }

    public String getCommaddr() {
        return commaddr;
    }

    public void setCommaddr(String commaddr) {
        this.commaddr = commaddr;
    }

    public String getCommpwd() {
        return commpwd;
    }

    public void setCommpwd(String commpwd) {
        this.commpwd = commpwd;
    }

    public String getTypenum() {
        return typenum;
    }

    public void setTypenum(String typenum) {
        this.typenum = typenum;
    }

    public Short getDisconnectmode() {
        return disconnectmode;
    }

    public void setDisconnectmode(Short disconnectmode) {
        this.disconnectmode = disconnectmode;
    }

    public String getDisconnectmodename() {
        return disconnectmodename;
    }

    public void setDisconnectmodename(String disconnectmodename) {
        this.disconnectmodename = disconnectmodename;
    }

    public String getSafetylevel() {
        return safetylevel;
    }

    public void setSafetylevel(String safetylevel) {
        this.safetylevel = safetylevel;
    }

    public String getSafetypwd() {
        return safetypwd;
    }

    public void setSafetypwd(String safetypwd) {
        this.safetypwd = safetypwd;
    }

    public Short getPowerstatus() {
        return powerstatus;
    }

    public void setPowerstatus(Short powerstatus) {
        this.powerstatus = powerstatus;
    }

    public String getPowerstatusname() {
        return powerstatusname;
    }

    public void setPowerstatusname(String powerstatusname) {
        this.powerstatusname = powerstatusname;
    }

}
