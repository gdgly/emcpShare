package com.holley.emcpshare.comenum;

/**
 * 充值失败原因
 */
public enum RechargeFailReasonTypeEnum {
    NIL(0, "无"), BAD_MONEY(1, "充值金额有误"), BAD_TRADENO(2, "订单编号有误"), REPEAT_TRADENO(3, "订单已受理"), BAD_ACCOUNT(4, "账户信息不存在");

    private final int    value;
    private final String text;

    RechargeFailReasonTypeEnum(int value, String text) {
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
        RechargeFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static RechargeFailReasonTypeEnum getEnmuByValue(int value) {
        for (RechargeFailReasonTypeEnum record : RechargeFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
