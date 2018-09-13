package com.holley.emcpshare.model.bank;

import com.holley.emcpshare.bankenum.BankReturnStatusEnum;
import com.holley.emcpshare.common.util.ShareGloblas;

/**
 * 银行签约
 * 
 * @author sc
 */
public class BankContractRs {

    private BankReturnStatusEnum returnCode;                                    // 返回码

    private String               userAccount;                                   // 户号

    private String               userName;                                      // 户名

    private String               cardNumber;                                    // 卡号

    private String               meterAddress;                                  // 装表地址

    private String               phone;                                         // 电话

    private String               meterNumber;                                   // 表号

    private String               tapwaterCode = ShareGloblas.WATER_COMPANY_CODE; // 自来水代码

    public BankReturnStatusEnum getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(BankReturnStatusEnum returnCode) {
        this.returnCode = returnCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMeterAddress() {
        return meterAddress;
    }

    public void setMeterAddress(String meterAddress) {
        this.meterAddress = meterAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getTapwaterCode() {
        return tapwaterCode;
    }

    public void setTapwaterCode(String tapwaterCode) {
        this.tapwaterCode = tapwaterCode;
    }

}
