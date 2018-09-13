package com.holley.emcpshare.dcs.util;

import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcpshare.model.dcs.DcsResultBean;
import com.holley.emcpshare.model.dcs.PackParamResultBaseBean;
import com.holley.emcpshare.model.dcs.PointDisconnDTO;

public interface ProtocolBaseUtil {

    /**
     * 组成报文--电表拉合闸
     * 
     * @return
     */
    PackParamResultBaseBean packParam4Disconnect(SwitchTypeEnum type, PointDisconnDTO con, Integer rtuId);

    /**
     * 组成报文--电表运行状态字
     * 
     * @param con
     * @param rtuId
     * @return
     */
    PackParamResultBaseBean packParam4PointPowerStatus(PointDisconnDTO con, Integer rtuId);

    /**
     * 解析报文
     * 
     * @param value
     * @return
     */
    DcsResultBean parseData4PointRunStatus(int protocolid, String value);

}
