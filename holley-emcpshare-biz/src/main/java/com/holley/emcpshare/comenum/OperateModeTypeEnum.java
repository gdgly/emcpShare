package com.holley.emcpshare.comenum;

public enum OperateModeTypeEnum {
                                 REMOTE(1, "远程"), CARD(2, "刷卡");

    private final int    value;
    private final String text;

    OperateModeTypeEnum(int value, String text) {
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
        OperateModeTypeEnum obj = getEnmuByValue(value);
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
    public static OperateModeTypeEnum getEnmuByValue(int value) {
        for (OperateModeTypeEnum record : OperateModeTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
