package com.holley.emcpshare.comenum;

public enum OperateStatusEnum {
                               INIT(0, "未支付"), SUCCESS(1, "成功"), FAILURE(2, "失败"), UNKNOWN(3, "未知");

    private final int    value;
    private final String text;

    OperateStatusEnum(int value, String text) {
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
        OperateStatusEnum task = getEnmuByValue(value);
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
    public static OperateStatusEnum getEnmuByValue(int value) {
        for (OperateStatusEnum record : OperateStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
