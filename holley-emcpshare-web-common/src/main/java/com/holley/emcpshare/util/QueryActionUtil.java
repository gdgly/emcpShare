package com.holley.emcpshare.util;

import org.apache.log4j.Logger;

public class QueryActionUtil {

    private final static Logger logger = Logger.getLogger(QueryActionUtil.class);

    /**
     * 推送充电信息
     * 
     * @param equipChargeStatusBase
     * @return
     * @throws Exception
     */
    // public synchronized static JSONObject notificationEquipChargeStatus(EquipChargeStatusBase equipChargeStatusBase)
    // throws Exception {
    // String token = queryToken();
    // if (StringUtil.isNotEmpty(token)) {
    // QueryBean qb = new QueryBean(new Date());
    // qb.setOperatorId(Globals.OPERATOR_ID);
    // JSONObject jsonobj = HttpRequestUtil.httpTest("notification_equip_charge_status", equipChargeStatusBase, qb,
    // token);
    // logger.info("resultMsg:" + jsonobj.getString("Msg"));
    // return jsonobj;
    // }
    // return null;
    // }

    private synchronized static String queryToken() throws Exception {
        return HttpRequestUtil.queryToken("348375727");
    }

}
