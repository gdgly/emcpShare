package com.holley.emcpshare.model.dcs;

import com.holley.emcp.model.gwp.Gwp09F10;

public class PointConfGDTO extends Gwp09F10 {

    private Integer numberid;
    private Short   disconnectmode; // 拉合闸模式
    private String  safetylevel;   // 安全认证等级
    private String  safetypwd;     // 安全认证密码
    private Short   powerstatus;   // 上电状态
    private String  disc;

    public Integer getNumberid() {
        return numberid;
    }

    public void setNumberid(Integer numberid) {
        this.numberid = numberid;
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

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
