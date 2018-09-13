package com.holley.emcpshare.dcs.util;

import java.math.BigDecimal;

import com.holley.emcp.common.utils.NumberUtil;
import com.holley.emcpshare.model.def.HistoryElectricityInfo;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;

/**
 * 召读解报文
 * 
 * @author sc
 */
public class DcsUtil {

    public static HistoryElectricityInfo parse1stCatDataF129(String str) {
        return parse1stCatDataEneryValue(str, 0, 0, 0);
    }

    private static HistoryElectricityInfo parse1stCatDataEneryValue(String v, int time, int dire, int flag) {
        HistoryElectricityInfo info = new HistoryElectricityInfo();
        int radix = 0;
        if (flag == 0) {
            radix = 10;
        } else if (flag == 1) {
            radix = 8;
        }
        int length = v.length();
        if ((length - 12) % radix != 0) return null;
        try {
            // 终端抄表时间
            String datatime = parseDateTime(new String(v.getBytes(), length - 10, 10));
            // 费率数
            int count = Integer.parseInt(new String(v.getBytes(), length - 12, 2), 16);
            if (radix * (count + 1) + 12 != length) return null;
            String dataValue = parseDataFormat14(new String(v.getBytes(), length - 22, 10));
            if (!"格式错误".equals(dataValue)) {
                info.setBm(new BigDecimal(dataValue));
            }
            info.setDataTime(DateUtil.DateToLongStr(DateUtil.StrToDate(datatime, DateUtil.TIME_NO_SEC_10)));
        } catch (Exception e) {
            System.out.println("DATA:" + v);
            e.printStackTrace();
        }
        return info;
    }

    /*
     * 解析 数据格式14
     */
    private static String parseDataFormat14(String str) {
        if (StringUtil.isEmpty(str) || str.length() != 10) return "";
        return addRadixPoint(str, 4);
    }

    /*
     * 解析 数据格式15
     */
    // private static parseDataFormat15(String v) {
    // if(StringUtil.isEmpty(v) || v.length() != 10) return "";
    // return parseDateTime(v,YEAR_MONTH_DAY_HOUR_MIN);
    // }

    /*
     * 解析日期时间
     */
    // private static parseDateTime(String v,Array unitArray):String {
    // if(StringUtils.isEmpty(v) || v.length %2 != 0) return "空";
    // if(!StringUtils.isDigital(v)) return "非BCD码";
    // String result= "";
    // int len = v.length;
    // int pos = 0;
    // while(pos < len){
    // result += v.substr(pos,2) + unitArray[pos / 2];
    // pos += 2;
    // }
    // return result;
    // }
    /*
     * 增加小数点 scale : 保留几位小数
     */
    public static String addRadixPoint(String v, int scale) {
        if (StringUtil.isEmpty(v) || StringUtil.trim(v) == "") return "空";
        if (!StringUtil.isDigits(v)) return "格式错误";
        int len = v.length();
        if (v.length() < scale) {
            return "0." + NumberUtil.charPad(v, scale, "0");
        }
        String dec = v.substring(len - scale);// 小数部分
        int pos = dec.length() - 1;
        while (dec.substring(pos).equals("0")) {
            pos--;
        }
        dec = dec.substring(0, pos + 1);

        String intpart = v.substring(0, len - scale);// 整数部分
        intpart = Integer.parseInt(intpart) + "";
        if (dec.length() > 0) {
            return intpart + "." + dec;
        } else {
            return intpart;
        }

    }

    /*
     * 解析日期时间
     */
    public static String parseDateTime(String v) {
        if (StringUtil.isEmpty(v) || v.length() % 2 != 0) return "";
        if (!StringUtil.isDigits(v)) return "非BCD码";
        String result = "";
        int len = v.length();
        int pos = 0;
        while (pos < len) {
            result += new String(v.getBytes(), pos, 2);
            pos += 2;
        }
        return result;
    }

}
