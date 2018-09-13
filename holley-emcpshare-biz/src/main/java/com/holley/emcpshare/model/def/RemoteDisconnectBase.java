package com.holley.emcpshare.model.def;

/**
 * 远程拉合闸
 * 
 * @author sc
 */
public class RemoteDisconnectBase {

    private int succStat;
    private int failReason;

    public int getSuccStat() {
        return succStat;
    }

    public void setSuccStat(int succStat) {
        this.succStat = succStat;
    }

    public int getFailReason() {
        return failReason;
    }

    public void setFailReason(int failReason) {
        this.failReason = failReason;
    }

}
