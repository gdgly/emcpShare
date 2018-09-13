package com.holley.emcpshare.common.util;

import java.util.List;

import net.sf.json.JSONObject;

import com.holley.emc.common.dcs.RtuCommData;
import com.holley.emcp.common.constants.DisconnectModeEnum;
import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcpshare.comenum.MeterPowerStatusEnum;
import com.holley.emcpshare.dcs.util.ProtocolBaseUtil;
import com.holley.emcpshare.dcs.util.ProtocolGW09Util;
import com.holley.emcpshare.dcs.util.ProtocolMeter645_1997Util;
import com.holley.emcpshare.dcs.util.ProtocolMeter645_2007Util;
import com.holley.emcpshare.model.ObjPoint;
import com.holley.emcpshare.model.ObjPointCommparam;
import com.holley.emcpshare.model.dcs.DcsResultBean;
import com.holley.emcpshare.model.dcs.MeterPackParamResultBean;
import com.holley.emcpshare.model.dcs.PackParamResultBaseBean;
import com.holley.emcpshare.model.dcs.PointDisconnDTO;
import com.holley.emcpshare.model.dcs.RtuPackParamResultBean;
import com.holley.emcpshare.service.share.CommonService;

public class DisconnectJob implements Runnable {

    private CommonService  commonService;
    private ObjPoint       point;
    private SwitchTypeEnum switchType;

    public DisconnectJob(CommonService commonService, ObjPoint point, SwitchTypeEnum switchType) {
        this.commonService = commonService;
        this.point = point;
        this.switchType = switchType;
    }

    @Override
    public void run() {
        PointDisconnDTO dto = commonService.queryPointParam(point.getRtuid(), point.getPointid());
        if (dto != null && !DisconnectModeEnum.UNALLOWED.getShortValue().equals(dto.getDisconnectmode())) {
            ProtocolBaseUtil util = new ProtocolGW09Util();
            PackParamResultBaseBean parambean = util.packParam4Disconnect(switchType, dto, point.getRtuid());
            DcsResultBean dcsResultBean = null;
            if (parambean instanceof MeterPackParamResultBean) {// 电表拉合闸
                MeterPackParamResultBean baseBean = (MeterPackParamResultBean) parambean;

                List<RtuCommData> rslist = null;
                try {
                    rslist = commonService.setup2(baseBean.getRtuIdList(), baseBean.getPnStr(), baseBean.getItemDataList(), baseBean.getValidtime());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dcsResultBean = returnMeterResult(rslist, switchType, dto.getProtocol());
            } else if (parambean instanceof RtuPackParamResultBean) {// 终端拉合闸
                RtuPackParamResultBean baseBean = (RtuPackParamResultBean) parambean;
                List<String> rslist = null;
                try {
                    rslist = commonService.ctrl(baseBean.getRtuIdList(), baseBean.getPnStr(), baseBean.getItemDataList(), baseBean.getPointStr(), baseBean.getPointTypeStr(),
                                                baseBean.getPortStr(), baseBean.getCommaddressStr(), baseBean.getBaud(), baseBean.getValidtime());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dcsResultBean = returnRtuResult(rslist, switchType);
            }
            if (dcsResultBean.isSuccess()) {
                ObjPointCommparam record = new ObjPointCommparam();
                record.setPointid(point.getPointid());
                if (SwitchTypeEnum.DISCONNECT == switchType) {
                    record.setPowerstatus(MeterPowerStatusEnum.POWER_OFF.getShortValue());
                } else {
                    record.setPowerstatus(MeterPowerStatusEnum.POWER_ON.getShortValue());
                }
                commonService.updatePointCommParamByPKSelective(record);// 更新电表状态

                commonService.recordControlCmdLog(point.getPointid(), switchType);// 插入拉合闸日志
            }
        }

    }

    /**
     * 电表拉合闸返回结果
     * 
     * @param rslist
     * @param type
     * @return
     */
    private DcsResultBean returnMeterResult(List<RtuCommData> rslist, SwitchTypeEnum type, int protocolid) {
        DcsResultBean resultBean = new DcsResultBean();
        if (rslist == null || rslist.size() == 0) {
            resultBean.setSuccess(false);
            resultBean.setMsg(type.getText() + "失败");
            return resultBean;
        }
        RtuCommData rdata = rslist.get(0);
        if (rdata.isDataError()) {
            resultBean.setSuccess(false);
            resultBean.setMsg(type.getText() + "失败");
            return resultBean;
        }

        // 如终端透传应答成功，则检验电表应答帧是否成功
        String stringValue = rdata.getPnValueMap().get(0).getDataList().get(0).getStringValue();
        if (protocolid == 1) {// 1:DL/T 645—1997,
            resultBean = ProtocolMeter645_1997Util.validDisconnectResult(stringValue);
        } else {// 30:DL/T 645-2007
            resultBean = ProtocolMeter645_2007Util.validDisconnectResult(stringValue);
        }
        if (!resultBean.isSuccess()) {
            resultBean.setMsg(type.getText() + "失败");
        }
        return resultBean;
    }

    /**
     * 终端拉合闸返回结果
     * 
     * @param rslist
     * @param type
     * @return
     */
    private DcsResultBean returnRtuResult(List<String> rslist, SwitchTypeEnum type) {
        DcsResultBean resultBean = new DcsResultBean();
        if (rslist == null || rslist.size() == 0) {
            resultBean.setSuccess(false);
            resultBean.setMsg(type.getText() + "失败");
            return resultBean;
        }
        String beanStr = rslist.get(0);
        RtuCommData rdata = (RtuCommData) JSONObject.toBean(JSONObject.fromObject(beanStr), RtuCommData.class);
        if (rdata.isDataError()) {
            resultBean.setSuccess(false);
            resultBean.setMsg(type.getText() + "失败");
            return resultBean;
        }
        resultBean.setSuccess(true);
        return resultBean;
    }
}
