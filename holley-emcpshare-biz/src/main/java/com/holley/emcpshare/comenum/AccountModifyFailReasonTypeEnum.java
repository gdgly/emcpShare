package com.holley.emcpshare.comenum;

/**
 * 用户修改失败原因modify
 */
public enum AccountModifyFailReasonTypeEnum {
    NIL(0, "无"), BAD_PARAM(1, "参数有误"), REPEAT_HM(2, "户名重复"), REPEAT_PHONE(3, "联系电话重复");

    private final int    value;
    private final String text;

    AccountModifyFailReasonTypeEnum(int value, String text) {
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
        AccountModifyFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static AccountModifyFailReasonTypeEnum getEnmuByValue(int value) {
        for (AccountModifyFailReasonTypeEnum record : AccountModifyFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
