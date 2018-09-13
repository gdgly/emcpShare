package com.holley.emcpshare.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.service.share.CommonService;
import com.holley.platform.common.cache.RedisUtil;
import com.holley.platform.common.util.StringUtil;

public class LocalCacheUtil {

    @Resource
    private CommonService             commonService;
    private Map<String, SysSecretKey> sysSecretKeyMap = new HashMap<String, SysSecretKey>();

    public void init() {
        initSecretKey();
    }

    private void initSecretKey() {
        List<SysSecretKey> list = commonService.selectSecretKeyByExample(null);
        if (list != null && list.size() > 0) {
            for (SysSecretKey key : list) {
                sysSecretKeyMap.put(key.getOperatorid(), key);
            }
        }
    }

    /**
     * 根据运营商ID获取密钥信息
     * 
     * @param operatorID
     * @return
     */
    public SysSecretKey getSecretKeyByOperatorID(String operatorID) {
        if (StringUtil.isEmpty(operatorID)) {
            return null;
        }
        if (!sysSecretKeyMap.containsKey(operatorID)) {
            reloadSecretKey(operatorID);
        }
        return sysSecretKeyMap.get(operatorID);
    }

    /**
     * 更新运营商密钥
     */
    public synchronized void reloadSecretKey(String operatorID) {
        SysSecretKey key = commonService.selectSecretKeyByPrimaryKey(operatorID);
        if (key != null) {
            sysSecretKeyMap.put(operatorID, key);
        }
        // Date updateTime = ChargingCacheUtil.getUpdateTime(CacheKeyProvide.KEY_SECTET_KEY_UPDATETIME);
        // if (secretKeyUpdateTime == null || updateTime == null) return;
        // if (secretKeyUpdateTime.getTime() < updateTime.getTime()) {
        // SysSecretKeyExample emp = new SysSecretKeyExample();
        // SysSecretKeyExample.Criteria cr = emp.createCriteria();
        // cr.andTimeGreaterThanOrEqualTo(secretKeyUpdateTime);
        // List<SysSecretKey> list = commonService.querySysSecretKeyByExample(emp);
        // for (SysSecretKey record : list) {
        // sysSecretKeyMap.put(record.getOperatorid(), record);
        // }
        // secretKeyUpdateTime = updateTime;
        // }

    }

    // 防止重复读取电表数据
    public void saveReadingObj(String key, String operatorId) {
        RedisUtil.setString(ShareGloblas.READING_STUFF + operatorId + "_" + key, key, ShareGloblas.EXRP_3M);
    }

    public void delReadingObj(String key, String operatorId) {
        RedisUtil.delKey(ShareGloblas.READING_STUFF + operatorId + "_" + key);
    }

    public String getReadingObj(String key, String operatorId) {
        return RedisUtil.getString(ShareGloblas.READING_STUFF + operatorId + "_" + key);
    }

    // 防止重复拉合闸操作
    public void saveDisconnectObj(String key, String operatorId) {
        RedisUtil.setString(ShareGloblas.REMOTE_DISCONNECT_STUFF + operatorId + "_" + key, key, ShareGloblas.EXRP_3M);
    }

    public void delDisconnectObj(String key, String operatorId) {
        RedisUtil.delKey(ShareGloblas.REMOTE_DISCONNECT_STUFF + operatorId + "_" + key);
    }

    public String getDisconnectObj(String key, String operatorId) {
        return RedisUtil.getString(ShareGloblas.REMOTE_DISCONNECT_STUFF + operatorId + "_" + key);
    }

}
