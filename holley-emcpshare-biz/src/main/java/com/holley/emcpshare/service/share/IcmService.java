package com.holley.emcpshare.service.share;

import java.util.List;
import java.util.Map;

import com.holley.emcpshare.icmenum.IcmOperateResultTypeEnum;
import com.holley.emcpshare.model.IcmParam;
import com.holley.emcpshare.model.SysAccount;
import com.holley.emcpshare.model.SysAccountExample;
import com.holley.emcpshare.model.common.SysAccountDetailVO;
import com.holley.emcpshare.model.icm.BuyElectricHistory;
import com.holley.emcpshare.model.icm.BuyMeterHistory;
import com.holley.emcpshare.model.icm.EnergyUnitTree;
import com.holley.emcpshare.model.icm.MeterParamVO;
import com.holley.emcpshare.model.icm.MeterVO;
import com.holley.emcpshare.model.icm.PpfCustomerVO;
import com.holley.emcpshare.model.icm.PpfPriceRuleVO;

public interface IcmService {

    List<SysAccount> selectSysAccountByExample(SysAccountExample example);

    SysAccountDetailVO selectAccountInfoByAccount(String account);

    List<PpfCustomerVO> selectCustomerByPage(Map<String, Object> params);

    List<MeterParamVO> selectMeterByPage(Map<String, Object> params);

    PpfCustomerVO selectCustomerByCustomerNo(Map<String, Object> params);

    EnergyUnitTree loadEnergyUnitTree(Integer energyUnitId, Integer energyUnitType);

    List<BuyElectricHistory> selectBuyHistoryByPage(Map<String, Object> params);

    List<BuyMeterHistory> selectBuyPurchaseHistoryByPage(Map<String, Object> params);

    boolean makePresetCard(String meterNo, String presetEnergy, String alarmEnergyLimit, String account, String creditEnergyLimit, String pLimit, String meterRate,
                           String hoardEnergyLimit);

    IcmOperateResultTypeEnum openAccount(String customerId, String customer_no, String meterNo, String buyEnergy, String buyMoney, String alarmEnergyLimit, String pLimit,
                                         String buyCount, String account, String writeCardTime, String rate, String creditEnergyLimit, String hoardEnergyLimit);

    boolean addPurchaseHistory(String meterNo, String totalBuyEnergy, String buyCount, String surplusEnergy, String overdrawEnergy, String writeCardTime);

    boolean buyEnergy(String meterNo, String customer_no, String buyEnergy, String buyMoney, String alarmEnergyLimit, String pLimit, String account, String writeCardTime,
                      String buyCount, String rate, String creditEnergyLimit, String hoardEnergyLimit);

    MeterVO selectMeterByMeterNo(Map<String, Object> params);

    boolean replaceCard(String meter_no, String customer_no, String buyEnergy, String buyMoney, String alarmEnergyLimit, String pLimit, String account, String writeCardTime,
                        String buyCount, String rate, String creditEnergyLimit, String hoardEnergyLimit);

    PpfPriceRuleVO selectPriceByPointid(Integer pointid);

    List<IcmParam> selectIcmParamByExample(String meter_no);

}
