package com.holley.emcpshare.comenum;

import org.apache.commons.lang3.StringUtils;

/**
 * 城市能源监测pob对象<br/>
 * OBJ_PROVINCE = "1" 省<br/>
 * OBJ_CITY = "2" 市<br/>
 * OBJ_DISTRICT = "3" 区县<br/>
 * SYS_DEPARTMENT = "9" 部门<br/>
 * OBJ_ENTERPRISE = "11" 企业用能单位 <br/>
 * OBJ_SUBEU = "12" 次级用能单位 <br/>
 * OBJ_EUDEV = "13" 用能设备 <br/>
 * OBJ_METER = "21" 计量器具 <br/>
 * OBJ_RTU = "22" 采集终端 <br/>
 * OBJ_POINT = "23" 计量点信息 <br/>
 * DIC_BUSINESS = "31" 行业<br/>
 * DIC_STATION = "41" 主站<br/>
 * <br/>
 * <br/>
 * PPF_CUSTOMER = "201" 预付费用户<br/>
 * 
 * @author road
 */
public enum ObjectTypeEnum {
    OBJ_UNKOWN("0", "未知"), OBJ_PROVINCE("1", "省"), OBJ_CITY("2", "市"), OBJ_DISTRICT("3", "区县"), SYS_DEPARTMENT("9", "部门"), OBJ_ENTERPRISE("11", "企业用能单位 "), OBJ_SUBEU("12",
                                                                                                                                                                      "次级用能单位"),
    OBJ_EUDEV("13", "用能设备"), OBJ_METER("21", "计量器具"), OBJ_RTU("22", "采集终端"), OBJ_POINT("23", "计量点信息"), DIC_BUSINESS("31", "行业"), DIC_STATION("41", "主站"), PPF_CUSTOMER("201",
                                                                                                                                                                       "预付费用户");

    private final String value;
    private final String text;

    ObjectTypeEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public int getIntValue() {
        return Integer.parseInt(value);
    }

    public short getShortValue() {
        return Short.parseShort(value);
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static ObjectTypeEnum getEnmuByValue(String value) {
        for (ObjectTypeEnum objTypect : ObjectTypeEnum.values()) {
            if (StringUtils.equals(value, objTypect.getValue())) {
                return objTypect;
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
    public static ObjectTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (ObjectTypeEnum objTypect : ObjectTypeEnum.values()) {
            if (StringUtils.equals(name, objTypect.toString())) {
                return objTypect;
            }
        }
        return null;
    }
}
