package com.holley.emcpshare.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import com.holley.emc.common.dcs.RtuCommData;
import com.holley.emcp.common.constants.DisconnectModeEnum;
import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcpshare.base.action.BaseAction;
import com.holley.emcpshare.comenum.AccountModifyFailReasonTypeEnum;
import com.holley.emcpshare.comenum.AccountRegisterFailReasonTypeEnum;
import com.holley.emcpshare.comenum.CmdResultEnum;
import com.holley.emcpshare.comenum.CustomerStatusEnum;
import com.holley.emcpshare.comenum.EnergyTypeEnum;
import com.holley.emcpshare.comenum.MeterPowerStatusEnum;
import com.holley.emcpshare.comenum.ObjectTypeEnum;
import com.holley.emcpshare.comenum.PayWayTypeEnum;
import com.holley.emcpshare.comenum.RechargeFailReasonTypeEnum;
import com.holley.emcpshare.comenum.RemoteDisconnectFailReasonTypeEnum;
import com.holley.emcpshare.comenum.RetTypeEnum;
import com.holley.emcpshare.comenum.SendMsgTypeEnum;
import com.holley.emcpshare.comenum.SuccStatTypeEnum;
import com.holley.emcpshare.comenum.TokenFailReasonTypeEnum;
import com.holley.emcpshare.common.util.ShareGloblas;
import com.holley.emcpshare.common.util.ShareUtil;
import com.holley.emcpshare.dcs.util.ProtocolBaseUtil;
import com.holley.emcpshare.dcs.util.ProtocolGW09Util;
import com.holley.emcpshare.dcs.util.ProtocolMeter645_1997Util;
import com.holley.emcpshare.dcs.util.ProtocolMeter645_2007Util;
import com.holley.emcpshare.model.ObjEnterprise;
import com.holley.emcpshare.model.ObjPoint;
import com.holley.emcpshare.model.ObjPointCommparam;
import com.holley.emcpshare.model.ObjSleepCmd;
import com.holley.emcpshare.model.ObjSleepCmdExample;
import com.holley.emcpshare.model.PpfCustomer;
import com.holley.emcpshare.model.PpfCustomerExample;
import com.holley.emcpshare.model.PpfRechargeExample;
import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.model.dcs.DcsResultBean;
import com.holley.emcpshare.model.dcs.MeterPackParamResultBean;
import com.holley.emcpshare.model.dcs.PackParamResultBaseBean;
import com.holley.emcpshare.model.dcs.PointDisconnDTO;
import com.holley.emcpshare.model.dcs.RtuPackParamResultBean;
import com.holley.emcpshare.model.def.AccountRegisterInfo;
import com.holley.emcpshare.model.def.OperatorSecretKeyBase;
import com.holley.emcpshare.model.def.RechargeBase;
import com.holley.emcpshare.model.def.RemoteDisconnectBase;
import com.holley.emcpshare.model.def.ShareResultBean;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.NumberUtil;
import com.holley.platform.common.util.StringUtil;
import com.holley.platform.common.web.util.Validator;

/**
 * 共享信息
 * 
 * @author sc
 */
public class ServiceAction extends BaseAction {

    private final static Logger logger     = Logger.getLogger(ServiceAction.class);
    private ShareResultBean     resultBean = new ShareResultBean();

    /**
     * 请求token
     * 
     * @return
     * @throws Exception
     */
    public String queryToken() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        OperatorSecretKeyBase secretKey = new OperatorSecretKeyBase();
        secretKey.setOperatorId(ShareGloblas.OPERATOR_ID);
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String operatorsecret = getDataString(data, "operatorSecret");
        if (sk == null) {// 无此运营商
            secretKey.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            secretKey.setFailReason(TokenFailReasonTypeEnum.UNKNOWN_OPERATOR.getValue());
            secretKey.setOperatorId(operatorId);
            resultBean.setData(secretKey);
            return SUCCESS;
        }
        if (!sk.getOperatorsecret().equals(operatorsecret)) {
            secretKey.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            secretKey.setFailReason(TokenFailReasonTypeEnum.ERROR_SECRET_KEY.getValue());
            secretKey.setOperatorId(operatorId);
            resultBean.setData(secretKey);
            return SUCCESS;
        }

        secretKey.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
        secretKey.setFailReason(TokenFailReasonTypeEnum.NIL.getValue());
        secretKey.setTokenAvailableTime(ShareGloblas.TOKEN_AVAILABLE_TIME);
        secretKey.setAccessToken(saveOperatorToken(operatorId));
        resultBean.setData(secretKey);
        return SUCCESS;
    }

    /**
     * 账户充值
     * 
     * @return
     * @throws Exception
     */
    public String accountRecharge() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String hh = getDataString(data, "userId");// 用户Id
        String tradeNo = getDataString(data, "tradeNo");// 订单号
        String moneyStr = getDataString(data, "money");// 充值金额
        RechargeBase rechargeBase = new RechargeBase();
        rechargeBase.setTradeNo(tradeNo);
        if (StringUtil.isEmpty(hh) || !checkUserByHH(hh, sk.getEid())) {
            rechargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            rechargeBase.setFailReason(RechargeFailReasonTypeEnum.BAD_ACCOUNT.getValue());
            resultBean.setData(rechargeBase);
            return SUCCESS;
        }
        if (StringUtil.isEmpty(tradeNo)) {
            rechargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            rechargeBase.setFailReason(RechargeFailReasonTypeEnum.BAD_TRADENO.getValue());
            resultBean.setData(rechargeBase);
            return SUCCESS;
        }
        if (!NumberUtils.isNumber(moneyStr)) {
            rechargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            rechargeBase.setFailReason(RechargeFailReasonTypeEnum.BAD_MONEY.getValue());
            resultBean.setData(rechargeBase);
            return SUCCESS;
        }
        BigDecimal money = NumberUtil.formateScale2(new BigDecimal(moneyStr));
        if (money.doubleValue() < 0.01 || money.doubleValue() > 10000000) {
            rechargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            rechargeBase.setFailReason(RechargeFailReasonTypeEnum.BAD_MONEY.getValue());
            resultBean.setData(rechargeBase);
            return SUCCESS;
        }

        PpfCustomerExample customerEmp = new PpfCustomerExample();
        PpfCustomerExample.Criteria customerCr = customerEmp.createCriteria();
        customerCr.andHhEqualTo(hh);
        customerCr.andEidEqualTo(sk.getEid());
        customerCr.andStatusEqualTo(CustomerStatusEnum.RUNING.getShortValue());
        List<PpfCustomer> customerlist = commonService.selectCustomerByExample(customerEmp);
        if (customerlist == null || customerlist.isEmpty()) {
            rechargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            rechargeBase.setFailReason(RechargeFailReasonTypeEnum.BAD_ACCOUNT.getValue());
            resultBean.setData(rechargeBase);
            return SUCCESS;
        }
        PpfCustomer customer = customerlist.get(0);
        PpfRechargeExample rechargeEmp = new PpfRechargeExample();
        PpfRechargeExample.Criteria rechargeCr = rechargeEmp.createCriteria();
        rechargeCr.andCustomeridEqualTo(customer.getCustomerid());
        rechargeCr.andPaywayEqualTo(PayWayTypeEnum.INTERFACE.getShortValue());
        rechargeCr.andTradenoEqualTo(tradeNo);
        int count = commonService.countRechargeByExample(rechargeEmp);
        if (count > 0) {
            rechargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            rechargeBase.setFailReason(RechargeFailReasonTypeEnum.REPEAT_TRADENO.getValue());
            resultBean.setData(rechargeBase);
            return SUCCESS;
        }
        if (commonService.insertRechargeAndUpdateAccount(customer, tradeNo, money)) {
            rechargeBase.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
            rechargeBase.setFailReason(RechargeFailReasonTypeEnum.NIL.getValue());
        } else {
            rechargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
        }

        resultBean.setData(rechargeBase);
        return SUCCESS;
    }

    /**
     * 远程拉合闸
     * 
     * @return
     * @throws Exception
     */
    public String remoteDisconnect() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String pointId = getDataString(data, "pointId");// 设备号
        int operType = getDataInt(data, "operType");// 操作类型

        SwitchTypeEnum switchType = SwitchTypeEnum.getEnmuByValue(operType);
        if (switchType == null || StringUtil.isEmpty(pointId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        logger.info("远程拉合闸操作描述：" + switchType);
        RemoteDisconnectBase remoteDisconnectBase = new RemoteDisconnectBase();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("status", 1);// 运行
        map.put("commaddr", pointId);// 通讯地址
        map.put("objtype", ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());
        ObjPoint point = commonService.selectPointByMap(map);

        if (point == null) {
            remoteDisconnectBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            remoteDisconnectBase.setFailReason(RemoteDisconnectFailReasonTypeEnum.UNKNOWN_DEVICE.getValue());
            resultBean.setData(remoteDisconnectBase);
            return SUCCESS;
        }
        PointDisconnDTO dto = commonService.queryPointParam(point.getRtuid(), point.getPointid());
        if (DisconnectModeEnum.UNALLOWED.getShortValue().equals(dto.getDisconnectmode())) {
            remoteDisconnectBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            remoteDisconnectBase.setFailReason(RemoteDisconnectFailReasonTypeEnum.NOT_ALLOW.getValue());
            resultBean.setData(remoteDisconnectBase);
            return SUCCESS;
        }
        if (EnergyTypeEnum.POWER.getValue() == point.getEnergytypeid()) {// 电表
            if (localCacheUtil.getDisconnectObj(pointId, operatorId) != null) {
                remoteDisconnectBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
                remoteDisconnectBase.setFailReason(RemoteDisconnectFailReasonTypeEnum.NOT_REPEAT.getValue());
                resultBean.setData(remoteDisconnectBase);
                return SUCCESS;
            }
            localCacheUtil.saveDisconnectObj(pointId, operatorId);
            ProtocolBaseUtil util = new ProtocolGW09Util();
            PackParamResultBaseBean parambean = util.packParam4Disconnect(switchType, dto, point.getRtuid());
            DcsResultBean dcsResultBean = null;
            if (parambean instanceof MeterPackParamResultBean) {// 电表拉合闸
                MeterPackParamResultBean baseBean = (MeterPackParamResultBean) parambean;
                if (!baseBean.isSuccess()) {
                    remoteDisconnectBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
                    resultBean.setData(remoteDisconnectBase);
                    localCacheUtil.delDisconnectObj(pointId, operatorId);
                    return SUCCESS;
                }
                List<RtuCommData> rslist = null;
                try {
                    rslist = commonService.setup2(baseBean.getRtuIdList(), baseBean.getPnStr(), baseBean.getItemDataList(), baseBean.getValidtime());
                } catch (Exception e) {
                    // localCacheUtil.delDisconnectObj(pointId, operatorId);
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
                    // localCacheUtil.delDisconnectObj(pointId, operatorId);
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
                remoteDisconnectBase.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
                remoteDisconnectBase.setFailReason(RemoteDisconnectFailReasonTypeEnum.NIL.getValue());
                resultBean.setData(remoteDisconnectBase);
                localCacheUtil.delDisconnectObj(pointId, operatorId);
                return SUCCESS;
            }
        } else if (EnergyTypeEnum.WATER.getValue() == point.getEnergytypeid()) {// 水表
            ObjSleepCmdExample emp = new ObjSleepCmdExample();
            ObjSleepCmdExample.Criteria cr = emp.createCriteria();
            cr.andObjidEqualTo(point.getPointid());
            cr.andCmdtypeEqualTo(switchType.getShortValue());
            cr.andStatusEqualTo(CmdResultEnum.SENDING.getShortValue());
            cr.andObjtypeEqualTo(ObjectTypeEnum.OBJ_POINT.getShortValue());
            int count = commonService.countSleepCmdByExample(emp);
            // 如果有重复指令未执行的直接返回成功
            if (count > 0) {
                remoteDisconnectBase.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
                remoteDisconnectBase.setFailReason(RemoteDisconnectFailReasonTypeEnum.NIL.getValue());
                resultBean.setData(remoteDisconnectBase);
                return SUCCESS;
            }
            // 插入新指令并返回成功
            ObjSleepCmd objSleepCmd = new ObjSleepCmd();
            objSleepCmd.setCmdtype(switchType.getShortValue());
            objSleepCmd.setCreatetime(new Date());
            objSleepCmd.setObjid(point.getPointid());
            objSleepCmd.setObjtype(ObjectTypeEnum.OBJ_POINT.getShortValue());
            objSleepCmd.setSendtype(SendMsgTypeEnum.MANUAL.getShortValue());
            objSleepCmd.setStatus(CmdResultEnum.SENDING.getShortValue());
            if (commonService.insertSleepCmd(objSleepCmd) > 0) {
                remoteDisconnectBase.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
                remoteDisconnectBase.setFailReason(RemoteDisconnectFailReasonTypeEnum.NIL.getValue());
                resultBean.setData(remoteDisconnectBase);
                return SUCCESS;
            }
        }
        remoteDisconnectBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
        remoteDisconnectBase.setFailReason(RemoteDisconnectFailReasonTypeEnum.NOT_ALLOW.getValue());
        resultBean.setData(remoteDisconnectBase);
        localCacheUtil.delDisconnectObj(pointId, operatorId);
        return SUCCESS;
    }

    public String accountModify() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String userId = getDataString(data, "userId");// 户号
        String phone = getDataString(data, "phone");// 用户手机号码
        String name = getDataString(data, "name");// 用户名称
        String linkman = getDataString(data, "linkman");// 联系人
        AccountRegisterInfo accountInfo = new AccountRegisterInfo();
        accountInfo.setUserId(userId);
        if (StringUtil.isEmpty(userId)) {
            accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            accountInfo.setFailReason(AccountModifyFailReasonTypeEnum.BAD_PARAM.getValue());
            resultBean.setData(accountInfo);
            return SUCCESS;
        }

        PpfCustomer modifyCustomer = new PpfCustomer();
        PpfCustomerExample cusEmp = new PpfCustomerExample();
        PpfCustomerExample.Criteria cusCr = cusEmp.createCriteria();
        cusCr.andEidEqualTo(sk.getEid());
        cusCr.andHhEqualTo(userId);
        cusCr.andStatusGreaterThan((short) 0);
        List<PpfCustomer> list = commonService.selectCustomerByExample(cusEmp);
        if (list == null || list.isEmpty()) {
            accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            accountInfo.setFailReason(AccountModifyFailReasonTypeEnum.BAD_PARAM.getValue());
            resultBean.setData(accountInfo);
            return SUCCESS;
        }
        PpfCustomer cus = list.get(0);
        int count = 0;
        modifyCustomer.setCustomerid(cus.getCustomerid());
        if (StringUtil.isNotEmpty(phone)) {
            if (!Validator.isMobile(phone)) {
                accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
                accountInfo.setFailReason(AccountModifyFailReasonTypeEnum.BAD_PARAM.getValue());
                resultBean.setData(accountInfo);
                return SUCCESS;
            }
            // cusEmp.clear();
            // cusCr = cusEmp.createCriteria();
            // cusCr.andEidEqualTo(sk.getEid());
            // cusCr.andPhoneEqualTo(phone);
            // cusCr.andHhNotEqualTo(userId);
            // cusCr.andStatusGreaterThan((short) 0);
            // count = commonService.countCustomerByExample(cusEmp);
            // if (count > 0) {
            // accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            // accountInfo.setFailReason(AccountModifyFailReasonTypeEnum.REPEAT_PHONE.getValue());
            // resultBean.setData(accountInfo);
            // return SUCCESS;
            // }
            modifyCustomer.setPhone(phone);
        }
        if (StringUtil.isNotEmpty(name)) {
            // cusEmp.clear();
            // cusCr = cusEmp.createCriteria();
            // cusCr.andEidEqualTo(sk.getEid());
            // cusCr.andHmEqualTo(name);
            // cusCr.andHhNotEqualTo(userId);
            // cusCr.andStatusGreaterThan((short) 0);
            // count = commonService.countCustomerByExample(cusEmp);
            // if (count > 0) {
            // accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            // accountInfo.setFailReason(AccountModifyFailReasonTypeEnum.REPEAT_HM.getValue());
            // resultBean.setData(accountInfo);
            // return SUCCESS;
            // }
            modifyCustomer.setHm(name);
        }
        if (StringUtil.isNotEmpty(linkman)) {
            modifyCustomer.setLinkman(linkman);
        }
        modifyCustomer.setUpdatetime(new Date());
        commonService.updateAccount(modifyCustomer, getRemoteIP(), cus.getCreator());
        resultBean.setData(accountInfo);
        return SUCCESS;
    }

    public String accountRegister() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String userId = getDataString(data, "userId");// 户号
        String phone = getDataString(data, "phone");// 用户手机号码
        String time = getDataString(data, "time");// 用户注册时间yyyy-MM-dd HH:mm:ss
        String name = getDataString(data, "name");// 用户名称
        String linkman = getDataString(data, "linkman");// 联系人
        AccountRegisterInfo accountInfo = new AccountRegisterInfo();
        accountInfo.setUserId(userId);
        if (StringUtil.isNull(userId, phone, time, name, linkman)) {
            accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            accountInfo.setFailReason(AccountModifyFailReasonTypeEnum.BAD_PARAM.getValue());
            resultBean.setData(accountInfo);
            return SUCCESS;
        }

        if (!Validator.isMobile(phone) || !ShareUtil.isHH(userId)) {
            accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            accountInfo.setFailReason(AccountModifyFailReasonTypeEnum.BAD_PARAM.getValue());
            resultBean.setData(accountInfo);
            return SUCCESS;
        }

        int count = 0;
        PpfCustomerExample cusEmp = new PpfCustomerExample();
        PpfCustomerExample.Criteria cusCr = cusEmp.createCriteria();
        cusCr.andEidEqualTo(sk.getEid());
        cusCr.andHhEqualTo(userId);
        cusCr.andStatusGreaterThan((short) 0);
        count = commonService.countCustomerByExample(cusEmp);
        if (count > 0) {
            accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            accountInfo.setFailReason(AccountRegisterFailReasonTypeEnum.REPEAT_HH.getValue());
            resultBean.setData(accountInfo);
            return SUCCESS;
        }
        // cusEmp.clear();
        // cusCr = cusEmp.createCriteria();
        // cusCr.andEidEqualTo(sk.getEid());
        // cusCr.andHmEqualTo(name);
        // cusCr.andStatusGreaterThan((short) 0);
        // count = commonService.countCustomerByExample(cusEmp);
        // if (count > 0) {
        // accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
        // accountInfo.setFailReason(AccountRegisterFailReasonTypeEnum.REPEAT_HM.getValue());
        // resultBean.setData(accountInfo);
        // return SUCCESS;
        // }
        // cusEmp.clear();
        // cusCr = cusEmp.createCriteria();
        // cusCr.andEidEqualTo(sk.getEid());
        // cusCr.andPhoneEqualTo(phone);
        // cusCr.andStatusGreaterThan((short) 0);
        // count = commonService.countCustomerByExample(cusEmp);
        // if (count > 0) {
        // accountInfo.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
        // accountInfo.setFailReason(AccountRegisterFailReasonTypeEnum.REPEAT_PHONE.getValue());
        // resultBean.setData(accountInfo);
        // return SUCCESS;
        // }

        ObjEnterprise ent = commonService.selectEnterpriseByPrimaryKey(sk.getEid());
        Date cratetime = DateUtil.StrToDate(time, DateUtil.TIME_LONG);
        PpfCustomer customer = new PpfCustomer();
        customer.setCreatetime(cratetime);
        customer.setCreator("interface_" + ent.getEid());
        customer.setDemandprop((short) 0);
        customer.setEid(sk.getEid());
        customer.setHh(userId);
        customer.setHm(name);
        customer.setLinkman(linkman);
        customer.setPhone(phone);
        customer.setStatus((short) 1);// 激活
        customer.setType((short) 1);// 个人
        customer.setUpdatetime(new Date());
        customer.setDemandprop((short) 1);
        commonService.insertAccount(customer, getRemoteIP());
        resultBean.setData(accountInfo);
        return SUCCESS;
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

    // GET SET
    public ShareResultBean getResultBean() {
        return resultBean;
    }

}
