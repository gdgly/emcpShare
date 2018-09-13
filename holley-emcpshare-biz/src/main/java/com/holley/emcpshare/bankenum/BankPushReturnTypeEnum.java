package com.holley.emcpshare.bankenum;

import org.apache.commons.lang3.StringUtils;

/**
 * 银行推送返回
 * 
 * @author armording
 */
public enum BankPushReturnTypeEnum {

    PUSH(1, "推送"), RETURN(2, "返回"), CONTRACT(3, "签约"), DISSOLUTION(4, "解约");

    private final int    value;
    private final String text;

    BankPushReturnTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(int value) {
        BankPushReturnTypeEnum em = getEnmuByValue(value);
        return em == null ? null : em.getText();
    }

    public Short getShortValue() {
        Integer obj = value;
        return obj.shortValue();
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static BankPushReturnTypeEnum getEnmuByValue(int value) {
        for (BankPushReturnTypeEnum lowCommType : BankPushReturnTypeEnum.values()) {
            if (value == lowCommType.getValue()) {
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
    public static BankPushReturnTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (BankPushReturnTypeEnum lowCommType : BankPushReturnTypeEnum.values()) {
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
