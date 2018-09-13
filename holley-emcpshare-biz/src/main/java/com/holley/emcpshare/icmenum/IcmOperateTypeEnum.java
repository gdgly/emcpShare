package com.holley.emcpshare.icmenum;

public enum IcmOperateTypeEnum {
                                PRESETENERGY(1, "预置电量"), OPENACCOUNT(2, "开户"), BUYENERGY(3, "购电"), CLEAR(4, "清零");

    private final int    value;
    private final String text;

    IcmOperateTypeEnum(int value, String text) {
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
        IcmOperateTypeEnum obj = getEnmuByValue(value);
        return obj == null ? null : obj.getText();
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
    public static IcmOperateTypeEnum getEnmuByValue(int value) {
        for (IcmOperateTypeEnum record : IcmOperateTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
