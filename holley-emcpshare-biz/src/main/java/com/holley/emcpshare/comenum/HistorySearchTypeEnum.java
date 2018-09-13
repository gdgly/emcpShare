package com.holley.emcpshare.comenum;

import org.apache.commons.lang3.StringUtils;

/**
 * 历史数据查询类型
 * 
 * @author lenovo
 */
public enum HistorySearchTypeEnum {

                                   ALL(0, "所有"), BY_DAY(1, "按天");

    private final int    value;
    private final String text;

    HistorySearchTypeEnum(int value, String text) {
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
        HistorySearchTypeEnum em = getEnmuByValue(value);
        return em == null ? null : em.getText();
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
    public static HistorySearchTypeEnum getEnmuByValue(int value) {
        for (HistorySearchTypeEnum lowCommType : HistorySearchTypeEnum.values()) {
            if (value == lowCommType.getValue()) {
                return lowCommType;
            }
        }
        return null;
    }

    /**
     * 通过传入的字符串匹配枚举,传入名字
     * 
     * @param name
     * @return
     */
    public static HistorySearchTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (HistorySearchTypeEnum lowCommType : HistorySearchTypeEnum.values()) {
            if (StringUtils.equals(name, lowCommType.toString())) {
                return lowCommType;
            }
        }
        return null;
    }

    public String toString() {
        return text;
    }

}
