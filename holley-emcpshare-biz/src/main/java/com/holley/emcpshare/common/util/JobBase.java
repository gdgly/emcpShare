package com.holley.emcpshare.common.util;

import net.sf.json.JSONObject;

import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.service.share.CommonService;

public abstract class JobBase implements Runnable {

    protected boolean        isRun = true;
    protected LocalCacheUtil localCacheUtil;
    protected String         operatorID;
    protected CommonService  commonService;

    public JobBase(String operatorID, LocalCacheUtil localCacheUtil, CommonService commonService) {
        this.operatorID = operatorID;
        this.localCacheUtil = localCacheUtil;
        this.commonService = commonService;
    }

    // protected ConnectorStatusTypeEnum returnPileStatus(PileStatusEnum temp) {
    // if (PileStatusEnum.OFFLINE == temp) {
    // return ConnectorStatusTypeEnum.OFF_LINE;
    // } else if (PileStatusEnum.IDLE == temp || PileStatusEnum.FINISH == temp) {
    // return ConnectorStatusTypeEnum.IDLE;
    // } else if (PileStatusEnum.BUSYING == temp) {
    // return ConnectorStatusTypeEnum.UN_CHARGING;
    // } else if (PileStatusEnum.CHARGING == temp) {
    // return ConnectorStatusTypeEnum.CHARGING;
    // } else if (PileStatusEnum.FAULT == temp) {
    // return ConnectorStatusTypeEnum.FAULT;
    // } else {
    // return ConnectorStatusTypeEnum.OFF_LINE;
    // }
    // }

    protected JSONObject getDecodeData(String enData, SysSecretKey sk) throws Exception {
        String str = ShareSecurityUtil.aesDecrypt(enData, sk.getDatasecret(), sk.getDatasecretiv());
        return JSONObject.fromObject(str);
    }

    protected int getDataInt(JSONObject data, String key) {
        return data.getInt(key);
    }

    protected String getDataStr(JSONObject data, String key) {
        return data.getString(key);
    }

    protected void stop() {
        isRun = false;
    }

}
