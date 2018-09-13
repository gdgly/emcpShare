package com.holley.emcpshare.model.bank;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.math.NumberUtils;

public class SurchargeConfig {

    public static int    eid;       // 企业Id
    public static int    delayMonth; // 延期月数
    public static int    cutCount;  // 推送次数
    public static String rate;      // 费率
    static {
        InputStream inStream = SurchargeConfig.class.getClassLoader().getResourceAsStream("openActive.properties");
        Properties prop = new Properties();
        try {
            prop.load(inStream);
            eid = NumberUtils.toInt(prop.getProperty("eid"));
            delayMonth = NumberUtils.toInt(prop.getProperty("delayMonth"));
            cutCount = NumberUtils.toInt(prop.getProperty("cutCount"));
            rate = prop.getProperty("rate");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
