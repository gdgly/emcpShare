package com.holley.emcp.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import com.holley.platform.common.util.DateUtil;

public class PrepayUtil {

    /**
     * 计算预计可用天数
     * 
     * @return
     */
    public static String calcAvailableDays(BigDecimal usablemoney, BigDecimal freezemoney) {
        if (usablemoney == null || freezemoney == null) return "";
        int today = DateUtil.getDayValue(new Date());
        String days = "";
        // 估计每天电费
        BigDecimal dayfee = freezemoney.divide(new BigDecimal(today), 2, RoundingMode.HALF_UP);
        if (dayfee != null && dayfee.doubleValue() > 0) {
            if (usablemoney.doubleValue() <= 0) {
                days = "0";
            } else {
                days = usablemoney.divide(dayfee, 0, RoundingMode.DOWN).toString();
            }
        }
        return days;
    }

    /**
     * 计算电费 = 用电量 * 电价 * 占比
     * 
     * @param used
     * @param price
     * @return
     */
    public static BigDecimal getFee(BigDecimal used, BigDecimal price, Short percent) {
        if (used == null || price == null) return BigDecimal.ZERO;
        BigDecimal fee = used.multiply(price);
        if (percent != null && percent.doubleValue() > 0.0) {
            fee = fee.multiply(new BigDecimal(percent).divide(BigDecimal.valueOf(100)));
        }
        return fee;
    }

    /**
     * 计算电费 = 用电量 * 电价
     * 
     * @param used
     * @param price
     * @return
     */
    public static BigDecimal getFee(BigDecimal used, BigDecimal price) {
        if (used == null || price == null) return BigDecimal.ZERO;
        BigDecimal fee = used.multiply(price);
        return fee;
    }

    /**
     * 计算平均功率因数 <br/>
     * 月平均功率因数 = 有功电量/(有功电量²+无功电量²),（四舍五入，保留两位小数点）
     * 
     * @param energyP
     * @param energyQ
     * @return
     */
    public static BigDecimal calPFAvg(BigDecimal energyP, BigDecimal energyQ) {
        if (energyP == null || energyQ == null) {
            return null;
        }
        double temp = Math.pow(energyP.doubleValue(), 2) + Math.pow(energyQ.doubleValue(), 2);
        temp = Math.sqrt(temp);
        if (temp == 0.0) {
            return null;
        }
        return energyP.divide(new BigDecimal(temp), 2, BigDecimal.ROUND_HALF_UP);
    }

}
