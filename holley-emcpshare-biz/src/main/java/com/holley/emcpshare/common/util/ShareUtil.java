package com.holley.emcpshare.common.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;

public class ShareUtil {

    public static void getParam(String s, List<String> list) {
        if (s.indexOf("|") != -1) {
            String tem = s.substring(0, s.indexOf("|"));
            String tem2 = s.substring(s.indexOf("|") + 1, s.length());
            list.add(tem);
            getParam(tem2, list);
        }
    }

    public static String getDefaultStr(Object value) {
        return value != null ? value.toString() : "";
    }

    public static BigDecimal getDefaultDecimal(String value) {
        return value != null ? new BigDecimal(value) : null;
    }

    public static BigDecimal getMulMoney(BigDecimal value1, BigDecimal value2) {
        return value1.multiply(value2);
    }

    public static BigDecimal getAddMoney(BigDecimal value1, BigDecimal value2) {
        return value1.add(value2);
    }

    /**
     * 检验数据时间是否延时<br>
     * 0：正常,1:延时,2:未设采集周期或者数据项
     * 
     * @param sampleinterval
     * @param datatime
     * @return
     */
    public static int validDataTime(String sampleinterval, Date datatime) {
        if (StringUtil.isEmpty(sampleinterval)) {
            return 2;// 未设采集周期
        }
        if (datatime == null) {
            return 1;
        }
        String type = sampleinterval.substring(0, 2);
        String num = sampleinterval.substring(2);
        int amount = 0;
        if (StringUtil.isDigits(num)) {
            amount = Integer.parseInt(num) * -1;
        }
        Date checkDate = new Date();
        Date now = new Date();
        switch (type) {
            case "MI":
                checkDate = DateUtil.addMinutes(now, amount);
                break;
            case "HH":
                checkDate = DateUtil.addHours(now, amount);
                break;
            case "DD":
                checkDate = DateUtil.addDays(now, amount);
                break;
            case "MM":
                checkDate = DateUtil.addMonths(now, amount);
                break;
            default:
                break;
        }
        if (datatime.compareTo(checkDate) < 0) {
            return 1;// 采集时间延迟
        }
        return 0;// 数据正常
    }

    public static boolean isHH(String hh) {
        return Pattern.matches("^[A-Za-z0-9\\-]+$", hh);
    }

    public static Date getNextMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    public static Date getPreMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

}
