package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

public class AccountRechargeInfo {

    private String     userId; // 户号
    private BigDecimal money; // 充值金额
    private String     time;  // 付款时间
    private Short      status;
    private Short      payway;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getPayway() {
        return payway;
    }

    public void setPayway(Short payway) {
        this.payway = payway;
    }

}
