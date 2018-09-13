package com.holley.emcpshare.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.holley.emc.common.dcs.RtuCommData;
import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcp.common.exception.CommunicationException;
import com.holley.emcpshare.base.action.BaseAction;
import com.holley.emcpshare.comenum.CircleTypeEnum;
import com.holley.emcpshare.comenum.CustomerStatusEnum;
import com.holley.emcpshare.comenum.EnergyTypeEnum;
import com.holley.emcpshare.comenum.GuoJiuQueryTypeEnum;
import com.holley.emcpshare.comenum.HistorySearchTypeEnum;
import com.holley.emcpshare.comenum.MeterPowerStatusEnum;
import com.holley.emcpshare.comenum.ObjectTypeEnum;
import com.holley.emcpshare.comenum.PriceTypeEnum;
import com.holley.emcpshare.comenum.RetTypeEnum;
import com.holley.emcpshare.comenum.TarrifTypeEnum;
import com.holley.emcpshare.common.util.ShareGloblas;
import com.holley.emcpshare.dcs.util.DcsUtil;
import com.holley.emcpshare.dcs.util.ProtocolBaseUtil;
import com.holley.emcpshare.dcs.util.ProtocolGW09Util;
import com.holley.emcpshare.model.DatBm;
import com.holley.emcpshare.model.DatPowerBm;
import com.holley.emcpshare.model.DatPowerBmReal;
import com.holley.emcpshare.model.DatPowerBmRealExample;
import com.holley.emcpshare.model.DatPowerBmRealKey;
import com.holley.emcpshare.model.DatPowerSsl;
import com.holley.emcpshare.model.DatStaPointEnergy;
import com.holley.emcpshare.model.DatStaPointEnergyExample;
import com.holley.emcpshare.model.DatStaPointUsed;
import com.holley.emcpshare.model.DatStaPointUsedExample;
import com.holley.emcpshare.model.ObjPoint;
import com.holley.emcpshare.model.ObjSubeuu;
import com.holley.emcpshare.model.ObjSubeuuExample;
import com.holley.emcpshare.model.PpfCustomerAccount;
import com.holley.emcpshare.model.PpfPriceRule;
import com.holley.emcpshare.model.PpfPriceRuleExample;
import com.holley.emcpshare.model.PpfPriceRuleOther;
import com.holley.emcpshare.model.PpfPriceRuleOtherExample;
import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.model.dcs.DcsResultBean;
import com.holley.emcpshare.model.dcs.PackParamResultBaseBean;
import com.holley.emcpshare.model.dcs.PointDisconnDTO;
import com.holley.emcpshare.model.def.AccountInfoBase;
import com.holley.emcpshare.model.def.AccountRechargeInfo;
import com.holley.emcpshare.model.def.AccountUserInfoVO;
import com.holley.emcpshare.model.def.DayPowerOrWaterDataInfo;
import com.holley.emcpshare.model.def.ElectricityDataInfo;
import com.holley.emcpshare.model.def.ElectricityDataInfoBase;
import com.holley.emcpshare.model.def.GuoJiuOtherBmInfo;
import com.holley.emcpshare.model.def.GuoJiuOtherBmInfoBase;
import com.holley.emcpshare.model.def.GuoJiuOtherBmVO;
import com.holley.emcpshare.model.def.GuoJiuPointOtherBmInfo;
import com.holley.emcpshare.model.def.GuoJiuPointPowerBmInfo;
import com.holley.emcpshare.model.def.GuoJiuPowerBmInfo;
import com.holley.emcpshare.model.def.GuoJiuPowerBmInfoBase;
import com.holley.emcpshare.model.def.GuoJiuPowerBmVO;
import com.holley.emcpshare.model.def.HistoryAndSslElectricityDataInfo;
import com.holley.emcpshare.model.def.HistoryElectricityInfo;
import com.holley.emcpshare.model.def.HistoryWaterDataInfo;
import com.holley.emcpshare.model.def.HongQiaoJiChangPowerZhBmInfo;
import com.holley.emcpshare.model.def.HongQiaoJiChangPowerZhBmVO;
import com.holley.emcpshare.model.def.MonthlyPowerBillInfo;
import com.holley.emcpshare.model.def.MonthlyWaterBillInfo;
import com.holley.emcpshare.model.def.PpfCustomerFeeMonthDetailOtherVO;
import com.holley.emcpshare.model.def.PpfCustomerFeeMonthDetailVO;
import com.holley.emcpshare.model.def.RealElectricityInfoBase;
import com.holley.emcpshare.model.def.ShareResultBean;
import com.holley.emcpshare.model.def.ViewPointVO;
import com.holley.emcpshare.utils.PrepayUtil;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.NumberUtil;
import com.holley.platform.common.util.StringUtil;

/**
 * 业务服务接口
 * 
 * @author sc
 */
public class ShareAction extends BaseAction {

    private final static Logger logger     = Logger.getLogger(ShareAction.class);
    private ShareResultBean     resultBean = new ShareResultBean();

    // 虹桥机场接口 start
    /**
     * 获取某个时间点的组合bm数据
     * 
     * @return
     * @throws Exception
     */
    public String queryPowerZhBmInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String dataTime = getDataString(data, "dataTime");
        if (StringUtil.isEmpty(dataTime)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Date dataTimeDate = DateUtil.StrToDate(dataTime, DateUtil.TIME_LONG);
        if (dataTimeDate == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dataTime", dataTimeDate);
        map.put("eid", sk.getEid());
        List<HongQiaoJiChangPowerZhBmVO> list = commonService.selectPowerZhBm(map, sk.getEid());
        resultBean.setData(wrapQueryPowerZhBmInfo(list));
        return SUCCESS;
    }

    private List<HongQiaoJiChangPowerZhBmInfo> wrapQueryPowerZhBmInfo(List<HongQiaoJiChangPowerZhBmVO> list) {
        Map<String, HongQiaoJiChangPowerZhBmInfo> map = new HashMap<String, HongQiaoJiChangPowerZhBmInfo>();

        if (list != null && !list.isEmpty()) {
            for (HongQiaoJiChangPowerZhBmVO vo : list) {
                HongQiaoJiChangPowerZhBmInfo info = null;
                if (map.containsKey(vo.getPointId())) {
                    info = map.get(vo.getPointId());
                } else {
                    info = new HongQiaoJiChangPowerZhBmInfo();
                    info.setRtuName(vo.getRtuName());
                    info.setPointId(vo.getPointId());
                    info.setDataTime(DateUtil.DateToLongStr(vo.getDataTime()));
                    info.setPf(vo.getPf());
                    map.put(vo.getPointId(), info);
                }
                switch (vo.getTarriftypeId()) {
                    case 0:// 总
                        info.setZongZhybm(vo.getZhybm());
                        info.setZongZhwbm(vo.getZhwbm());
                        break;
                    case 1:// 尖
                        info.setJianZhybm(vo.getZhybm());
                        info.setJianZhwbm(vo.getZhwbm());
                        break;
                    case 2:// 峰
                        info.setFengZhybm(vo.getZhybm());
                        info.setFengZhwbm(vo.getZhwbm());
                        break;
                    case 3:// 平
                        info.setPingZhybm(vo.getZhybm());
                        info.setPingZhwbm(vo.getZhwbm());
                        break;
                    case 4:// 谷
                        info.setGuZhybm(vo.getZhybm());
                        info.setGuZhwbm(vo.getZhwbm());
                        break;
                    default:
                        break;
                }
            }
        }
        return new ArrayList<HongQiaoJiChangPowerZhBmInfo>(map.values());
    }

    // 虹桥机场接口end

    // 国久定制接口 start
    /**
     * 根据组织机构查询电表最新数据或历史数据
     * 
     * @return
     * @throws Exception
     */
    public String queryRealOrHistoryPowerBmInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String startTime = getDataString(data, "startTime");
        String endTime = getDataString(data, "endTime");
        String organizationCode = getDataString(data, "organizationCode");// 组织机构代码-->用能结构名称
        GuoJiuQueryTypeEnum queryType = GuoJiuQueryTypeEnum.getEnmuByValue(getDataInt(data, "type"));
        GuoJiuPowerBmInfoBase base = new GuoJiuPowerBmInfoBase();
        base.setOrganizationCode(organizationCode);
        resultBean.setData(base);
        if (StringUtil.isEmpty(organizationCode) || queryType == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        List<GuoJiuPowerBmVO> list = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("organizationCode", organizationCode);
        if (queryType == GuoJiuQueryTypeEnum.HISTORY) {
            // 获取历史数据
            if (StringUtil.isEmpty(startTime) || StringUtil.isEmpty(endTime)) {
                resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            Date startTimeDate = DateUtil.StrToDate(startTime, DateUtil.TIME_LONG);
            Date endTimeDate = DateUtil.StrToDate(endTime, DateUtil.TIME_LONG);
            if (startTimeDate == null || endTimeDate == null || startTimeDate.getTime() > endTimeDate.getTime()) {
                resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            int days = DateUtil.getIntervalDays(startTimeDate, endTimeDate);
            if (days > 30) {
                // 时间不能大于30天
                resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            map.put("startTime", startTimeDate);
            map.put("endTime", endTimeDate);
            // 历史数据
            list = commonService.selectGjHistoryPowerBm(map, sk.getEid());
        } else {
            // 最新数据
            list = commonService.selectGjRealPowerBm(map);
        }
        Map<String, GuoJiuPointPowerBmInfo> wrapData = new HashMap<String, GuoJiuPointPowerBmInfo>();
        if (list != null && !list.isEmpty()) {
            for (GuoJiuPowerBmVO vo : list) {
                GuoJiuPointPowerBmInfo temp = wrapData.get(vo.getPointId());
                GuoJiuPowerBmInfo temp2 = new GuoJiuPowerBmInfo(DateUtil.DateToLongStr(vo.getDataTime()), vo.getReadingPower(), vo.getTag());
                if (temp != null) {
                    temp.getPowerData().add(temp2);
                } else {
                    temp = new GuoJiuPointPowerBmInfo(vo.getAddress(), vo.getName(), vo.getPointId());
                    temp.getPowerData().add(temp2);
                    wrapData.put(vo.getPointId(), temp);
                }
            }
        }
        base.setData(new ArrayList<GuoJiuPointPowerBmInfo>(wrapData.values()));
        return SUCCESS;
    }

    /**
     * 根据组织机构查询水表最新数据或历史数据
     * 
     * @return
     * @throws Exception
     */
    public String queryRealOrHistoryWaterBmInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String startTime = getDataString(data, "startTime");
        String endTime = getDataString(data, "endTime");
        String organizationCode = getDataString(data, "organizationCode");// 组织机构代码
        GuoJiuQueryTypeEnum queryType = GuoJiuQueryTypeEnum.getEnmuByValue(getDataInt(data, "type"));
        GuoJiuOtherBmInfoBase base = new GuoJiuOtherBmInfoBase();
        base.setOrganizationCode(organizationCode);
        resultBean.setData(base);
        if (StringUtil.isEmpty(organizationCode) || queryType == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        List<GuoJiuOtherBmVO> list = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("organizationCode", organizationCode);
        map.put("energyType", EnergyTypeEnum.WATER.getValue());
        map.put("dataItem", 30);// 水累计量
        if (queryType == GuoJiuQueryTypeEnum.HISTORY) {
            // 获取历史数据
            if (StringUtil.isEmpty(startTime) || StringUtil.isEmpty(endTime)) {
                resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            Date startTimeDate = DateUtil.StrToDate(startTime, DateUtil.TIME_SHORT);
            Date endTimeDate = DateUtil.StrToDate(endTime, DateUtil.TIME_SHORT);
            if (startTimeDate == null || endTimeDate == null || startTimeDate.getTime() > endTimeDate.getTime()) {
                resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            int days = DateUtil.getIntervalDays(startTimeDate, endTimeDate);
            if (days > 30) {
                // 时间不能大于30天
                resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            map.put("startTime", startTimeDate);
            map.put("endTime", endTimeDate);
            // 历史数据
            list = commonService.selectGjHistoryOthertBm(map);
        } else {
            list = commonService.selectGjRealOtherBm(map);
            // 最新数据
        }
        Map<String, GuoJiuPointOtherBmInfo> wrapData = new HashMap<String, GuoJiuPointOtherBmInfo>();
        if (list != null && !list.isEmpty()) {
            for (GuoJiuOtherBmVO vo : list) {
                GuoJiuPointOtherBmInfo temp = wrapData.get(vo.getPointId());
                GuoJiuOtherBmInfo temp2 = new GuoJiuOtherBmInfo(DateUtil.DateToLongStr(vo.getDataTime()), vo.getReadingPower());
                if (temp != null) {
                    temp.getPowerData().add(temp2);
                } else {
                    temp = new GuoJiuPointOtherBmInfo(vo.getAddress(), vo.getName(), vo.getPointId());
                    temp.getPowerData().add(temp2);
                    wrapData.put(vo.getPointId(), temp);
                }
            }
        }
        base.setData(new ArrayList<GuoJiuPointOtherBmInfo>(wrapData.values()));

        return SUCCESS;
    }

    /**
     * 根据组织机构查询气表最新数据或历史数据
     * 
     * @return
     * @throws Exception
     */
    public String queryRealOrHistoryGasBmInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String startTime = getDataString(data, "startTime");
        String endTime = getDataString(data, "endTime");
        String organizationCode = getDataString(data, "organizationCode");// 组织机构代码
        GuoJiuQueryTypeEnum queryType = GuoJiuQueryTypeEnum.getEnmuByValue(getDataInt(data, "type"));
        GuoJiuOtherBmInfoBase base = new GuoJiuOtherBmInfoBase();
        base.setOrganizationCode(organizationCode);
        resultBean.setData(base);
        if (StringUtil.isEmpty(organizationCode) || queryType == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        List<GuoJiuOtherBmVO> list = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("organizationCode", organizationCode);
        map.put("energyType", EnergyTypeEnum.GAS.getValue());
        map.put("dataItem", 36);// 气累计量
        if (queryType == GuoJiuQueryTypeEnum.HISTORY) {
            // 获取历史数据
            if (StringUtil.isEmpty(startTime) || StringUtil.isEmpty(endTime)) {
                resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            Date startTimeDate = DateUtil.StrToDate(startTime, DateUtil.TIME_SHORT);
            Date endTimeDate = DateUtil.StrToDate(endTime, DateUtil.TIME_SHORT);
            if (startTimeDate == null || endTimeDate == null || startTimeDate.getTime() > endTimeDate.getTime()) {
                resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            int days = DateUtil.getIntervalDays(startTimeDate, endTimeDate);
            if (days > 30) {
                // 时间不能大于30天
                resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            map.put("startTime", startTimeDate);
            map.put("endTime", endTimeDate);
            // 历史数据
            list = commonService.selectGjHistoryOthertBm(map);
        } else {
            // 最新数据
            list = commonService.selectGjRealOtherBm(map);
        }
        Map<String, GuoJiuPointOtherBmInfo> wrapData = new HashMap<String, GuoJiuPointOtherBmInfo>();
        if (list != null && !list.isEmpty()) {
            for (GuoJiuOtherBmVO vo : list) {
                GuoJiuPointOtherBmInfo temp = wrapData.get(vo.getPointId());
                GuoJiuOtherBmInfo temp2 = new GuoJiuOtherBmInfo(DateUtil.DateToLongStr(vo.getDataTime()), vo.getReadingPower());
                if (temp != null) {
                    temp.getPowerData().add(temp2);
                } else {
                    temp = new GuoJiuPointOtherBmInfo(vo.getAddress(), vo.getName(), vo.getPointId());
                    temp.getPowerData().add(temp2);
                    wrapData.put(vo.getPointId(), temp);
                }
            }
        }
        base.setData(new ArrayList<GuoJiuPointOtherBmInfo>(wrapData.values()));

        return SUCCESS;
    }

    // 国久定制接口 end

    // OPEN1 START
    /**
     * 查询电费月账单信息
     * 
     * @return
     * @throws Exception
     */
    public String queryMonthlyPowerBillInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String hh = getDataString(data, "userId");// 用户Id
        String queryTimes = getDataString(data, "queryTimes");// 月份YYYY-MM
        if (StringUtil.isEmpty(queryTimes) || !checkUserByHH(hh, sk.getEid())) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        JSONArray jsonlist = null;
        try {
            jsonlist = JSONArray.fromObject(queryTimes);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        if (jsonlist.size() > ShareGloblas.MAX_QUERY_MONTH) {// 请求月份的长度不能超过12个月
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        List<Date> timeList = new ArrayList<Date>();
        for (int x = 0; x < jsonlist.size(); x++) {
            String time = jsonlist.getString(x);
            if (StringUtil.isNotEmpty(time)) {
                timeList.add(DateUtil.LongStrToDate(time));
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hh", hh);
        map.put("eid", sk.getEid());
        map.put("dataTimes", timeList);
        List<PpfCustomerFeeMonthDetailVO> powerMonthList = commonService.selectCustomerPowerFeeMonthByMap(map);
        resultBean.setData(wrapMonthlyPowerBillInfo(powerMonthList, sk.getEid()));
        return SUCCESS;
    }

    private List<MonthlyPowerBillInfo> wrapMonthlyPowerBillInfo(List<PpfCustomerFeeMonthDetailVO> powerMonthList, Integer eid) {
        List<MonthlyPowerBillInfo> list = new ArrayList<MonthlyPowerBillInfo>();
        PpfPriceRuleExample emp = new PpfPriceRuleExample();
        PpfPriceRuleExample.Criteria cr = emp.createCriteria();
        cr.andEidEqualTo(eid);
        Map<Integer, PpfPriceRule> ruleMap = commonService.selectPowerPriceRuleMap(emp);
        if (powerMonthList != null && powerMonthList.size() > 0) {
            for (PpfCustomerFeeMonthDetailVO feemonth : powerMonthList) {
                PpfPriceRule priceRule = ruleMap.get(feemonth.getPriceid());
                if (priceRule != null) {
                    MonthlyPowerBillInfo monthInfo = new MonthlyPowerBillInfo();
                    monthInfo.setDataTime(DateUtil.DateToYYYYMMStr(feemonth.getDatatime()));
                    monthInfo.setPointId(feemonth.getCommaddr());
                    monthInfo.setMultiplyingPower(feemonth.getRate());
                    monthInfo.setTotalPower(formateData(feemonth.getEnergyzong()));
                    monthInfo.setTotalMoney(formateData(feemonth.getFee()));

                    monthInfo.setZongStart(formateData(feemonth.getStartbmzongzy()));
                    monthInfo.setZongEnd(formateData(feemonth.getEndbmzongzy()));
                    monthInfo.setZongPower(monthInfo.getTotalPower());
                    monthInfo.setZongMoney(monthInfo.getTotalMoney());

                    if (PriceTypeEnum.RATE.getValue() == priceRule.getType().intValue()) {// 费率电价
                        monthInfo.setJianStart(formateData(feemonth.getStartbmjianzy()));
                        monthInfo.setJianEnd(formateData(feemonth.getEndbmjianzy()));
                        monthInfo.setJianPower(formateData(feemonth.getEnergyjian()));
                        monthInfo.setJianMoney(formateData(PrepayUtil.getFee(feemonth.getEnergyjian(), priceRule.getValue1(), feemonth.getPercent())));

                        monthInfo.setFengStart(formateData(feemonth.getStartbmfengzy()));
                        monthInfo.setFengEnd(formateData(feemonth.getEndbmfengzy()));
                        monthInfo.setFengPower(formateData(feemonth.getEnergyfeng()));
                        monthInfo.setFengMoney(formateData(PrepayUtil.getFee(feemonth.getEnergyfeng(), priceRule.getValue2(), feemonth.getPercent())));

                        monthInfo.setPingStart(formateData(feemonth.getStartbmpingzy()));
                        monthInfo.setPingEnd(formateData(feemonth.getEndbmpingzy()));
                        monthInfo.setPingPower(formateData(feemonth.getEnergyping()));
                        monthInfo.setPingMoney(formateData(PrepayUtil.getFee(feemonth.getEnergyping(), priceRule.getValue3(), feemonth.getPercent())));

                        monthInfo.setGuStart(formateData(feemonth.getStartbmguzy()));
                        monthInfo.setGuEnd(formateData(feemonth.getEndbmguzy()));
                        monthInfo.setGuPower(formateData(feemonth.getEnergygu()));
                        monthInfo.setGuMoney(formateData(PrepayUtil.getFee(feemonth.getEnergygu(), priceRule.getValue4(), feemonth.getPercent())));
                    }
                    list.add(monthInfo);
                }
            }
        }
        return list;
    }

    /**
     * 查询水费月账单信息
     * 
     * @return
     * @throws Exception
     */
    public String queryMonthlyWaterBillInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String hh = getDataString(data, "userId");// hh
        String queryTimes = getDataString(data, "queryTimes");// 月份YYYY-MM
        if (StringUtil.isEmpty(queryTimes) || !checkUserByHH(hh, sk.getEid())) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        JSONArray jsonlist = null;
        try {
            jsonlist = JSONArray.fromObject(queryTimes);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        if (jsonlist.size() > ShareGloblas.MAX_QUERY_MONTH) {// 请求月份的长度不能大于12个月
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        List<Date> timeList = new ArrayList<Date>();
        for (int x = 0; x < jsonlist.size(); x++) {
            String time = jsonlist.getString(x);
            if (StringUtil.isNotEmpty(time)) {
                timeList.add(DateUtil.LongStrToDate(time));
            }
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hh", hh);
        map.put("eid", sk.getEid());
        map.put("dataTimes", timeList);
        map.put("energyType", EnergyTypeEnum.WATER.getValue());
        List<PpfCustomerFeeMonthDetailOtherVO> waterMonthList = commonService.selectCustomerWaterFeeMonthByMap(map);
        resultBean.setData(wrapMonthlyWaterBillInfo(waterMonthList, sk.getEid()));
        return SUCCESS;
    }

    private List<MonthlyWaterBillInfo> wrapMonthlyWaterBillInfo(List<PpfCustomerFeeMonthDetailOtherVO> waterMonthList, Integer eid) {
        List<MonthlyWaterBillInfo> list = new ArrayList<MonthlyWaterBillInfo>();
        PpfPriceRuleOtherExample emp = new PpfPriceRuleOtherExample();
        PpfPriceRuleOtherExample.Criteria cr = emp.createCriteria();
        cr.andEidEqualTo(eid);
        cr.andEnergytypeEqualTo(EnergyTypeEnum.WATER.getShortValue());
        Map<Integer, PpfPriceRuleOther> ruleMap = commonService.selectWaterPriceRuleMap(emp);
        if (waterMonthList != null && waterMonthList.size() > 0) {
            for (PpfCustomerFeeMonthDetailOtherVO feemonth : waterMonthList) {
                PpfPriceRuleOther priceRule = ruleMap.get(feemonth.getPriceid());
                if (priceRule != null) {
                    MonthlyWaterBillInfo monthInfo = new MonthlyWaterBillInfo();
                    monthInfo.setDataTime(DateUtil.DateToYYYYMMStr(feemonth.getDatatime()));
                    monthInfo.setPointId(feemonth.getCommaddr());
                    monthInfo.setStart(formateData(feemonth.getStartbm()));
                    monthInfo.setEnd(formateData(feemonth.getEndbm()));
                    monthInfo.setMultiplyingPower(feemonth.getRate());
                    monthInfo.setTotalPower(formateData(feemonth.getUsed()));
                    monthInfo.setTotalMoney(formateData(feemonth.getFee()));
                    list.add(monthInfo);
                }
            }
        }
        return list;
    }

    private BigDecimal formateData(BigDecimal data) {
        if (data == null) {
            return BigDecimal.ZERO;
        }
        return NumberUtil.formateScale2(data);
    }

    /**
     * 查询用户账户信息
     * 
     * @return
     * @throws Exception
     */
    public String queryAccountInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String hh = getDataString(data, "userId");
        if (StringUtil.isEmpty(hh) || !checkUserByHH(hh, sk.getEid())) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hh", hh);
        map.put("eid", sk.getEid());
        map.put("status", 1);
        PpfCustomerAccount account = commonService.selectCustomerAccountByMap(map);
        if (account != null) {
            AccountInfoBase base = new AccountInfoBase();
            BeanUtils.copyProperties(base, account);
            base.setUserId(hh);
            resultBean.setData(base);
        }
        return SUCCESS;
    }

    // OPEN1 END

    // OPEN2 START 云木
    /**
     * 根据设备编码 查询单个电表实时数据 OPEN2
     * 
     * @throws Exception
     */
    public String queryRealElectricityInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String pointId = getDataString(data, "pointId");
        if (StringUtil.isEmpty(pointId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("status", 1);// 运行
        map.put("commaddr", pointId);// 具体地址
        map.put("objtype", ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());
        map.put("type", EnergyTypeEnum.POWER.getValue());// 能源类型
        ObjPoint point = commonService.selectPointByMap(map);

        if (point == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        // ObjPointCommparam commparam = commonService.selectPointCommparamByPrimaryKey(point.getPointid());
        if (localCacheUtil.getReadingObj(pointId, operatorId) != null) {
            resultBean.setRet(RetTypeEnum.SYS_BUSY.getValue());
            return SUCCESS;
        }
        PointDisconnDTO dto = commonService.queryPointParam(point.getRtuid(), point.getPointid());
        RealElectricityInfoBase realBase = new RealElectricityInfoBase();
        realBase.setPointId(pointId);
        realBase.setFrequency(wrapFrequency(point.getSampleinterval()));
        if (dto != null) {
            try {
                localCacheUtil.saveReadingObj(pointId, operatorId);
                HistoryElectricityInfo res = wrapReadPointData(point, dto);
                if (res != null) {
                    realBase.setBm(res.getBm());
                    realBase.setDataTime(res.getDataTime());
                }
                int powerStatus = returnPowerStatusResult(dto, point);
                if (MeterPowerStatusEnum.POWER_OFF.getValue() == powerStatus) {
                    realBase.setStatus(SwitchTypeEnum.DISCONNECT.getValue());
                } else if (MeterPowerStatusEnum.POWER_ON.getValue() == powerStatus) {
                    realBase.setStatus(SwitchTypeEnum.CONNECT.getValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("queryRealElectricityInfo读取电表数据失败");
            }
        }
        resultBean.setData(realBase);
        localCacheUtil.delReadingObj(pointId, operatorId);
        return SUCCESS;
    }

    /**
     * 计算上报周期单位：分钟
     * 
     * @param time
     * @return
     */
    private Integer wrapFrequency(String time) {
        Integer min = null;
        if (StringUtil.isEmpty(time)) {
            return null;
        }
        if (time.contains("DD")) {// 天
            min = NumberUtils.toInt(time.replace("DD", "")) * 24 * 60;
        } else if (time.contains("HH")) {
            min = NumberUtils.toInt(time.replace("HH", "")) * 60;
        } else if (time.contains("MI")) {
            min = NumberUtils.toInt(time.replace("MI", ""));
        }
        return min;
    }

    private HistoryElectricityInfo wrapReadPointData(ObjPoint point, PointDisconnDTO dto) throws Exception {
        List<Integer> rtuIdList = new ArrayList<Integer>();
        rtuIdList.add(point.getRtuid());
        List<String> pnfnList = new ArrayList<String>();
        pnfnList.add(dto.getPn() + "," + ShareGloblas.F129);
        List<String> rsList = commonService.call4(rtuIdList, pnfnList, null);
        logger.info("rsList:=======" + rsList);
        return returnCall4Result(rsList, dto.getPn().toString());
    }

    /**
     * 根据设备编码 查询单个电表最近一次历史记录 OPEN2
     * 
     * @throws Exception
     */
    public String queryLastHistoryElectricityInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String pointId = getDataString(data, "pointId");
        if (StringUtil.isEmpty(pointId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());// 企业id
        map.put("status", 1);// 运行
        map.put("commaddr", pointId);// 通讯地址/设备编码
        map.put("objtype", ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());
        map.put("type", EnergyTypeEnum.POWER.getValue());// 能源类型：电表
        ObjPoint point = commonService.selectPointByMap(map);
        if (point == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        DatPowerBmRealKey key = new DatPowerBmRealKey();
        key.setPhasetype((short) 0);
        key.setPointid(point.getPointid());
        key.setTarriftypeid(TarrifTypeEnum.TARRIF_ZONG.getShortValue());
        DatPowerBmReal real = commonService.selectPowerBmRealByPrimaryKey(key);

        if (real != null) {
            HistoryElectricityInfo historyElectricityInfo = new HistoryElectricityInfo();
            historyElectricityInfo.setBm(real.getZybm());
            historyElectricityInfo.setDataTime(DateUtil.DateToLongStr(real.getDatatime()));
            historyElectricityInfo.setPointId(pointId);
            resultBean.setData(historyElectricityInfo);
        }

        return SUCCESS;
    }

    /**
     * UKO新增批量获取最新数据接口
     * 
     * @return
     * @throws Exception
     */
    public String queryLastHistoryElectricityInfoBatch() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        // JSONObject data = getDecodeData(rs.getString("data"), sk);
        // String queryTime = getDataString(data, "queryTime");// yyyy-MM-dd HH:mm:ss
        // if (StringUtil.isEmpty(queryTime)) {
        // resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
        // return SUCCESS;
        // }
        List<HistoryElectricityInfo> list = commonService.selectLastPowerBmBatch(sk.getEid());
        resultBean.setData(list);
        return SUCCESS;
    }

    /**
     * 根据设备编码 查询单个电表时间段电表历史记录 OPEN2
     * 
     * @throws Exception
     */
    public String queryHistoryElectricityInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String pointId = getDataString(data, "pointId");
        String startTime = getDataString(data, "startTime");
        String endTime = getDataString(data, "endTime");
        HistorySearchTypeEnum type = HistorySearchTypeEnum.getEnmuByValue(getDataInt(data, "type"));
        if (StringUtil.isEmpty(pointId) || type == null || StringUtil.isEmpty(startTime) || StringUtil.isEmpty(endTime)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("status", 1);// 运行
        map.put("commaddr", pointId);// 通讯地址
        map.put("objtype", ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());
        map.put("type", EnergyTypeEnum.POWER.getValue());// 能源类型
        ObjPoint point = commonService.selectPointByMap(map);
        if (point == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Date startTimeDate = DateUtil.StrToDate(startTime, "yyyyMMdd");
        Date endTimeDate = DateUtil.StrToDate(endTime, "yyyyMMdd");

        int day = DateUtil.getIntervalDays(startTimeDate, endTimeDate);
        if (day > ShareGloblas.MAX_HISTORY_DAYS || (startTimeDate.getTime() > endTimeDate.getTime())) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        List<DatPowerBm> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pointId", point.getPointid());
        param.put("startTimeDate", startTimeDate);
        param.put("endTimeDate", endTimeDate);
        if (HistorySearchTypeEnum.ALL == type) {// 获取所有数据
            list = commonService.selectAllPowerBmByDays(param, sk.getEid());
        } else if (HistorySearchTypeEnum.BY_DAY == type) {// 按天获取最新数据
            list = commonService.selectPowerBmByDays(param, sk.getEid());
        }

        resultBean.setData(wrapHistoryElectricityInfo(list, pointId));
        return SUCCESS;
    }

    /**
     * 封装历史数据
     * 
     * @param list
     * @param pointId
     * @return
     */
    private List<HistoryElectricityInfo> wrapHistoryElectricityInfo(List<DatPowerBm> list, String pointId) {
        List<HistoryElectricityInfo> hisList = new ArrayList<HistoryElectricityInfo>();
        HistoryElectricityInfo info = null;
        if (list != null && list.size() > 0) {
            for (DatPowerBm bm : list) {
                info = new HistoryElectricityInfo();
                info.setPointId(pointId);
                info.setDataTime(DateUtil.DateToLongStr(bm.getDatatime()));
                info.setBm(bm.getZybm());
                hisList.add(info);
            }
        }
        return hisList;
    }

    // OPEN2 END 云木

    // OPEN3 START 贵州
    /**
     * 根据房间地址 查询电表当前数据
     * 
     * @return
     * @throws Exception
     */
    public String queryRealElectricityDataInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String address = getDataString(data, "address");
        if (StringUtil.isEmpty(address)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("status", 1);// 运行
        map.put("address", address);// 具体地址
        map.put("objtype", ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());
        map.put("type", EnergyTypeEnum.POWER.getValue());// 能源类型
        ObjPoint point = commonService.selectPointByMap(map);

        if (point == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        PointDisconnDTO dto = commonService.queryPointParam(point.getRtuid(), point.getPointid());
        ElectricityDataInfo electricityDataInfo = new ElectricityDataInfo();
        electricityDataInfo.setOperatingTime(DateUtil.DateToLongStr(new Date()));
        if (dto != null) {
            if (localCacheUtil.getReadingObj(dto.getCommaddr(), operatorId) != null) {
                resultBean.setRet(RetTypeEnum.SYS_BUSY.getValue());
                return SUCCESS;
            }
            localCacheUtil.saveReadingObj(dto.getCommaddr(), operatorId);
            String floorNo = "";
            String unitNo = "";
            String buildingNo = "";
            String communityName = "";
            ObjSubeuuExample subuuEmp = new ObjSubeuuExample();
            ObjSubeuuExample.Criteria subuuCr1 = subuuEmp.createCriteria();
            subuuCr1.andSubeuuidEqualTo(point.getOwnerid());
            List<ObjSubeuu> floor = commonService.selectSubeuuByExample(subuuEmp);
            if (floor != null && floor.size() > 0) {
                ObjSubeuu floorSub = floor.get(0);
                floorNo = floorSub.getName().replaceAll("楼", "");
                subuuEmp.clear();
                ObjSubeuuExample.Criteria subuuCr2 = subuuEmp.createCriteria();
                subuuCr2.andSubeuuidEqualTo(floorSub.getOwnerid());
                List<ObjSubeuu> unit = commonService.selectSubeuuByExample(subuuEmp);
                if (unit != null && unit.size() > 0) {
                    ObjSubeuu unitSub = unit.get(0);
                    unitNo = unitSub.getName().replaceAll("单元", "");
                    subuuEmp.clear();
                    ObjSubeuuExample.Criteria subuuCr3 = subuuEmp.createCriteria();
                    subuuCr3.andSubeuuidEqualTo(unitSub.getOwnerid());
                    List<ObjSubeuu> building = commonService.selectSubeuuByExample(subuuEmp);
                    if (building != null && building.size() > 0) {
                        ObjSubeuu buildingSub = building.get(0);
                        buildingNo = buildingSub.getName().replaceAll("幢", "");
                        subuuEmp.clear();
                        ObjSubeuuExample.Criteria subuuCr4 = subuuEmp.createCriteria();
                        subuuCr4.andSubeuuidEqualTo(buildingSub.getOwnerid());
                        List<ObjSubeuu> xq = commonService.selectSubeuuByExample(subuuEmp);
                        if (xq != null && xq.size() > 0) {
                            ObjSubeuu xqSub = xq.get(0);
                            communityName = xqSub.getName();
                        }
                    }
                }
            }
            electricityDataInfo.setAddress(address);
            electricityDataInfo.setCommunityName(communityName);
            electricityDataInfo.setBuildingNo(buildingNo);
            electricityDataInfo.setFloorNo(floorNo);
            electricityDataInfo.setUnitNo(unitNo);
            electricityDataInfo.setRoomNo(point.getName().replaceAll("室", ""));
            electricityDataInfo.setPointId(dto.getCommaddr());
            try {
                HistoryElectricityInfo res = wrapReadPointData(point, dto);
                if (res != null) {
                    electricityDataInfo.setReading(res.getBm());
                    electricityDataInfo.setMeterReadingTime(res.getDataTime());
                }
            } catch (Exception e) {
                logger.info("queryRealElectricityDataInfo读取数据失败");
                e.printStackTrace();
            }
        }
        resultBean.setData(electricityDataInfo);
        localCacheUtil.delReadingObj(dto.getCommaddr(), operatorId);
        return SUCCESS;
    }

    private HistoryElectricityInfo returnCall4Result(List<String> rsList, String pn) throws Exception {
        HistoryElectricityInfo rss = null;
        if (rsList != null && rsList.size() > 0) {
            String value = rsList.get(0);
            JSONObject jsonobj1 = JSONObject.fromObject(value);
            if (jsonobj1.getBoolean("dataError")) {
                return null;
            }
            String pnValueMap = jsonobj1.getString("pnValueMap");
            JSONObject jsonobj2 = JSONObject.fromObject(pnValueMap);
            String pnjson = jsonobj2.getString(pn);
            JSONObject jsonobj3 = JSONObject.fromObject(pnjson);
            String dataList = jsonobj3.getString("dataList");
            JSONArray dataArray = JSONArray.fromObject(dataList);
            String dataList0 = dataArray.getString(0);
            rss = DcsUtil.parse1stCatDataF129(JSONObject.fromObject(dataList0).getString("charValue"));
        }

        return rss;
    }

    private int returnPowerStatusResult(PointDisconnDTO dto, ObjPoint point) throws CommunicationException, XPathExpressionException, ParserConfigurationException, IOException,
                                                                            SAXException {
        int powerstatus = -1;
        ProtocolBaseUtil util = new ProtocolGW09Util();
        PackParamResultBaseBean rsdata = util.packParam4PointPowerStatus(dto, point.getRtuid());
        if (rsdata.isSuccess()) {
            List<RtuCommData> rslist = commonService.setup2(rsdata.getRtuIdList(), rsdata.getPnStr(), rsdata.getItemDataList(), rsdata.getValidtime());
            if (rslist != null && rslist.size() == 1) {
                RtuCommData rdata = rslist.get(0);
                if (!rdata.isDataError()) {
                    String stringValue = rdata.getPnValueMap().get(0).getDataList().get(0).getStringValue();
                    DcsResultBean dcsresult = util.parseData4PointRunStatus(dto.getProtocol(), stringValue);
                    if (dcsresult.isSuccess()) {
                        Object rssdata = dcsresult.getData();
                        if (rssdata != null && rssdata instanceof Map) {
                            Map<String, Object> dataMap = (Map<String, Object>) rssdata;
                            powerstatus = NumberUtils.toInt(dataMap.get("powerstatus").toString());
                        }
                    }
                }
            }
        }
        return powerstatus;
    }

    /**
     * 根据地址信息查询电表最新数据
     * 
     * @return
     * @throws Exception
     */
    public String queryElectricityDataListInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String name = getDataString(data, "name");// 小区名称
        String buildingNo = getDataString(data, "buildingNo");// 幢号
        String unitNo = getDataString(data, "unitNo");// 单元号
        logger.info("name:" + name);
        logger.info("buildingNo:" + buildingNo);
        logger.info("unitNo:" + unitNo);
        if (StringUtil.isEmpty(name) || StringUtil.isEmpty(buildingNo) || StringUtil.isEmpty(unitNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        ElectricityDataInfoBase baseInfo = new ElectricityDataInfoBase();
        String buildingName = buildingNo + "幢";
        String unitName = unitNo + "单元";
        ObjSubeuuExample subeuuEmp = new ObjSubeuuExample();
        ObjSubeuuExample.Criteria subeuuCr = subeuuEmp.createCriteria();
        subeuuCr.andOwneridEqualTo(sk.getEid());
        subeuuCr.andOwnertypeEqualTo(ObjectTypeEnum.OBJ_ENTERPRISE.getShortValue());
        subeuuCr.andNameEqualTo(name);
        List<ObjSubeuu> subxqList = commonService.selectSubeuuByExample(subeuuEmp);
        if (subxqList != null && subxqList.size() > 0) {
            ObjSubeuu xq = subxqList.get(0);
            subeuuEmp.clear();
            ObjSubeuuExample.Criteria subeuuCr2 = subeuuEmp.createCriteria();
            subeuuCr2.andOwneridEqualTo(xq.getSubeuuid());
            subeuuCr2.andOwnertypeEqualTo(ObjectTypeEnum.OBJ_SUBEU.getShortValue());
            subeuuCr2.andNameEqualTo(buildingName);
            List<ObjSubeuu> subBuildingList = commonService.selectSubeuuByExample(subeuuEmp);
            if (subBuildingList != null && subBuildingList.size() > 0) {
                ObjSubeuu build = subBuildingList.get(0);
                subeuuEmp.clear();
                ObjSubeuuExample.Criteria subeuuCr3 = subeuuEmp.createCriteria();
                subeuuCr3.andOwneridEqualTo(build.getSubeuuid());
                subeuuCr3.andOwnertypeEqualTo(ObjectTypeEnum.OBJ_SUBEU.getShortValue());
                subeuuCr3.andNameEqualTo(unitName);
                List<ObjSubeuu> subUnitingList = commonService.selectSubeuuByExample(subeuuEmp);
                if (subUnitingList != null && subUnitingList.size() > 0) {
                    ObjSubeuu unit = subUnitingList.get(0);
                    // ViewPointExample viewPointEmp = new ViewPointExample();
                    // ViewPointExample.Criteria viewPointCr = viewPointEmp.createCriteria();
                    // viewPointCr.andObjidEqualTo(unit.getSubeuuid());
                    // viewPointCr.andObjtypeEqualTo(ObjectTypeEnum.OBJ_SUBEU.getShortValue());
                    // List<ViewPoint> viewPointList = commonService.selectViewPointByExample(viewPointEmp);
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("uuid", unit.getSubeuuid());
                    map.put("objtype", ObjectTypeEnum.OBJ_SUBEU.getShortValue());
                    map.put("type", EnergyTypeEnum.POWER.getValue());
                    List<ViewPointVO> viewPointList = commonService.selectPointsByViewPoint(map);

                    if (viewPointList != null && viewPointList.size() > 0) {
                        Map<Integer, ViewPointVO> pointMap = returnPointList(viewPointList);
                        map.clear();
                        map.put("list", new ArrayList<Integer>(pointMap.keySet()));
                        List<DatPowerBm> powerBmList = commonService.selectPowerBmByPointId(map, sk.getEid());
                        if (powerBmList != null && powerBmList.size() > 0) {
                            baseInfo.setElectricityDataInfos(wrapElectricityDataInfo(name, buildingNo, unitNo, powerBmList, pointMap));
                        }
                    }
                }
            }
        }
        resultBean.setData(baseInfo);
        return SUCCESS;
    }

    private Map<Integer, ViewPointVO> returnPointList(List<ViewPointVO> viewPointList) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, ViewPointVO> map = new HashMap<Integer, ViewPointVO>();
        for (ViewPointVO vp : viewPointList) {
            map.put(vp.getPointid(), vp);
        }
        return map;
    }

    private List<ElectricityDataInfo> wrapElectricityDataInfo(String communityName, String buildingNo, String unitNo, List<DatPowerBm> powerBmList,
                                                              Map<Integer, ViewPointVO> pointMap) {
        List<ElectricityDataInfo> list = new ArrayList<ElectricityDataInfo>();
        ElectricityDataInfo dataInfo = null;
        String now = DateUtil.DateToLongStr(new Date());
        for (DatPowerBm powerBm : powerBmList) {
            ViewPointVO vo = pointMap.get(powerBm.getPointid());
            dataInfo = new ElectricityDataInfo();
            dataInfo.setReading(powerBm.getZybm());
            dataInfo.setCommunityName(communityName);
            dataInfo.setBuildingNo(buildingNo);
            dataInfo.setUnitNo(unitNo);
            dataInfo.setAddress(vo != null ? vo.getAddress() : "");
            dataInfo.setFloorNo(vo != null ? vo.getOwnername().replaceAll("楼", "") : "");
            dataInfo.setRoomNo(vo != null ? vo.getPointName().replaceAll("室", "") : "");
            dataInfo.setPointId(vo.getCommaddr());
            dataInfo.setMeterReadingTime(DateUtil.DateToLongStr(powerBm.getDatatime()));
            dataInfo.setOperatingTime(now);
            list.add(dataInfo);
        }
        return list;
    }

    /**
     * 查询企业所有房间最新数据取消
     * 
     * @return
     * @throws Exception
     */
    /*
     * public String queryAllElectricityDataListInfo() throws Exception { JSONObject rs = readerLine(resultBean); String
     * operatorId = resultBean.getOperatorId(); SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
     * JSONObject data = getDecodeData(rs.getString("data"), sk); Map<String, Object> map = new HashMap<String,
     * Object>(); map.put("eid", sk.getEid()); map.put("energyType", EnergyTypeEnum.POWER.getValue());
     * List<ElectricityDataInfo> list = commonService.selectPowerBmByAddr(map); ElectricityDataInfoBase dataBase = new
     * ElectricityDataInfoBase(); dataBase.setElectricityDataInfos(list);// 所有电表数据 resultBean.setData(dataBase); return
     * SUCCESS; }
     */

    // OPEN3 END 贵州
    // OPEN4 START
    /**
     * 根据设备编码查询电表最近所有数据
     * 
     * @return
     * @throws Exception
     */
    public String queryAllLastHistoryElectricityInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String pointId = getDataString(data, "pointId");
        int type = getDataInt(data, "type");
        EnergyTypeEnum entype = EnergyTypeEnum.getEnmuByValue(type);
        if (StringUtil.isEmpty(pointId) || entype == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("status", 1);// 档案运行状态
        map.put("commaddr", pointId);// 通讯地址
        map.put("objtype", ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());// 企业
        map.put("type", entype.getValue());// 能源类型：电表
        ObjPoint point = commonService.selectPointByMap(map);
        if (point == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pointId", point.getPointid());
        if (EnergyTypeEnum.POWER.getShortValue().equals(point.getEnergytypeid())) {// 电表

            DatPowerBmRealExample realBmEmp = new DatPowerBmRealExample();
            DatPowerBmRealExample.Criteria realBmCr = realBmEmp.createCriteria();
            realBmCr.andPointidEqualTo(point.getPointid());
            realBmCr.andPhasetypeEqualTo((short) 0);
            List<DatPowerBmReal> bmlist = commonService.selectPowerBmRealByExample(realBmEmp);

            DatPowerSsl datPowerSsl = commonService.selectLastPowerSsl(param);

            HistoryAndSslElectricityDataInfo historyAndSslElectricityDataInfo = new HistoryAndSslElectricityDataInfo();
            historyAndSslElectricityDataInfo.setPointId(pointId);
            if (datPowerSsl != null) {
                historyAndSslElectricityDataInfo.setP(datPowerSsl.getP());
                historyAndSslElectricityDataInfo.setQ(datPowerSsl.getQ());
                historyAndSslElectricityDataInfo.setPf(datPowerSsl.getPf());
                historyAndSslElectricityDataInfo.setIa(datPowerSsl.getIa());
                historyAndSslElectricityDataInfo.setIb(datPowerSsl.getIb());
                historyAndSslElectricityDataInfo.setIc(datPowerSsl.getIc());
                historyAndSslElectricityDataInfo.setUa(datPowerSsl.getUa());
                historyAndSslElectricityDataInfo.setUb(datPowerSsl.getUb());
                historyAndSslElectricityDataInfo.setUc(datPowerSsl.getUc());
                historyAndSslElectricityDataInfo.setSslDataTime(DateUtil.DateToLongStr(datPowerSsl.getDatatime()));
            }

            if (bmlist != null && bmlist.size() > 0) {
                for (DatPowerBmReal realBm : bmlist) {
                    if (historyAndSslElectricityDataInfo.getBmDataTime() == null) {
                        historyAndSslElectricityDataInfo.setBmDataTime(DateUtil.DateToLongStr(realBm.getDatatime()));
                    }
                    switch (realBm.getTarriftypeid()) {
                        case 0:// 总
                            if (historyAndSslElectricityDataInfo.getZongBm() == null) {
                                historyAndSslElectricityDataInfo.setZongBm(realBm.getZybm());
                            }
                            break;
                        case 1:// 尖
                            if (historyAndSslElectricityDataInfo.getJianBm() == null) {
                                historyAndSslElectricityDataInfo.setJianBm(realBm.getZybm());
                            }
                            break;
                        case 2:// 峰
                            if (historyAndSslElectricityDataInfo.getFengBm() == null) {
                                historyAndSslElectricityDataInfo.setFengBm(realBm.getZybm());
                            }
                            break;
                        case 3:// 平
                            if (historyAndSslElectricityDataInfo.getPingBm() == null) {
                                historyAndSslElectricityDataInfo.setPingBm(realBm.getZybm());
                            }
                            break;
                        case 4:// 谷
                            if (historyAndSslElectricityDataInfo.getGuBm() == null) {
                                historyAndSslElectricityDataInfo.setGuBm(realBm.getZybm());
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            resultBean.setData(historyAndSslElectricityDataInfo);
        } else if (EnergyTypeEnum.WATER.getShortValue().equals(point.getEnergytypeid())) {// 水表
            DatBm waterBm = commonService.selectLastWaterBm(param);
            if (waterBm != null) {
                HistoryWaterDataInfo historyWaterDataInfo = new HistoryWaterDataInfo();
                historyWaterDataInfo.setBm(waterBm.getBm());
                historyWaterDataInfo.setPointId(pointId);
                historyWaterDataInfo.setDataTime(DateUtil.DateToLongStr(waterBm.getDatatime()));
                resultBean.setData(historyWaterDataInfo);
            }
        }
        return SUCCESS;
    }

    // OPEN4 END
    /**
     * 查询充值记录
     * 
     * @throws Exception
     */
    public String queryAccountRechargeInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String hh = getDataString(data, "userId");// 户号
        String startTime = getDataString(data, "startTime");// 用户注册时间yyyy-MM-dd HH:mm:ss
        String endTime = getDataString(data, "endTime");// 用户名称
        if (StringUtil.isNull(hh, startTime, endTime) || !checkUserByHH(hh, sk.getEid())) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hh", hh);
        map.put("eid", sk.getEid());
        map.put("startTime", DateUtil.LongStrToDate(startTime));
        map.put("endTime", DateUtil.LongStrToDate(endTime));
        List<AccountRechargeInfo> list = commonService.selectRechargeByMap(map);
        resultBean.setData(list);
        return SUCCESS;
    }

    /**
     * 查询电表一天的用量
     * 
     * @throws Exception
     */
    public String queryDayPowerDataInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String pointId = getDataString(data, "pointId");// 表号
        String dataTime = getDataString(data, "dataTime");// yyyy-MM-dd
        Date dataDateTime = DateUtil.StrToDate(dataTime, DateUtil.TIME_SHORT);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("status", 1);// 档案运行状态
        map.put("commaddr", pointId);// 通讯地址DayPowerOrWaterDataInfo
        map.put("objtype", ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());// 企业
        map.put("type", EnergyTypeEnum.POWER.getValue());// 能源类型：电表
        ObjPoint point = commonService.selectPointByMap(map);
        if (point == null || dataDateTime == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        DayPowerOrWaterDataInfo datainfo = new DayPowerOrWaterDataInfo();
        datainfo.setDataTime(dataTime);
        datainfo.setPointId(pointId);
        Date startTime = dataDateTime;
        Date endTime = DateUtil.addDays(startTime, 1);
        DatStaPointEnergyExample emp = new DatStaPointEnergyExample();
        DatStaPointEnergyExample.Criteria cr = emp.createCriteria();
        cr.andPointidEqualTo(point.getPointid());
        cr.andTarriftypeidEqualTo(TarrifTypeEnum.TARRIF_ZONG.getShortValue());
        cr.andCircletypeidEqualTo(CircleTypeEnum.DAY.getShortValue());
        cr.andDatatimeGreaterThanOrEqualTo(startTime);
        cr.andDatatimeLessThan(endTime);
        datainfo.setData(wrapPowerData(commonService.selectDatStaPointEnergyByExample(emp)));
        resultBean.setData(datainfo);
        return SUCCESS;
    }

    /**
     * 义乌商贸城
     * 
     * @return
     * @throws Exception
     */
    public String queryUseraccountInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String hh = getDataString(data, "userId");
        if (StringUtil.isEmpty(hh) || !checkUserByHH(hh, sk.getEid())) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hh", hh);
        map.put("eid", sk.getEid());
        map.put("status", CustomerStatusEnum.RUNING.getValue());
        AccountUserInfoVO accountuser = commonService.selectCustomerAccountInfoByMap(map);
        resultBean.setData(accountuser);
        return SUCCESS;
    }

    private BigDecimal wrapPowerData(List<DatStaPointEnergy> list) {
        BigDecimal rs = null;
        if (list != null && list.size() > 0) {
            DatStaPointEnergy power = list.get(0);
            rs = power.getEnergyZy() != null ? power.getEnergyZy() : BigDecimal.ZERO;
        }
        return rs;
    }

    /**
     * 查询水表一天的用量
     * 
     * @throws Exception
     */
    public String queryDayWaterDataInfo() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String pointId = getDataString(data, "pointId");// 表号
        String dataTime = getDataString(data, "dataTime");// yyyy-MM-dd
        Date dataDateTime = DateUtil.StrToDate(dataTime, DateUtil.TIME_SHORT);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", sk.getEid());
        map.put("status", 1);// 档案运行状态
        map.put("commaddr", pointId);// 通讯地址DayPowerOrWaterDataInfo
        map.put("objtype", ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());// 企业
        map.put("type", EnergyTypeEnum.WATER.getValue());// 能源类型：电表
        ObjPoint point = commonService.selectPointByMap(map);
        if (point == null || dataDateTime == null) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        DayPowerOrWaterDataInfo datainfo = new DayPowerOrWaterDataInfo();
        datainfo.setDataTime(dataTime);
        datainfo.setPointId(pointId);
        Date startTime = dataDateTime;
        Date endTime = DateUtil.addDays(startTime, 1);
        DatStaPointUsedExample emp = new DatStaPointUsedExample();
        DatStaPointUsedExample.Criteria cr = emp.createCriteria();
        cr.andPointidEqualTo(point.getPointid());
        cr.andDatatimeGreaterThanOrEqualTo(startTime);
        cr.andDatatimeLessThan(endTime);
        cr.andCircletypeidEqualTo(CircleTypeEnum.DAY.getShortValue());
        datainfo.setData(wrapWaterData(commonService.selectDatStaPointUsedByExample(emp)));
        resultBean.setData(datainfo);
        return SUCCESS;
    }

    private BigDecimal wrapWaterData(List<DatStaPointUsed> list) {
        BigDecimal rs = null;
        if (list != null && list.size() > 0) {
            DatStaPointUsed used = list.get(0);
            rs = used.getUsed() != null ? used.getUsed() : BigDecimal.ZERO;
        }
        return rs;
    }

    // GET SET
    public ShareResultBean getResultBean() {
        return resultBean;
    }

}
