package com.holley.emcpshare.model.def;

/**
 * 账户充值返回
 * 
 * @author sc
 */
public class RechargeBase {

    private String tradeNo;
    private int    succStat;
    private int    failReason;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

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
