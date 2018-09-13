package com.holley.emcpshare.comenum;

public enum DataSourceTypeEnum {

                                RTUTASK(1, "终端任务"), ADDPURCHASEHISTORY(2, "购电反写");

    private final int    value;
    private final String text;

    DataSourceTypeEnum(int value, String text) {
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
        DataSourceTypeEnum obj = getEnmuByValue(value);
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
    public static DataSourceTypeEnum getEnmuByValue(int value) {
        for (DataSourceTypeEnum record : DataSourceTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
