package com.holley.emcpshare.comenum;

/**
 * 用户注册失败原因register
 */
public enum AccountRegisterFailReasonTypeEnum {
    NIL(0, "无"), BAD_PARAM(1, "缺少必要参数"), REPEAT_HH(2, "户号重复"), REPEAT_HM(3, "户名重复"), REPEAT_PHONE(4, "联系电话重复");

    private final int    value;
    private final String text;

    AccountRegisterFailReasonTypeEnum(int value, String text) {
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
        AccountRegisterFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static AccountRegisterFailReasonTypeEnum getEnmuByValue(int value) {
        for (AccountRegisterFailReasonTypeEnum record : AccountRegisterFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
