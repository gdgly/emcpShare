package com.holley.emcpshare.task;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import com.holley.emcpshare.common.util.ReaderResourceUtil;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.NumberUtil;

public class GJDataConfig {

    public static int        powerPointId = 17972;
    public static int        waterPointId = 17973;
    public static int        gasPointId   = 17974;
    public static BigDecimal powerZongBm  = null;
    public static BigDecimal powerJianBm  = null;        // 10%
    public static BigDecimal powerFengBm  = null;        // 20%
    public static BigDecimal powerPingBm  = null;        // 50%
    public static BigDecimal powerGuBm    = null;        // 20%
    public static BigDecimal waterBm      = null;
    public static BigDecimal gasBm        = null;
    public static Date       powerTime    = null;
    public static Date       waterTime    = null;
    public static Date       gasTime      = null;
    public static Random     random       = new Random();
    static {
        Properties p = ReaderResourceUtil.getClassPathProperties("gjConfig.properties");
        powerZongBm = new BigDecimal(p.getProperty("powerZongBm"));
        powerJianBm = new BigDecimal(p.getProperty("powerJianBm"));
        powerFengBm = new BigDecimal(p.getProperty("powerFengBm"));
        powerPingBm = new BigDecimal(p.getProperty("powerPingBm"));
        powerGuBm = new BigDecimal(p.getProperty("powerGuBm"));
        waterBm = new BigDecimal(p.getProperty("waterBm"));
        gasBm = new BigDecimal(p.getProperty("gasBm"));
        powerTime = DateUtil.StrToDate(p.getProperty("powerTime"), DateUtil.TIME_LONG);
        waterTime = DateUtil.StrToDate(p.getProperty("waterTime"), DateUtil.TIME_LONG);
        gasTime = DateUtil.StrToDate(p.getProperty("gasTime"), DateUtil.TIME_LONG);
    }

    public static BigDecimal getRandomData(int multiple) {
        double t = random.nextDouble() * multiple;
        return new BigDecimal(t + "").setScale(2, BigDecimal.ROUND_DOWN);
    }

    public static Date nextDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    public static Date nextHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, 1);
        return c.getTime();
    }

    public static boolean isPointTime(Date date) {
        return DateUtil.DateToHHMMSSStr(date).equals("00:00:00");
    }

    public static BigDecimal getJFPGAddData() {
        BigDecimal tem = NumberUtil.add(powerJianBm, powerFengBm);
        tem = NumberUtil.add(tem, powerPingBm);
        tem = NumberUtil.add(tem, powerGuBm);
        tem = NumberUtil.sub(powerZongBm, tem);
        return tem.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : tem;
    }

    public static BigDecimal getAddData(BigDecimal... data) {
        BigDecimal tem = BigDecimal.ZERO;
        for (BigDecimal b : data) {
            tem = NumberUtil.add(tem, b);
        }
        return tem;
    }
}
