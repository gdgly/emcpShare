package com.holley.emcpshare.msg;

import java.io.Serializable;

public class MsgBase implements Serializable {

    private static final long serialVersionUID = 1L;
    private String            cmdid;                // 命令编码
    private int               cmdtype;              // 命令类型
    private String            commaddr;             // 通讯地址
    private String            commsubaddr;          // 通讯子地址

    public String getCmdid() {
        return cmdid;
    }

    public void setCmdid(String cmdid) {
        this.cmdid = cmdid;
    }

    public int getCmdtype() {
        return cmdtype;
    }

    public void setCmdtype(int cmdtype) {
        this.cmdtype = cmdtype;
    }

    public String getCommaddr() {
        return commaddr;
    }

    public void setCommaddr(String commaddr) {
        this.commaddr = commaddr;
    }

    public String getCommsubaddr() {
        return commsubaddr;
    }

    public void setCommsubaddr(String commsubaddr) {
        this.commsubaddr = commsubaddr;
    }

}
