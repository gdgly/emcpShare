package com.holley.emcpshare.bankenum;

import org.apache.commons.lang3.StringUtils;

/**
 * 银行返回状态码
 * 
 * @author
 */
public enum BankReturnStatusEnum {

    SUCCESS("000", "交易成功"), UNKNOWN_ERROR("991", "不确定错误"), ILLEGAL_TRADE_CODE("992", "非法交易码"), PACKAGE_NOT_ENOUGH("993", "包中字段数不够"), LACK_BANK_CODE("994", "请求包中无银行代码"),
    ILLEGAL_BANK_CODE("995", "非法银行代码"), BANK_NOT_ONLINE("996", "此银行未联网"), USER_ALREADY_REGISTER("101", "此代扣用户(自来水方)已登记"), USER_NOT_REGISTER("102", "此代扣用户(自来水方)未登记"),
    USER_NOT_VALIDATE("103", "此银行代扣用户不需验证"), UNKNOWN_BANKNAME("104", "此银行未指定代扣开户行名称"), ARREARS_NOT_WITHHOLD("110", "此用户有欠费不可转代扣"), ARREARS_NOT_CASH("120", "此用户有欠费不可转现金");

    private final String value;
    private final String text;

    BankReturnStatusEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(String value) {
        BankReturnStatusEnum em = getEnmuByValue(value);
        return em == null ? null : em.getText();
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static BankReturnStatusEnum getEnmuByValue(String value) {
        for (BankReturnStatusEnum lowCommType : BankReturnStatusEnum.values()) {
            if (value.equals(lowCommType.getValue())) {
                return lowCommType;
            }
        }
        return null;
    }

    /**
     * 通过传入的字符串匹配枚举,传入名字
     * 
     * @param name
     * @return
     */
    public static BankReturnStatusEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (BankReturnStatusEnum lowCommType : BankReturnStatusEnum.values()) {
            if (StringUtils.equals(name, lowCommType.toString())) {
                return lowCommType;
            }
        }
        return null;
    }

    public String toString() {
        return text;
    }

}
