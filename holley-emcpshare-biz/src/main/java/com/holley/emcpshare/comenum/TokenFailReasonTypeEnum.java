package com.holley.emcpshare.comenum;

/**
 * 获取token失败原因
 */
public enum TokenFailReasonTypeEnum {
    NIL(0, "无"), UNKNOWN_OPERATOR(1, "无此运营商"), ERROR_SECRET_KEY(2, "密钥错误");

    private final int    value;
    private final String text;

    TokenFailReasonTypeEnum(int value, String text) {
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
        TokenFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static TokenFailReasonTypeEnum getEnmuByValue(int value) {
        for (TokenFailReasonTypeEnum record : TokenFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
