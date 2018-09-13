package com.holley.emcpshare.comenum;

public enum OperateTypeEnum {
                             PRESETENERGY(1, "预置电量"), OPENACCOUNT(2, "开户"), BUYENERGY(3, "购电"), CLEAR(4, "清零");

    private final int    value;
    private final String text;

    OperateTypeEnum(int value, String text) {
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
        OperateTypeEnum obj = getEnmuByValue(value);
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
    public static OperateTypeEnum getEnmuByValue(int value) {
        for (OperateTypeEnum record : OperateTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
