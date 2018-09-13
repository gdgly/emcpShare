package com.holley.emcpshare.comenum;

/**
 * 电费扣款状态，供后付费用户使用<br>
 * ppf_customer_fee_month表的cutstatus字段
 */
public enum FeeCutStatusEnum {
    UNCUT(1, "待扣款"), SUCCESS(2, "扣款成功"), FAIL(3, "扣款失败");

    private final int    value;
    private final String text;

    FeeCutStatusEnum(int value, String text) {
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
        FeeCutStatusEnum obj = getEnmuByValue(value);
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
    public static FeeCutStatusEnum getEnmuByValue(int value) {
        for (FeeCutStatusEnum record : FeeCutStatusEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
