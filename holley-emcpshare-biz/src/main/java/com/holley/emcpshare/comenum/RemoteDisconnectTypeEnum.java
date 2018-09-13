package com.holley.emcpshare.comenum;

/**
 * 远程拉合闸操作类型
 */
public enum RemoteDisconnectTypeEnum {
    DISCONNECT(1, "拉闸"), CONNECT(1, "合闸");

    private final int    value;
    private final String text;

    RemoteDisconnectTypeEnum(int value, String text) {
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
        RemoteDisconnectTypeEnum task = getEnmuByValue(value);
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
    public static RemoteDisconnectTypeEnum getEnmuByValue(int value) {
        for (RemoteDisconnectTypeEnum record : RemoteDisconnectTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
