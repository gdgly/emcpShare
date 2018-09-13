package com.holley.emcpshare.comenum;

/**
 * 验证用户登录失败原因
 */
public enum CheckAccountFailReasonTypeEnum {
                                            SUCCESS(0, "成功"), ACCOUNT_NOT_EXIST(-1, "用户不存在"), PASSWORD_ERROR(-2, "密码不正确"), ACCOUNT_ILLEGAL(-3, "非法账户");

    private final int    value;
    private final String text;

    CheckAccountFailReasonTypeEnum(int value, String text) {
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
        CheckAccountFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static CheckAccountFailReasonTypeEnum getEnmuByValue(int value) {
        for (CheckAccountFailReasonTypeEnum record : CheckAccountFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
