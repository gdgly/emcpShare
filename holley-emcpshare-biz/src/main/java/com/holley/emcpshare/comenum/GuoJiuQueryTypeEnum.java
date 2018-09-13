package com.holley.emcpshare.comenum;

/**
 * 国久接口查询类型
 */
public enum GuoJiuQueryTypeEnum {
    REAL(0, "最新数据"), HISTORY(1, "历史数据");

    private final int    value;
    private final String text;

    GuoJiuQueryTypeEnum(int value, String text) {
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
        GuoJiuQueryTypeEnum task = getEnmuByValue(value);
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
    public static GuoJiuQueryTypeEnum getEnmuByValue(int value) {
        for (GuoJiuQueryTypeEnum record : GuoJiuQueryTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
