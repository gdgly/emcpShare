package com.holley.emcpshare.icmenum;

public enum IcmOperateResultTypeEnum {
                                      SUCCESS(0, "成功"), OPEN(-1, "已开户"), FAIL(-2, "失败"), NO_OPEN(-3, "该电表为开户");

    private final int    value;
    private final String text;

    IcmOperateResultTypeEnum(int value, String text) {
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
        IcmOperateResultTypeEnum record = getEnmuByValue(value);
        return record == null ? null : record.getText();
    }

    public Short getShortValue() {
        Integer obj = value;
        return obj.shortValue();
    }

    /**
     * 通过传入的值匹配枚举
     * 
     * @param value
     * @return
     */
    public static IcmOperateResultTypeEnum getEnmuByValue(int value) {
        for (IcmOperateResultTypeEnum record : IcmOperateResultTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
