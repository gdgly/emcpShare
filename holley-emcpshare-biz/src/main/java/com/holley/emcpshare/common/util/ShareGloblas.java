package com.holley.emcpshare.common.util;

public class ShareGloblas {

    public static final Integer       TOKEN_AVAILABLE_TIME    = 60 * 60 * 24 * 7;         // token有效时间7天
    public static int                 COUNT_TIME              = 0;                        // 1秒内计数
    public static long                TIME_STTEMP             = 0;                        // 时间戳缓存
    public static ThreadLocal<String> threadLocal             = new ThreadLocal<String>();
    public static final String        KEY_TOKEN               = "keyToken_";              // 本站token

    public static final String        KEY_PUSH_TOKEN          = "keyPushToken_";          // 推送token
    public static final String        OPERATOR_ID             = "330414214";
    public static final String        START_CHARGE_INFO       = "keyStartChargeInfo";     // 开始充
    public static final String        DO_CHARGE_INFO          = "keyDoChargeInfo";        // 充电中
    public static final String        END_CHARGE_INFO         = "keyEndChargeInfo";       // 结束充电

    public static final long          MAX_DELAY_START_TIME    = 30L;                      // 秒
    public static final int           MAX_QUERY_MONTH         = 12;
    public static final int           MAX_HISTORY_DAYS        = 30;                       // 最大历史数据查询间隔（天）
    public static final int           F129                    = 129;
    public static final String        READING_STUFF           = "reading_";
    public static final String        REMOTE_DISCONNECT_STUFF = "remoteDisconnect_";
    public final static int           EXRP_30S                = 30;
    public final static int           EXRP_3M                 = 60 * 3;
    public static final String        LYSW_DELIMITER          = "|";                      // 龙游水务统一分隔符
    public final static int           BANK_RETURN_SIZE        = 13;                       // 银行返回统一长度
    public static final String        WATER_COMPANY_CODE      = "Jhzls";
}
