package com.holley.emcpshare.comenum;

/**
 * 远程拉合闸失败原因
 */
public enum RemoteDisconnectFailReasonTypeEnum {
    NIL(0, "无"), UNKNOWN_DEVICE(1, "设备信息不存在"), OFF_LINE(2, "设备离线"), NOT_ALLOW(3, "不允许远程拉合闸"), NOT_REPEAT(4, "重复操作");

    private final int    value;
    private final String text;

    RemoteDisconnectFailReasonTypeEnum(int value, String text) {
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
        RemoteDisconnectFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static RemoteDisconnectFailReasonTypeEnum getEnmuByValue(int value) {
        for (RemoteDisconnectFailReasonTypeEnum record : RemoteDisconnectFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
