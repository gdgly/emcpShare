package com.holley.emcpshare.service.share;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.holley.emc.common.dcs.RtuCommData;
import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcp.common.exception.CommunicationException;
import com.holley.emcpshare.model.DatBm;
import com.holley.emcpshare.model.DatBmReal;
import com.holley.emcpshare.model.DatBmRealKey;
import com.holley.emcpshare.model.DatPowerBm;
import com.holley.emcpshare.model.DatPowerBmExample;
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
import com.holley.emcpshare.model.ObjSleepCmd;
import com.holley.emcpshare.model.ObjSleepCmdExample;
import com.holley.emcpshare.model.ObjSubeuu;
import com.holley.emcpshare.model.ObjSubeuuExample;
import com.holley.emcpshare.model.PpfCustomer;
import com.holley.emcpshare.model.PpfCustomerAccount;
import com.holley.emcpshare.model.PpfCustomerExample;
import com.holley.emcpshare.model.PpfPriceRule;
import com.holley.emcpshare.model.PpfPriceRuleExample;
import com.holley.emcpshare.model.PpfPriceRuleOther;
import com.holley.emcpshare.model.PpfPriceRuleOtherExample;
import com.holley.emcpshare.model.PpfRechargeExample;
import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.model.SysSecretKeyExample;
import com.holley.emcpshare.model.ViewPoint;
import com.holley.emcpshare.model.ViewPointExample;
import com.holley.emcpshare.model.dcs.GWItemData;
import com.holley.emcpshare.model.dcs.PointDisconnDTO;
import com.holley.emcpshare.model.def.AccountRechargeInfo;
import com.holley.emcpshare.model.def.AccountUserInfoVO;
import com.holley.emcpshare.model.def.GuoJiuOtherBmVO;
import com.holley.emcpshare.model.def.GuoJiuPowerBmVO;
import com.holley.emcpshare.model.def.HistoryElectricityInfo;
import com.holley.emcpshare.model.def.HongQiaoJiChangPowerZhBmVO;
import com.holley.emcpshare.model.def.PpfCustomerFeeMonthDetailOtherVO;
import com.holley.emcpshare.model.def.PpfCustomerFeeMonthDetailVO;
import com.holley.emcpshare.model.def.ViewPointVO;

/**
 * common公共对象服务
 *
 * @author sc
 */
public interface CommonService {

    /**
     * 查询企业密钥信息
     * 
     * @param example
     * @return
     */
    List<SysSecretKey> selectSecretKeyByExample(SysSecretKeyExample example);

    /**
     * 根据户号查询用户账户信息
     * 
     * @param hh
     * @return
     */
    PpfCustomerAccount selectCustomerAccountByMap(Map<String, Object> map);

    int countCustomerByExample(PpfCustomerExample example);

    List<ObjPoint> selectPointByExample(ObjPointExample example);

    ObjPointCommparam selectPointCommparamByPrimaryKey(Integer pointid);

    List<PpfCustomerFeeMonthDetailVO> selectCustomerPowerFeeMonthByMap(Map<String, Object> map);

    Map<Integer, PpfPriceRule> selectPowerPriceRuleMap(PpfPriceRuleExample example);

    List<PpfCustomerFeeMonthDetailOtherVO> selectCustomerWaterFeeMonthByMap(Map<String, Object> map);

    Map<Integer, PpfPriceRuleOther> selectWaterPriceRuleMap(PpfPriceRuleOtherExample example);

    List<PpfCustomer> selectCustomerByExample(PpfCustomerExample example);

    int countRechargeByExample(PpfRechargeExample example);

    boolean insertRechargeAndUpdateAccount(PpfCustomer customer, String tradeNo, BigDecimal money);

    PointDisconnDTO queryPointParam(Integer rtuid, Integer pointid);

    List<RtuCommData> setup2(List<Integer> rtuIdList, String pnStr, List<GWItemData> itemDataList, String validtime) throws CommunicationException, XPathExpressionException,
                                                                                                                    ParserConfigurationException, IOException, SAXException;

    List<String> ctrl(List<Integer> rtuIdList, String pnStr, List<GWItemData> itemDataList, String pointStr, String pointTypeStr, String portStr, String commaddressStr,
                      String baud, String validtime) throws CommunicationException, XPathExpressionException, ParserConfigurationException, IOException, SAXException;

    /**
     * 请求一类数据
     * 
     * @param rtuIdList
     * @param pnfnList
     * @param validtime
     * @return
     * @throws CommunicationException
     */
    public List<String> call4(List<Integer> rtuIdList, List<String> pnfnList, String validtime) throws CommunicationException;

    /**
     * 记录拉合闸日志
     * 
     * @param pointid
     * @param switchTypeEnum
     */
    void recordControlCmdLog(Integer pointid, SwitchTypeEnum switchTypeEnum);

    /**
     * 更新表状态
     * 
     * @param record
     * @return
     */
    int updatePointCommParamByPKSelective(ObjPointCommparam record);

    ObjPoint selectPointByMap(Map<String, Object> param);

    /**
     * 查询水表下发命令
     * 
     * @param example
     * @return
     */
    int countSleepCmdByExample(ObjSleepCmdExample example);

    /**
     * 插入水表下发命令
     * 
     * @param record
     * @return
     */
    int insertSleepCmd(ObjSleepCmd record);

    /**
     * 查询电表历史上报数据
     * 
     * @param example
     * @return
     */
    List<DatPowerBm> selectPowerBmByExample(DatPowerBmExample example, Integer extendEid);

    List<DatPowerBm> selectPowerBmByDays(Map<String, Object> map, Integer extendEid);

    List<DatPowerBm> selectAllPowerBmByDays(Map<String, Object> map, Integer extendEid);

    DatPowerSsl selectLastPowerSsl(Map<String, Object> map);

    DatBm selectLastWaterBm(Map<String, Object> map);

    List<ObjSubeuu> selectSubeuuByExample(ObjSubeuuExample example);

    List<DatPowerBm> selectPowerBmByPointId(Map<String, Object> map, Integer extendEid);

    List<ViewPoint> selectViewPointByExample(ViewPointExample example);

    List<ViewPointVO> selectPointsByViewPoint(Map<String, Object> map);

    List<AccountRechargeInfo> selectRechargeByMap(Map<String, Object> map);

    void insertAccount(PpfCustomer customer, String ip);

    ObjEnterprise selectEnterpriseByPrimaryKey(Integer eid);

    int countBCustomeryExample(PpfCustomerExample example);

    void updateAccount(PpfCustomer customer, String ip, String oper);

    List<DatStaPointEnergy> selectDatStaPointEnergyByExample(DatStaPointEnergyExample example);

    List<DatStaPointUsed> selectDatStaPointUsedByExample(DatStaPointUsedExample example);

    AccountUserInfoVO selectCustomerAccountInfoByMap(Map<String, Object> params);

    List<DatPowerBmReal> selectPowerBmRealByExample(DatPowerBmRealExample example);

    DatBmReal selectBmRealByPrimaryKey(DatBmRealKey key);

    SysSecretKey selectSecretKeyByPrimaryKey(String operatorid);

    DatPowerBmReal selectPowerBmRealByPrimaryKey(DatPowerBmRealKey key);

    List<HistoryElectricityInfo> selectLastPowerBmBatch(Integer eid);

    List<HongQiaoJiChangPowerZhBmVO> selectPowerZhBm(Map<String, Object> map, Integer extendEid);

    List<GuoJiuPowerBmVO> selectGjRealPowerBm(Map<String, Object> map);

    List<GuoJiuPowerBmVO> selectGjHistoryPowerBm(Map<String, Object> map, Integer extendEid);

    List<GuoJiuOtherBmVO> selectGjRealOtherBm(Map<String, Object> map);

    List<GuoJiuOtherBmVO> selectGjHistoryOthertBm(Map<String, Object> map);
}
