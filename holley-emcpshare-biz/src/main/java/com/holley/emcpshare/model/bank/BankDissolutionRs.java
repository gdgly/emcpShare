package com.holley.emcpshare.model.bank;

import com.holley.emcpshare.bankenum.BankReturnStatusEnum;
import com.holley.emcpshare.common.util.ShareGloblas;

/**
 * 银行解约
 * 
 * @author sc
 */
public class BankDissolutionRs {

    private BankReturnStatusEnum returnCode;
    private String               tapwaterCode = ShareGloblas.WATER_COMPANY_CODE; // 自来水代码

    public BankReturnStatusEnum getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(BankReturnStatusEnum returnCode) {
        this.returnCode = returnCode;
    }

    public String getTapwaterCode() {
        return tapwaterCode;
    }

    public void setTapwaterCode(String tapwaterCode) {
        this.tapwaterCode = tapwaterCode;
    }

}
