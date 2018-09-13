package com.holley.emcpshare.comenum;

/**
 * 电价类型
 */
public enum PriceTypeEnum {
                           SINGLE(1, "单一电价"), RATE(2, "费率电价"), LADDER(3, "月阶梯电价"), YEAR_LADDER(4, "年阶梯电价");

    private final int    value;
    private final String text;

    PriceTypeEnum(int value, String text) {
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
        PriceTypeEnum obj = getEnmuByValue(value);
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
    public static PriceTypeEnum getEnmuByValue(int value) {
        for (PriceTypeEnum record : PriceTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
