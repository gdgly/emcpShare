package com.holley.emcpshare.model.bank;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.emcpshare.bankenum.BankBillReturnStatusEnum;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.NumberUtil;

public class BankBill {

    private Integer    customerId;
    private String     hh;          // 户号
    private String     hm;          // 户名
    private String     address;     // 地址
    private Date       dataTime;    // 月份
    private BigDecimal preNum;      // 上期抄度
    private BigDecimal currentNum;  // 本期抄度
    private BigDecimal otherNum;    // 附加抄度
    private BigDecimal realNum;     // 实际度数
    private BigDecimal price;       // 单价
    private BigDecimal money;       // 金额
    private BigDecimal rebate;      // 滞纳金
    private String     cardNum;     // 卡号
    private String     returnStatus; // 返回状态
    private Short      cutstatus;   // 扣款状态
    private Short      energytype;  // 能源类型

    public String getHh() {
        return hh;
    }

    public void setHh(String hh) {
        this.hh = hh;
    }

    public String getHm() {
        return hm;
    }

    public void setHm(String hm) {
        this.hm = hm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public BigDecimal getPreNum() {
        if (preNum == null) {
            return NumberUtil.formateScale2(BigDecimal.ZERO);
        }
        return NumberUtil.formateScale2(preNum);
    }

    public void setPreNum(BigDecimal preNum) {
        this.preNum = preNum;
    }

    public BigDecimal getCurrentNum() {
        if (currentNum == null) {
            return NumberUtil.formateScale2(BigDecimal.ZERO);
        }
        return NumberUtil.formateScale2(currentNum);
    }

    public void setCurrentNum(BigDecimal currentNum) {
        this.currentNum = currentNum;
    }

    public BigDecimal getOtherNum() {
        if (otherNum == null) {
            return NumberUtil.formateScale2(BigDecimal.ZERO);
        }
        return NumberUtil.formateScale2(otherNum);
    }

    public void setOtherNum(BigDecimal otherNum) {
        this.otherNum = otherNum;
    }

    public BigDecimal getRealNum() {
        if (realNum == null) {
            return NumberUtil.formateScale2(BigDecimal.ZERO);
        }
        return NumberUtil.formateScale2(realNum);
    }

    public void setRealNum(BigDecimal realNum) {
        this.realNum = realNum;
    }

    public BigDecimal getPrice() {
        if (price == null) {
            return NumberUtil.formateScale2(BigDecimal.ZERO);
        }
        return NumberUtil.formateScale2(price);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMoney() {
        if (money == null) {
            return NumberUtil.formateScale2(BigDecimal.ZERO);
        }
        return NumberUtil.formateScale2(money);
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getRebate() {
        if (rebate == null) {
            return NumberUtil.formateScale2(BigDecimal.ZERO);
        }
        return NumberUtil.formateScale2(rebate);
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Short getCutstatus() {
        return cutstatus;
    }

    public void setCutstatus(Short cutstatus) {
        this.cutstatus = cutstatus;
    }

    public Short getEnergytype() {
        return energytype;
    }

    public void setEnergytype(Short energytype) {
        this.energytype = energytype;
    }

    public String getDataTimeStr() {
        return DateUtil.DateToStr(dataTime, DateUtil.YEARMONTH);
    }

    public String getReturnStatusStr() {
        if (returnStatus == null) {
            return "";
        }
        String str = BankBillReturnStatusEnum.getText(returnStatus);
        str = str != null ? str : "未知";
        return returnStatus + " : " + str;
    }
}
