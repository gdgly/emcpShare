package com.holley.emcpshare.model.def;

/**
 * 用户注册/修改结果
 * 
 * @author lenovo
 */
public class AccountRegisterInfo {

    private String userId;    // 用户户号
    private int    succStat;  // 状态
    private int    failReason; // 注册用户失败原因

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
