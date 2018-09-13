package com.holley.emcpshare.service.shareImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSON;
import com.holley.emc.common.dcs.DCSResult;
import com.holley.emc.common.dcs.RtuCommData;
import com.holley.emcp.common.constants.ProtocolTypeEnum;
import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcp.common.exception.CommunicationException;
import com.holley.emcp.common.utils.MsgUtil;
import com.holley.emcp.dcs.protocol.ProtocolGW09;
import com.holley.emcp.dcs.service.ICommForThird;
import com.holley.emcpshare.comenum.CmdResultEnum;
import com.holley.emcpshare.comenum.EnergyTypeEnum;
import com.holley.emcpshare.comenum.PayStatusEnum;
import com.holley.emcpshare.comenum.PayWayTypeEnum;
import com.holley.emcpshare.comenum.SendMsgTypeEnum;
import com.holley.emcpshare.common.util.JobInitBase;
import com.holley.emcpshare.dao.DatBmMapper;
import com.holley.emcpshare.dao.DatBmRealMapper;
import com.holley.emcpshare.dao.DatPowerBmMapper;
import com.holley.emcpshare.dao.DatPowerBmRealMapper;
import com.holley.emcpshare.dao.DatPowerSslMapper;
import com.holley.emcpshare.dao.DatStaPointEnergyMapper;
import com.holley.emcpshare.dao.DatStaPointUsedMapper;
import com.holley.emcpshare.dao.ObjEnterpriseMapper;
import com.holley.emcpshare.dao.ObjPointCommparamMapper;
import com.holley.emcpshare.dao.ObjPointMapper;
import com.holley.emcpshare.dao.ObjRtuMapper;
import com.holley.emcpshare.dao.ObjSleepCmdMapper;
import com.holley.emcpshare.dao.ObjSubeuuMapper;
import com.holley.emcpshare.dao.PpfControlCmdMapper;
import com.holley.emcpshare.dao.PpfCustomerAccountMapper;
import com.holley.emcpshare.dao.PpfCustomerFeeMonthDetailMapper;
import com.holley.emcpshare.dao.PpfCustomerFeeMonthDetailOtherMapper;
import com.holley.emcpshare.dao.PpfCustomerMapper;
import com.holley.emcpshare.dao.PpfPriceRuleMapper;
import com.holley.emcpshare.dao.PpfPriceRuleOtherMapper;
import com.holley.emcpshare.dao.PpfRechargeMapper;
import com.holley.emcpshare.dao.SysHostlogMapper;
import com.holley.emcpshare.dao.SysSecretKeyMapper;
import com.holley.emcpshare.dao.ViewPointMapper;
import com.holley.emcpshare.model.DatBm;
import com.holley.emcpshare.model.DatBmReal;
import com.holley.emcpshare.model.DatBmRealKey;
import com.holley.emcpshare.model.DatPowerBm;
import com.holley.emcpshare.model.DatPowerBmExample;
import com.holley.emcpshare.model.DatPowerBmKey;
import com.holley.emcpshare.model.DatPowerBmReal;
import com.holley.emcpshare.model.DatPowerBmRealExample;
import com.holley.emcpshare.model.DatPowerBmRealKey;
import com.holley.emcpshare.model.DatPowerSsl;
import com.holley.emcpshare.model.DatStaPointEnergy;
import com.holley.emcpshare.model.DatStaPointEnergyExample;
import com.holley.emcpshare.model.DatStaPointUsed;
import com.holley.emcpshare.model.DatStaPointUsedExample;
import com.holley.emcpshare.model.ObjEnterprise;
import com.holley.emcpshare.model.ObjPoint;
import com.holley.emcpshare.model.ObjPointCommparam;
import com.holley.emcpshare.model.ObjPointExample;
import com.holley.emcpshare.model.ObjRtu;
import com.holley.emcpshare.model.ObjRtuExample;
import com.holley.emcpshare.model.ObjSleepCmd;
import com.holley.emcpshare.model.ObjSleepCmdExample;
import com.holley.emcpshare.model.ObjSubeuu;
import com.holley.emcpshare.model.ObjSubeuuExample;
import com.holley.emcpshare.model.PpfControlCmd;
import com.holley.emcpshare.model.PpfCustomer;
import com.holley.emcpshare.model.PpfCustomerAccount;
import com.holley.emcpshare.model.PpfCustomerExample;
import com.holley.emcpshare.model.PpfPriceRule;
import com.holley.emcpshare.model.PpfPriceRuleExample;
import com.holley.emcpshare.model.PpfPriceRuleOther;
import com.holley.emcpshare.model.PpfPriceRuleOtherExample;
import com.holley.emcpshare.model.PpfRecharge;
import com.holley.emcpshare.model.PpfRechargeExample;
import com.holley.emcpshare.model.SysHostlog;
import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.model.SysSecretKeyExample;
import com.holley.emcpshare.model.ViewPoint;
import com.holley.emcpshare.model.ViewPointExample;
import com.holley.emcpshare.model.dcs.GWItemData;
import com.holley.emcpshare.model.dcs.PointConfGDTO;
import com.holley.emcpshare.model.dcs.PointDisconnDTO;
import com.holley.emcpshare.model.def.AccountRechargeInfo;
import com.holley.emcpshare.model.def.AccountUserInfoVO;
import com.holley.emcpshare.model.def.ExtendPowerBmEid;
import com.holley.emcpshare.model.def.GuoJiuOtherBmVO;
import com.holley.emcpshare.model.def.GuoJiuPowerBmVO;
import com.holley.emcpshare.model.def.HistoryElectricityInfo;
import com.holley.emcpshare.model.def.HongQiaoJiChangPowerZhBmVO;
import com.holley.emcpshare.model.def.PpfCustomerFeeMonthDetailOtherVO;
import com.holley.emcpshare.model.def.PpfCustomerFeeMonthDetailVO;
import com.holley.emcpshare.model.def.ViewPointVO;
import com.holley.emcpshare.service.share.CommonService;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.JsonUtil;
import com.holley.platform.common.util.NumberUtil;
import com.holley.platform.common.util.StringUtil;

/**
 * common公共对象服务
 *
 * @author sc
 */
public class CommonServiceImpl implements CommonService {

    private final static Logger                  logger = Logger.getLogger(CommonServiceImpl.class);
    @Resource
    private SysSecretKeyMapper                   sysSecretKeyMapper;
    @Resource
    private PpfCustomerAccountMapper             ppfCustomerAccountMapper;
    @Resource
    private PpfCustomerMapper                    ppfCustomerMapper;
    @Resource
    private ObjPointMapper                       objPointMapper;
    @Resource
    private ObjPointCommparamMapper              objPointCommparamMapper;
    @Resource
    private PpfCustomerFeeMonthDetailMapper      ppfCustomerFeeMonthDetailMapper;
    @Resource
    private PpfPriceRuleMapper                   ppfPriceRuleMapper;
    @Resource
    private PpfCustomerFeeMonthDetailOtherMapper ppfCustomerFeeMonthDetailOtherMapper;
    @Resource
    private PpfPriceRuleOtherMapper              ppfPriceRuleOtherMapper;
    @Resource
    private PpfRechargeMapper                    ppfRechargeMapper;
    @Resource
    private ICommForThird                        commForThird;
    @Resource
    private ObjRtuMapper                         objRtuMapper;
    @Resource
    private PpfControlCmdMapper                  ppfControlCmdMapper;
    @Resource
    private ObjSleepCmdMapper                    objSleepCmdMapper;
    @Resource
    private DatPowerBmMapper                     datPowerBmMapper;
    @Resource
    private DatPowerSslMapper                    datPowerSslMapper;
    @Resource
    private DatBmMapper                          datBmMapper;
    @Resource
    private ObjSubeuuMapper                      objSubeuuMapper;
    @Resource
    private ViewPointMapper                      viewPointMapper;
    @Resource
    private SysHostlogMapper                     sysHostlogMapper;
    @Resource
    private ObjEnterpriseMapper                  objEnterpriseMapper;
    @Resource
    private DatStaPointEnergyMapper              datStaPointEnergyMapper;
    @Resource
    private DatStaPointUsedMapper                datStaPointUsedMapper;
    @Resource
    private JobInitBase                          jobInitBase;
    @Resource
    private DatPowerBmRealMapper                 datPowerBmRealMapper;
    @Resource
    private DatBmRealMapper                      datBmRealMapper;

    @Override
    public List<SysSecretKey> selectSecretKeyByExample(SysSecretKeyExample example) {
        return sysSecretKeyMapper.selectByExample(example);
    }

    @Override
    public PpfCustomerAccount selectCustomerAccountByMap(Map<String, Object> map) {
        return ppfCustomerAccountMapper.selectCustomerAccountByMap(map);
    }

    @Override
    public int countCustomerByExample(PpfCustomerExample example) {
        return ppfCustomerMapper.countByExample(example);
    }

    @Override
    public List<ObjPoint> selectPointByExample(ObjPointExample example) {
        return objPointMapper.selectByExample(example);
    }

    @Override
    public ObjPointCommparam selectPointCommparamByPrimaryKey(Integer pointid) {
        return objPointCommparamMapper.selectByPrimaryKey(pointid);
    }

    @Override
    public List<PpfCustomerFeeMonthDetailVO> selectCustomerPowerFeeMonthByMap(Map<String, Object> map) {
        return ppfCustomerFeeMonthDetailMapper.selectCustomerPowerFeeMonthByMap(map);
    }

    @Override
    public Map<Integer, PpfPriceRule> selectPowerPriceRuleMap(PpfPriceRuleExample example) {
        Map<Integer, PpfPriceRule> map = new HashMap<Integer, PpfPriceRule>();
        List<PpfPriceRule> list = ppfPriceRuleMapper.selectByExample(example);

        if (list != null && list.size() > 0) {
            for (PpfPriceRule rule : list) {
                map.put(rule.getPriceid(), rule);
            }
        }
        return map;
    }

    @Override
    public List<PpfCustomerFeeMonthDetailOtherVO> selectCustomerWaterFeeMonthByMap(Map<String, Object> map) {
        return ppfCustomerFeeMonthDetailOtherMapper.selectCustomerWaterFeeMonthByMap(map);
    }

    @Override
    public Map<Integer, PpfPriceRuleOther> selectWaterPriceRuleMap(PpfPriceRuleOtherExample example) {
        Map<Integer, PpfPriceRuleOther> map = new HashMap<Integer, PpfPriceRuleOther>();
        List<PpfPriceRuleOther> list = ppfPriceRuleOtherMapper.selectByExample(example);

        if (list != null && list.size() > 0) {
            for (PpfPriceRuleOther rule : list) {
                map.put(rule.getPriceid(), rule);
            }
        }
        return map;
    }

    @Override
    public boolean insertRechargeAndUpdateAccount(PpfCustomer customer, String tradeNo, BigDecimal money) {
        int count = 0;
        PpfCustomerAccount account = ppfCustomerAccountMapper.selectByPrimaryKey(customer.getCustomerid());
        BigDecimal totalMoney = account.getTotalmoney();
        BigDecimal usableMoney = account.getUsablemoney();
        totalMoney = NumberUtil.formateScale2(totalMoney.add(money));
        BigDecimal usableMoneyAfter = NumberUtil.formateScale2(usableMoney.add(money));
        Date now = new Date();
        PpfCustomerAccount customerAccount = new PpfCustomerAccount();
        customerAccount.setCustomerid(customer.getCustomerid());
        customerAccount.setTotalmoney(totalMoney);
        customerAccount.setUsablemoney(usableMoneyAfter);
        customerAccount.setUpdatetime(now);
        count += ppfCustomerAccountMapper.updateByPrimaryKeySelective(customerAccount);
        // 插入充值记录
        PpfRecharge recharge = new PpfRecharge();
        recharge.setCustomerid(customer.getCustomerid());
        recharge.setPayMoney(money);
        recharge.setActualMoney(money);
        recharge.setAccount(customer.getHm());// 户名
        recharge.setAddtime(now);
        recharge.setPayway(PayWayTypeEnum.INTERFACE.getShortValue());// 接口充值
        recharge.setStatus(PayStatusEnum.SUCCESS.getShortValue());
        recharge.setTradeno(tradeNo);
        count += ppfRechargeMapper.insert(recharge);
        // 自动合闸
        if (usableMoney.doubleValue() < 0 && usableMoneyAfter.doubleValue() > 0) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("cusid", customer.getCustomerid());
            param.put("entype", EnergyTypeEnum.POWER.getValue());
            param.put("today", DateUtil.StrToDate(DateUtil.DateToNosecStr(new Date()), DateUtil.TIME_NO_SEC));
            List<ObjPoint> list = objPointMapper.selectPointsByCusId(param);
            if (!list.isEmpty()) {
                for (ObjPoint p : list) {
                    jobInitBase.executeRemoteDisConnect(p, SwitchTypeEnum.CONNECT);
                }

            }

        }
        return count == 2;
    }

    @Override
    public List<PpfCustomer> selectCustomerByExample(PpfCustomerExample example) {
        return ppfCustomerMapper.selectByExample(example);
    }

    @Override
    public int countRechargeByExample(PpfRechargeExample example) {
        return ppfRechargeMapper.countByExample(example);
    }

    @Override
    public PointDisconnDTO queryPointParam(Integer rtuid, Integer pointid) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("value", rtuid);
        param.put("pointid", pointid);
        List<PointConfGDTO> list = objPointMapper.selectByRtuidAndPointId(param);
        if (list == null || list.size() == 0) return null;
        PointConfGDTO record = list.get(0);
        PointDisconnDTO dto = new PointDisconnDTO();
        Integer comm;
        String temp;
        dto.setPointid(record.getPointid());
        dto.setDisc(record.getDisc());
        if (record.getPn() == null) {
            return null;
        }
        dto.setPn(record.getPn());
        dto.setDisconnectmode(record.getDisconnectmode());
        dto.setSafetylevel(record.getSafetylevel());
        dto.setSafetypwd(record.getSafetypwd());
        comm = record.getComm();
        if (comm == null) {
            comm = 0;
        }
        temp = Integer.toBinaryString(comm);
        temp = StringUtil.AddjustLength(temp, 8, "0");
        dto.setCommrate(Integer.parseInt(temp.substring(0, 3), 2));
        dto.setCommport(Integer.parseInt(temp.substring(3, 8), 2));

        dto.setProtocol(record.getProtocol() == null ? 0 : record.getProtocol());
        dto.setCommaddr(StringUtil.isEmpty(record.getCommaddr()) ? "000000000000" : record.getCommaddr());
        dto.setCommpwd(StringUtil.isEmpty(record.getCommpwd()) ? "000000000000" : record.getCommpwd());
        dto.setTypenum(record.getTypenum());
        return dto;

    }

    @Override
    public List<RtuCommData> setup2(List<Integer> rtuIdList, String pnStr, List<GWItemData> itemDataList, String validtime) throws XPathExpressionException,
                                                                                                                           ParserConfigurationException, IOException, SAXException,
                                                                                                                           CommunicationException {
        List<RtuCommData> resultList = new ArrayList<RtuCommData>();
        int pn = 0;
        if (StringUtil.isNotEmpty(pnStr) && StringUtil.isDigits(pnStr)) {
            pn = Integer.parseInt(pnStr);
        }
        // synchronized (this) {
        // FlexContext.getFlexSession().setAttribute(Globals.ID_CONTAINER, rtuIdList);
        // }
        Map<Integer, ObjRtu> rtuMap = getPobRtuMap(rtuIdList);
        if (rtuIdList != null && rtuIdList.size() > 0) {
            List<Map<String, String>> paraList = new LinkedList<Map<String, String>>();
            Map<String, String> para = new HashMap<String, String>();
            for (GWItemData itemData : itemDataList) {
                if (StringUtil.isNotEmpty(itemData.getData())) {
                    pn = itemData.getPn();
                    String key = ProtocolGW09.protocl.getDADTFrame(pn, itemData.getFn());
                    String value = itemData.getData();
                    if (para.containsKey(key)) {
                        Map<String, String> temppara = new HashMap<String, String>();
                        temppara.put(key, value);
                        paraList.add(temppara);
                    } else if (value.indexOf("@") >= 0) {// 分帧处理
                        String[] valueArray = value.split("@");
                        for (int j = 0; j < valueArray.length; j++) {
                            Map<String, String> temppara = new HashMap<String, String>();
                            temppara.put(key, valueArray[j]);
                            paraList.add(temppara);
                        }
                    } else {
                        para.put(key, value);
                    }
                }

            }
            // para若有参数需设置，才添加到paraList
            if (para.keySet().size() > 0) paraList.add(para);

            Integer nValidTime = null;
            if (StringUtil.isNotEmpty(validtime)) {
                nValidTime = Integer.valueOf(validtime);
            }

            DCSResult dCSResult;
            for (int i = 0; i < rtuIdList.size(); i++) {
                Integer rtuId = rtuIdList.get(i);
                ObjRtu objRtu = rtuMap.get(rtuId);
                if (objRtu == null) {
                    continue;
                }
                if (!objRtu.getProtocolid().equals(ProtocolTypeEnum.PROTOCOL_GW09.getShortValue())) {
                    continue;
                }
                byte buf[] = new byte[0];
                RtuCommData rtuCommData;
                for (int j = 0; j < paraList.size(); j++) {
                    para = paraList.get(j);
                    buf = ProtocolGW09.protocl.makeGWTransitDataFrame(para, objRtu.getCommaddr(), false, nValidTime, getRtuAuthScheme(objRtu), getRtuAuthPara(objRtu));
                    dCSResult = commForThird.readRtuData(rtuId, buf, buf.length);
                    if (dCSResult.getResult() instanceof RtuCommData) {
                        resultList.add((RtuCommData) dCSResult.getResult());
                    } else {
                        rtuCommData = new RtuCommData();
                        rtuCommData.setDataError(true);
                        resultList.add(rtuCommData);
                    }
                }
            }
        }
        return resultList;
    }

    public Map<Integer, ObjRtu> getPobRtuMap(List<Integer> rtuIdList) {
        if (rtuIdList == null || rtuIdList.size() == 0) {
            return null;
        }
        int count = rtuIdList.size();
        List<Integer> temp = new ArrayList<Integer>();
        Map<Integer, ObjRtu> map = new HashMap<Integer, ObjRtu>();
        for (int i = 0; i < count; i++) {
            temp.add(rtuIdList.get(i));
            if ((i + 1) % 200 == 0 || i == count - 1) {
                ObjRtuExample emp = new ObjRtuExample();
                emp.createCriteria().andRtuidIn(temp);
                List<com.holley.emcpshare.model.ObjRtu> list = objRtuMapper.selectByExample(emp);
                if (list != null) {
                    for (ObjRtu rtu : list) {
                        map.put(rtu.getRtuid(), rtu);
                    }
                }
                temp.clear();
            }
        }
        return map;
    }

    public int getRtuAuthScheme(ObjRtu rtu) {
        return 0;
    }

    public String getRtuAuthPara(ObjRtu rtu) {
        return null;
    }

    @Override
    public List<String> ctrl(List<Integer> rtuIdList, String pnStr, List<GWItemData> itemDataList, String pointStr, String pointTypeStr, String portStr, String commaddressStr,
                             String baud, String validtime) throws CommunicationException, XPathExpressionException, ParserConfigurationException, IOException, SAXException {

        List<String> resultList = new ArrayList<String>();

        Boolean isTransmit = false;

        int pn = 0;
        if (!StringUtil.isEmpty(pnStr) && StringUtil.isDigits(pnStr)) {
            pn = Integer.parseInt(pnStr);
        }
        Map<Integer, ObjRtu> rtuMap = getPobRtuMap(rtuIdList);
        if (rtuIdList != null && rtuIdList.size() > 0) {
            Map<String, String> para = new HashMap<String, String>();
            for (GWItemData itemData : itemDataList) {
                if (itemData != null) {
                    String data = itemData.getData();
                    String residentData = "";
                    int fn = itemData.getFn();
                    if (fn == 32) {
                        String[] dataArray = data.split(",");
                        if (dataArray.length == 2) {
                            byte[] infoArray = dataArray[1].getBytes("gb2312");
                            data = MsgUtil.getByteToHexString(infoArray, infoArray.length, "");
                            data = MsgUtil.reverse(data, data.length());
                            data += dataArray[0];
                        }

                    } else if (fn == 54 || fn == 55) {
                        Integer len = 0;
                        String lackAddress = "";
                        String commaddress = "";
                        String N1 = "";
                        String C0 = "";

                        isTransmit = true;
                        if (commaddressStr != null && commaddressStr.length() > 0) {
                            len = commaddressStr.length();
                            for (int j = len; j < 12; j++) {
                                lackAddress += "0";
                            }
                            commaddressStr = lackAddress + commaddressStr;
                            for (int k = 6; k > 0; k--) {
                                Character c1 = commaddressStr.charAt(2 * k - 2);
                                Character c2 = commaddressStr.charAt(2 * k - 1);
                                commaddress = commaddress + c1.toString() + c2.toString();
                            }
                        }
                        if (fn == 54) {
                            N1 = "4D";
                        } else if (fn == 55) {
                            N1 = "4E";
                        }
                        if (pointTypeStr.equals("0")) {
                            C0 = "33";
                        } else if (pointTypeStr.equals("1")) {
                            C0 = "34";
                        }

                        Calendar c = Calendar.getInstance();
                        c.add(Calendar.HOUR, 1);
                        SimpleDateFormat sd = new SimpleDateFormat("yyMMddHHmmss");
                        String DateStr = sd.format(c.getTime());
                        String date = "";
                        for (int i = 6; i > 0; i--) {
                            String c3 = "";
                            Integer c4 = 0;
                            Character c1 = DateStr.charAt(2 * i - 2);
                            Character c2 = DateStr.charAt(2 * i - 1);
                            c4 = (Integer.valueOf(c1.toString()) * 16 + Integer.valueOf(c2.toString()) + 51);
                            c3 = c4.toHexString(c4);
                            date = date + c3;
                        }

                        residentData += "68" + commaddress + "68" + "1C" + "1C" + "CB" + "333333" + C0 + "333333" + N1 + "33" + date + "FE";
                        Integer length = MsgUtil.StringToHex(residentData).length;
                        byte[] result = new byte[length + 2];
                        byte[] resultOld = new byte[length];
                        resultOld = MsgUtil.StringToHex(residentData);
                        byte b = MsgUtil.CheckSum(MsgUtil.StringToHex(residentData), 0, length - 1);
                        result[0] = 22;
                        result[1] = b;
                        for (int k = 0; k < length; k++) {
                            result[k + 2] = resultOld[k];
                        }
                        String resident = MsgUtil.getByteToHexString(result, length + 2, "");
                        System.out.print(b);
                        residentData = resident;

                    }
                    if (fn == 54 || fn == 55) {
                        String baudID = "";
                        if (baud.equals("0")) {
                            baudID = "0B";
                        } else if (baud.equals("1")) {
                            baudID = "2B";
                        } else if (baud.equals("2")) {
                            baudID = "4B";
                        } else if (baud.equals("3")) {
                            baudID = "6B";
                        } else if (baud.equals("4")) {
                            baudID = "8B";
                        } else if (baud.equals("5")) {
                            baudID = "AB";
                        } else if (baud.equals("6")) {
                            baudID = "CB";
                        } else if (baud.equals("7")) {
                            baudID = "EB";
                        }
                        data = residentData + "0038" + "01" + "01" + baudID + MsgUtil.getIntToHexString(Integer.valueOf(portStr));
                        para.put(ProtocolGW09.protocl.getDADTFrame(0, 1), StringUtil.isEmpty(data) ? "" : data);
                    } else {
                        para.put(ProtocolGW09.protocl.getDADTFrame(pn, fn), StringUtil.isEmpty(data) ? "" : data);
                    }

                }

            }
            Integer nValidTime = null;
            if (StringUtil.isNotEmpty(validtime)) {
                nValidTime = Integer.valueOf(validtime);
            }
            DCSResult dCSResult;
            RtuCommData rtuCommData;
            for (int i = 0; i < rtuIdList.size(); i++) {
                Integer rtuId = rtuIdList.get(i);
                ObjRtu objRtu = rtuMap.get(rtuId);
                if (objRtu == null) {
                    continue;
                }
                if (!objRtu.getProtocolid().equals(ProtocolTypeEnum.PROTOCOL_GW09.getShortValue())) {
                    continue;
                }
                byte buf[] = new byte[0];

                if (isTransmit == true) {
                    // buf = ProtocolGW09.protocl.makeGWTransitDataFrameResident(para, objRtu.getCommaddr(), false,
                    // nValidTime, getRtuAuthScheme(objRtu), getRtuAuthPara(objRtu));
                    buf = ProtocolGW09.protocl.makeGWTransitDataFrame(para, objRtu.getCommaddr(), false, nValidTime, getRtuAuthScheme(objRtu), getRtuAuthPara(objRtu));
                } else {
                    buf = ProtocolGW09.protocl.makeGWControlFrame(para, objRtu.getCommaddr(), false, nValidTime, getRtuAuthScheme(objRtu), getRtuAuthPara(objRtu), null);
                }

                dCSResult = commForThird.readRtuData(rtuId, buf, buf.length);
                if (dCSResult != null && dCSResult.getResult() instanceof RtuCommData) {
                    rtuCommData = (RtuCommData) dCSResult.getResult();
                } else {
                    rtuCommData = new RtuCommData();
                    rtuCommData.setDataError(true);
                }
                // JSONObject jsonObject = JSONObject.fromObject(rtuCommData);

                resultList.add(JSON.toJSONString(rtuCommData));

            }

        }

        return resultList;
    }

    @Override
    public void recordControlCmdLog(Integer pointid, SwitchTypeEnum switchTypeEnum) {
        PpfControlCmd controlCmd = new PpfControlCmd();
        controlCmd.setCmdtime(new Date());
        controlCmd.setCmdtype(switchTypeEnum.getShortValue());
        controlCmd.setOperatetime(new Date());
        controlCmd.setOperatetype(SendMsgTypeEnum.MANUAL.getShortValue());
        controlCmd.setParams(null);
        controlCmd.setPointid(pointid);
        controlCmd.setResult(CmdResultEnum.SUCCESS.getShortValue());
        ppfControlCmdMapper.insertSelective(controlCmd);
    }

    @Override
    public int updatePointCommParamByPKSelective(ObjPointCommparam record) {
        return objPointCommparamMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ObjPoint selectPointByMap(Map<String, Object> param) {
        return objPointMapper.selectPointByMap(param);
    }

    @Override
    public int countSleepCmdByExample(ObjSleepCmdExample example) {
        return objSleepCmdMapper.countByExample(example);
    }

    @Override
    public int insertSleepCmd(ObjSleepCmd record) {
        return objSleepCmdMapper.insert(record);
    }

    @Override
    public List<DatPowerBm> selectPowerBmByExample(DatPowerBmExample example, Integer extendEid) {
        wrapExtendEid(example, extendEid);
        return datPowerBmMapper.selectByExample(example);
    }

    @Override
    public List<DatPowerBm> selectPowerBmByDays(Map<String, Object> map, Integer extendEid) {
        wrapExtendEid(map, extendEid);
        return datPowerBmMapper.selectPowerBmByDays(map);
    }

    @Override
    public List<String> call4(List<Integer> rtuIdList, List<String> pnfnList, String validtime) throws CommunicationException {
        List<String> resultList = new ArrayList<String>();
        if (pnfnList == null || pnfnList.size() == 0) {
            return resultList;
        }
        Map<Integer, ObjRtu> rtuMap = getPobRtuMap(rtuIdList);
        List<String> itemList = new ArrayList<String>();
        Integer nValidTime = null;
        if (StringUtil.isNotEmpty(validtime)) {
            nValidTime = Integer.valueOf(validtime);
        }

        for (String pnfn : pnfnList) {
            if (StringUtil.isNotEmpty(pnfn)) {
                String[] arr = pnfn.split(",");
                if (arr.length != 2) continue;
                itemList.add(ProtocolGW09.protocl.getDADTFrame(Integer.valueOf(arr[0]), Integer.valueOf(arr[1])));
            }

        }
        DCSResult dCSResult;
        if (rtuIdList != null && rtuIdList.size() > 0) {
            for (int i = 0; i < rtuIdList.size(); i++) {
                Integer rtuId = rtuIdList.get(i);
                ObjRtu objRtu = rtuMap.get(rtuId);
                if (objRtu == null) continue;
                if (!objRtu.getProtocolid().equals(ProtocolTypeEnum.PROTOCOL_GW09.getShortValue())) {
                    continue;
                }
                byte buf[] = new byte[0];
                buf = ProtocolGW09.protocl.makeGWReadClassOneDataFrame(itemList, objRtu.getCommaddr(), false, nValidTime, getRtuAuthScheme(objRtu), getRtuAuthPara(objRtu));
                dCSResult = commForThird.readRtuData(rtuId, buf, buf.length);
                if (dCSResult != null) {
                    Object obj = dCSResult.getResult();
                    String jsonStr = JSON.toJSONString(obj);
                    resultList.add(jsonStr);
                    // JSONObject jsonObject = JSONObject.fromObject(dCSResult.getResult());
                    // resultList.add(jsonObject.toString());
                    // if (jsonObject != null) {
                    // System.out.println(jsonObject.toString());
                    // }
                }
            }
        }
        return resultList;
    }

    @Override
    public DatPowerSsl selectLastPowerSsl(Map<String, Object> map) {
        return datPowerSslMapper.selectLastPowerSsl(map);
    }

    @Override
    public DatBm selectLastWaterBm(Map<String, Object> map) {
        return datBmMapper.selectLastWaterBm(map);
    }

    @Override
    public List<ObjSubeuu> selectSubeuuByExample(ObjSubeuuExample example) {
        return objSubeuuMapper.selectByExample(example);
    }

    @Override
    public List<DatPowerBm> selectPowerBmByPointId(Map<String, Object> map, Integer extendEid) {
        wrapExtendEid(map, extendEid);
        return datPowerBmMapper.selectPowerBmByPointId(map);
    }

    @Override
    public List<ViewPoint> selectViewPointByExample(ViewPointExample example) {
        return viewPointMapper.selectByExample(example);
    }

    @Override
    public List<ViewPointVO> selectPointsByViewPoint(Map<String, Object> map) {
        return viewPointMapper.selectPointsByViewPoint(map);
    }

    @Override
    public List<DatPowerBm> selectAllPowerBmByDays(Map<String, Object> map, Integer extendEid) {
        wrapExtendEid(map, extendEid);
        return datPowerBmMapper.selectAllPowerBmByDays(map);
    }

    @Override
    public List<AccountRechargeInfo> selectRechargeByMap(Map<String, Object> map) {
        return ppfRechargeMapper.selectRechargeByMap(map);
    }

    @Override
    public void insertAccount(PpfCustomer customer, String ip) {
        // 新增; 用电用户;
        // 表名:PPF_CUSTOMER;{"phone":"18069861690","statusname":"可用","status":1,"type":1,"eid":2,"creator":"zhangteng","createtime":"2017-07-21 16:33:47","customerid":64,"typename":"个人用户","company":"","name":"xuebin.xiao","createtimestr":"2017-07-21 16:33:47","cardno":""}
        ppfCustomerMapper.insertSelective(customer);
        if (customer.getCustomerid() > 0) {
            PpfCustomerAccount account = new PpfCustomerAccount();
            account.setCustomerid(customer.getCustomerid());
            account.setFreezemoney(BigDecimal.ZERO);
            account.setFreezemoney2(BigDecimal.ZERO);
            account.setStatus((short) 1);
            account.setTotalmoney(BigDecimal.ZERO);
            account.setUsablemoney(BigDecimal.ZERO);
            account.setUpdatetime(customer.getUpdatetime());
            ppfCustomerAccountMapper.insertSelective(account);
            SysHostlog log = new SysHostlog();
            log.setAccount(customer.getCreator());
            log.setIp(ip);
            log.setLogtime(customer.getUpdatetime());
            log.setType((short) 3);
            log.setContent("新增; 用电用户;表名:PPF_CUSTOMER;" + JSONObject.fromObject(customer, JsonUtil.returnJosnConfig(false, Date.class)));
            sysHostlogMapper.insertSelective(log);
        }
    }

    @Override
    public ObjEnterprise selectEnterpriseByPrimaryKey(Integer eid) {
        return objEnterpriseMapper.selectByPrimaryKey(eid);
    }

    @Override
    public int countBCustomeryExample(PpfCustomerExample example) {
        return ppfCustomerMapper.countByExample(example);
    }

    @Override
    public void updateAccount(PpfCustomer customer, String ip, String oper) {
        int count = ppfCustomerMapper.updateByPrimaryKeySelective(customer);
        if (count > 0) {
            SysHostlog log = new SysHostlog();
            log.setAccount(oper);
            log.setIp(ip);
            log.setLogtime(customer.getUpdatetime());
            log.setType((short) 3);
            log.setContent("修改; 用电用户;表名:PPF_CUSTOMER;" + JSONObject.fromObject(customer, JsonUtil.returnJosnConfig(false, Date.class)));
            sysHostlogMapper.insertSelective(log);
        }
    }

    @Override
    public List<DatStaPointEnergy> selectDatStaPointEnergyByExample(DatStaPointEnergyExample example) {
        return datStaPointEnergyMapper.selectByExample(example);
    }

    @Override
    public List<DatStaPointUsed> selectDatStaPointUsedByExample(DatStaPointUsedExample example) {
        return datStaPointUsedMapper.selectByExample(example);
    }

    @Override
    public AccountUserInfoVO selectCustomerAccountInfoByMap(Map<String, Object> params) {
        return ppfCustomerMapper.selectCustomerAccountInfoByMap(params);
    }

    @Override
    public List<DatPowerBmReal> selectPowerBmRealByExample(DatPowerBmRealExample example) {
        return datPowerBmRealMapper.selectByExample(example);
    }

    @Override
    public DatBmReal selectBmRealByPrimaryKey(DatBmRealKey key) {
        return datBmRealMapper.selectByPrimaryKey(key);
    }

    @Override
    public SysSecretKey selectSecretKeyByPrimaryKey(String operatorid) {
        return sysSecretKeyMapper.selectByPrimaryKey(operatorid);
    }

    @Override
    public DatPowerBmReal selectPowerBmRealByPrimaryKey(DatPowerBmRealKey key) {
        return datPowerBmRealMapper.selectByPrimaryKey(key);
    }

    @Override
    public List<HistoryElectricityInfo> selectLastPowerBmBatch(Integer eid) {
        return datPowerBmRealMapper.selectLastPowerBmBatch(eid);
    }

    @Override
    public List<HongQiaoJiChangPowerZhBmVO> selectPowerZhBm(Map<String, Object> map, Integer extendEid) {
        wrapExtendEid(map, extendEid);
        return datPowerBmMapper.selectPowerZhBm(map);
    }

    @Override
    public List<GuoJiuPowerBmVO> selectGjRealPowerBm(Map<String, Object> map) {
        return datPowerBmRealMapper.selectGjRealPowerBm(map);
    }

    @Override
    public List<GuoJiuPowerBmVO> selectGjHistoryPowerBm(Map<String, Object> map, Integer extendEid) {
        wrapExtendEid(map, extendEid);
        return datPowerBmMapper.selectGjHistoryPowerBm(map);
    }

    @Override
    public List<GuoJiuOtherBmVO> selectGjRealOtherBm(Map<String, Object> map) {
        return datBmRealMapper.selectGjRealOtherBm(map);
    }

    @Override
    public List<GuoJiuOtherBmVO> selectGjHistoryOthertBm(Map<String, Object> map) {
        return datBmMapper.selectGjHistoryOthertBm(map);
    }

    private void wrapExtendEid(Map<String, Object> map, Integer extendEid) {
        if (ExtendPowerBmEid.IS_USED) {
            map.put(ExtendPowerBmEid.EXTEND_EID, extendEid);
        }
    }

    private void wrapExtendEid(DatPowerBmExample emp, Integer extendEid) {
        if (ExtendPowerBmEid.IS_USED) {
            emp.setExtendEid(extendEid);
        }
    }

    private void wrapExtendEid(DatPowerBmKey key, Integer extendEid) {
        if (ExtendPowerBmEid.IS_USED) {
            key.setExtendEid(extendEid);
        }
    }
}
