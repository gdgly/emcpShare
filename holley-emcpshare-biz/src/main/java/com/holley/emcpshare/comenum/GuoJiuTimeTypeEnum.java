package com.holley.emcpshare.comenum;

/**
 * 国久接口查询类型
 */
public enum GuoJiuTimeTypeEnum {
    HOUR(1, "小时"), DAY(2, "日"), MONTH(3, "月"), YEAR(4, "年");

    private final int    value;
    private final String text;

    GuoJiuTimeTypeEnum(int value, String text) {
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
        GuoJiuTimeTypeEnum task = getEnmuByValue(value);
        return task == null ? null : task.getText();
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
    public static GuoJiuTimeTypeEnum getEnmuByValue(int value) {
        for (GuoJiuTimeTypeEnum record : GuoJiuTimeTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
