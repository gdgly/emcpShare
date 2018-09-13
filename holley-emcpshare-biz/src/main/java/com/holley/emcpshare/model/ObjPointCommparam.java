package com.holley.emcpshare.model;

public class ObjPointCommparam {
    private Integer pointid;

    private Integer rtuid;

    private String commaddr;

    private Short protocolid;

    private String pwd;

    private Short commtypeid;

    private Short numberid;

    private String sampleinterval;

    private Short disconnectmode;

    private String safetylevel;

    private String safetypwd;

    private Short powerstatus;

    public Integer getPointid() {
        return pointid;
    }

    public void setPointid(Integer pointid) {
        this.pointid = pointid;
    }

    public Integer getRtuid() {
        return rtuid;
    }

    public void setRtuid(Integer rtuid) {
        this.rtuid = rtuid;
    }

    public String getCommaddr() {
        return commaddr;
    }

    public void setCommaddr(String commaddr) {
        this.commaddr = commaddr == null ? null : commaddr.trim();
    }

    public Short getProtocolid() {
        return protocolid;
    }

    public void setProtocolid(Short protocolid) {
        this.protocolid = protocolid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Short getCommtypeid() {
        return commtypeid;
    }

    public void setCommtypeid(Short commtypeid) {
        this.commtypeid = commtypeid;
    }

    public Short getNumberid() {
        return numberid;
    }

    public void setNumberid(Short numberid) {
        this.numberid = numberid;
    }

    public String getSampleinterval() {
        return sampleinterval;
    }

    public void setSampleinterval(String sampleinterval) {
        this.sampleinterval = sampleinterval == null ? null : sampleinterval.trim();
    }

    public Short getDisconnectmode() {
        return disconnectmode;
    }

    public void setDisconnectmode(Short disconnectmode) {
        this.disconnectmode = disconnectmode;
    }

    public String getSafetylevel() {
        return safetylevel;
    }

    public void setSafetylevel(String safetylevel) {
        this.safetylevel = safetylevel == null ? null : safetylevel.trim();
    }

    public String getSafetypwd() {
        return safetypwd;
    }

    public void setSafetypwd(String safetypwd) {
        this.safetypwd = safetypwd == null ? null : safetypwd.trim();
    }

    public Short getPowerstatus() {
        return powerstatus;
    }

    public void setPowerstatus(Short powerstatus) {
        this.powerstatus = powerstatus;
    }
}