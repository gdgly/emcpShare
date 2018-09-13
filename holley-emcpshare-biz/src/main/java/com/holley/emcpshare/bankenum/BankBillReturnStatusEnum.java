package com.holley.emcpshare.bankenum;

import org.apache.commons.lang3.StringUtils;

/**
 * 银行返回状态码
 * 
 * @author
 */
public enum BankBillReturnStatusEnum {

    SUCCESS("0", "交易成功"), PART("1", "部分扣款"), FAIL("2", "不成功"), FAIL_A("A", "无此户"), FAIL_B("B", "止付"), FAIL_C("C", "过期卡"), FAIL_D("D", "冻结"), FAIL_E("E", "失信"), FAIL_F("F", "超限额"),
    FAIL_G("G", "销户"), FAIL_H("H", "作废"), FAIL_I("I", "卡号错"), FAIL_J("J", "格式错"), FAIL_K("K", "挂失"), FAIL_a("a", "委托不存在"), FAIL_b("b", "扣款账号不一致");

    private final String value;
    private final String text;

    BankBillReturnStatusEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(String value) {
        BankBillReturnStatusEnum em = getEnmuByValue(value);
        return em == null ? null : em.getText();
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static BankBillReturnStatusEnum getEnmuByValue(String value) {
        for (BankBillReturnStatusEnum lowCommType : BankBillReturnStatusEnum.values()) {
            if (value.equals(lowCommType.getValue())) {
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
    public static BankBillReturnStatusEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (BankBillReturnStatusEnum bankBillReturnStatus : BankBillReturnStatusEnum.values()) {
            if (StringUtils.equals(name, bankBillReturnStatus.toString())) {
                return bankBillReturnStatus;
            }
        }
        return null;
    }

    public String toString() {
        return text;
    }

}
