package com.holley.emcpshare.dcsenum;

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
public enum MeterProtocolEnum {

    PROTOCOL_INVALID(0, "无效"), PROTOCOL_645_1997(1, "DL/T 645—1997"), PROTOCOL_645_2007(30, "DL/T 645-2007");

    private final int    value;
    private final String text;

    MeterProtocolEnum(int value, String text) {
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
        MeterProtocolEnum em = getEnmuByValue(value);
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
    public static MeterProtocolEnum getEnmuByValue(int value) {
        for (MeterProtocolEnum lowCommType : MeterProtocolEnum.values()) {
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
    public static MeterProtocolEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (MeterProtocolEnum lowCommType : MeterProtocolEnum.values()) {
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
        for (MeterProtocolEnum ct : MeterProtocolEnum.values()) {
            ComboBoxBean bean = new ComboBoxBean();
            bean.setId(String.valueOf(ct.getValue()));
            bean.setDesc(ct.getText());
            result.add(bean);
        }
        return result;
    }
}
