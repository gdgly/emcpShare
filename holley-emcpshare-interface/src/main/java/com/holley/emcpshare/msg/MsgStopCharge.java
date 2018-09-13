package com.holley.emcpshare.msg;

public class MsgStopCharge extends MsgBase {

    private String tradeNo; // 交易号

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

}
