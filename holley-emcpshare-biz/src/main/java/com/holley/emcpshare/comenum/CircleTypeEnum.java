package com.holley.emcpshare.comenum;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.holley.emcp.common.dataobjects.ComboBoxBean;

/**
 * 0-15分钟<br>
 * 1-小时<br>
 * 2-日<br>
 * 3-月<br>
 * 4-周<br>
 * 5-旬<br>
 * 6-季 7-年
 * 
 * @author armording
 */
public enum CircleTypeEnum {

    MINUTE(0, "分钟"), HOUR(1, "小时"), DAY(2, "日"), MONTH(3, "月"), WEEK(4, "周"), TENDAYS(5, "旬"), QUARTER(6, "季"), YEAR(7, "年"), ZDY(8, "自定义");

    private final int    value;
    private final String text;

    CircleTypeEnum(int value, String text) {
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
        CircleTypeEnum em = getEnmuByValue(value);
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
    public static CircleTypeEnum getEnmuByValue(int value) {
        for (CircleTypeEnum lowCommType : CircleTypeEnum.values()) {
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
    public static CircleTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (CircleTypeEnum lowCommType : CircleTypeEnum.values()) {
            if (StringUtils.equals(name, lowCommType.toString())) {
                return lowCommType;
            }
        }
        return null;
    }

    public String toString() {
        return text;
    }

    public static List<ComboBoxBean> getCircletypes() {
        List<ComboBoxBean> result = new LinkedList<ComboBoxBean>();
        for (CircleTypeEnum ct : CircleTypeEnum.values()) {
            ComboBoxBean bean = new ComboBoxBean();
            bean.setId(String.valueOf(ct.getValue()));
            bean.setDesc(ct.getText());
            result.add(bean);
        }
        return result;
    }
}
