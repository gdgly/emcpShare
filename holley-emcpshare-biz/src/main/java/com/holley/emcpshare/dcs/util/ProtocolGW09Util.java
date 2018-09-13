package com.holley.emcpshare.dcs.util;

import com.holley.emcp.common.constants.DisconnectModeEnum;
import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcp.common.utils.NumberUtil;
import com.holley.emcp.common.utils.StringUtil;
import com.holley.emcpshare.dcsenum.MeterProtocolEnum;
import com.holley.emcpshare.model.dcs.DcsResultBean;
import com.holley.emcpshare.model.dcs.GWItemData;
import com.holley.emcpshare.model.dcs.MeterPackParamResultBean;
import com.holley.emcpshare.model.dcs.PackParamResultBaseBean;
import com.holley.emcpshare.model.dcs.PointDisconnDTO;
import com.holley.emcpshare.model.dcs.RtuPackParamResultBean;

/**
 * 电表拉闸
 * 
 * @author sc
 */
public class ProtocolGW09Util implements ProtocolBaseUtil {

    /**
     * 组成报文---电表拉合闸
     */
    @Override
    public PackParamResultBaseBean packParam4Disconnect(SwitchTypeEnum type, PointDisconnDTO con, Integer rtuId) {
        if (DisconnectModeEnum.RTU_DISC_ALLOW.getShortValue().equals(con.getDisconnectmode())) {
            return packParam4RtuDisconnect(type, con, rtuId);
        } else {
            return packParam4MeterDisconnect(type, con, rtuId);
        }
    }

    /**
     * 电表拉合闸组参
     * 
     * @param type
     * @param con
     * @param rtuId
     * @return
     */
    private MeterPackParamResultBean packParam4MeterDisconnect(SwitchTypeEnum type, PointDisconnDTO con, Integer rtuId) {
        MeterPackParamResultBean rs = new MeterPackParamResultBean();
        rs.getRtuIdList().add(rtuId);
        if (con == null) {
            rs.setMsg("拉合闸失败");
            rs.setSuccess(false);
            return rs;
        }
        if (con.getProtocol() != MeterProtocolEnum.PROTOCOL_645_1997.getValue() && con.getProtocol() != MeterProtocolEnum.PROTOCOL_645_2007.getValue()) {
            rs.setMsg("目前拉合闸功能暂时只支持DL/T 645—1997和DL/T 645-2007协议");
            rs.setSuccess(false);
            return rs;
        }

        String fvalue = "";
        String data = "";
        String n1;// 控制命令类型(N1)
        if (con.getProtocol() == MeterProtocolEnum.PROTOCOL_645_1997.getValue()) {// 1:DL/T 645—1997
            // 终端透明转发内容之前的数据帧,透明转发内容字节数(20)
            fvalue = ProtocolGW09Helper.makeGWTransitDataFrame(con, 20);
            n1 = ProtocolMeter645_1997Util.packDisconnectDi(type);
            if (StringUtil.isEmpty(n1)) {
                rs.setMsg("指令有误");
                rs.setSuccess(false);
                return rs;
            }
            data = ProtocolMeter645_1997Util.packDisconnect(con.getCommaddr(), con.getSafetylevel(), con.getSafetypwd(), n1);

        } else {// 30:DL/T 645-2007协议
            // 终端透明转发内容之前的数据帧,透明转发内容字节数(28)
            fvalue = ProtocolGW09Helper.makeGWTransitDataFrame(con, 28);
            DisconnectModeEnum mode = con.getDisconnectmode() == null ? null : DisconnectModeEnum.getEnmuByValue(con.getDisconnectmode().intValue());
            n1 = ProtocolMeter645_2007Util.packDisconnectDi(type, mode);
            if (StringUtil.isEmpty(n1)) {
                rs.setMsg("指令有误");
                rs.setSuccess(false);
                return rs;
            }
            data = ProtocolMeter645_2007Util.packDisconnect(con.getCommaddr(), con.getSafetylevel(), con.getSafetypwd(), n1);
        }

        fvalue = data + fvalue;

        GWItemData item = new GWItemData();
        item.setFn(1);
        item.setData(fvalue);
        rs.getItemDataList().add(item);
        return rs;
    }

    private RtuPackParamResultBean packParam4RtuDisconnect(SwitchTypeEnum type, PointDisconnDTO con, Integer rtuId) {
        RtuPackParamResultBean rs = new RtuPackParamResultBean();
        GWItemData data = new GWItemData();
        String tempStr = "";
        if (type == SwitchTypeEnum.DISCONNECT) {
            data.setFn(SwitchTypeEnum.DISCONNECT.getValue());
            String limitString = NumberUtil.num2PadString(0, 16, 1, "0");
            String delayString = NumberUtil.num2PadString(0, 16, 1, "0");
            tempStr = delayString + limitString + tempStr;
            data.setData(tempStr);
        } else if (type == SwitchTypeEnum.CONNECT) {
            data.setFn(SwitchTypeEnum.CONNECT.getValue());
        }

        rs.getRtuIdList().add(rtuId);
        rs.setPnStr("1");// 固定值
        rs.getItemDataList().add(data);
        return rs;
    }

    /**
     * 组成报文---电表运行状态字(透传)
     */
    @Override
    public PackParamResultBaseBean packParam4PointPowerStatus(PointDisconnDTO con, Integer rtuId) {
        MeterPackParamResultBean rs = new MeterPackParamResultBean();
        rs.getRtuIdList().add(rtuId);
        if (con == null) {
            rs.setMsg("召读失败");
            rs.setSuccess(false);
            return rs;
        }
        if (con.getProtocol() != MeterProtocolEnum.PROTOCOL_645_1997.getValue() && con.getProtocol() != MeterProtocolEnum.PROTOCOL_645_2007.getValue()) {
            rs.setMsg("目前拉合闸功能暂时只支持DL/T 645—1997和DL/T 645-2007协议");
            rs.setSuccess(false);
            return rs;
        }
        // 终端透明转发内容之前的数据帧,透明转发内容字节数(16)
        String fvalue = ProtocolGW09Helper.makeGWTransitDataFrame(con, 16);

        String data;
        if (con.getProtocol() == 1) {// DL/T 645—1997
            data = ProtocolMeter645_1997Util.packCallData(con.getCommaddr(), "C029");
        } else {// DL/T 645-2007协议
            // 终端透明转发内容
            data = ProtocolMeter645_2007Util.packCallData(con.getCommaddr(), ProtocolMeter645Constant.RUN_STATUS_3);
        }

        fvalue = data + fvalue;

        GWItemData item = new GWItemData();
        item.setFn(1);
        item.setData(fvalue);
        rs.getItemDataList().add(item);
        return rs;
    }

    @Override
    public DcsResultBean parseData4PointRunStatus(int protocolid, String value) {
        DcsResultBean result = ProtocolGW09Helper.getParseGWTransitDataContent(value);
        DcsResultBean checkResult = ProtocolMeter645Helper.checkRecvData(result.getData().toString());

        if (checkResult.isSuccess()) {
            if (protocolid == MeterProtocolEnum.PROTOCOL_645_1997.getValue()) {// DL/T 645—1997
                result = ProtocolMeter645_1997Util.parseCallData((String) checkResult.getData());
            } else {
                result = ProtocolMeter645_2007Util.parseCallData((String) checkResult.getData());
            }
        } else {
            result.setSuccess(false);
            result.setMsg("召读失败");
        }
        return result;
    }

}
