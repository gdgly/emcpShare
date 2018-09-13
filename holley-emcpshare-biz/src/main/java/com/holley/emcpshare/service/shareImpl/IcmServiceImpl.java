package com.holley.emcpshare.service.shareImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.holley.emcpshare.comenum.DataSourceTypeEnum;
import com.holley.emcpshare.comenum.ObjectTypeEnum;
import com.holley.emcpshare.comenum.OperateModeTypeEnum;
import com.holley.emcpshare.comenum.OperateStatusEnum;
import com.holley.emcpshare.dao.IcmOperateMapper;
import com.holley.emcpshare.dao.IcmParamMapper;
import com.holley.emcpshare.dao.IcmPointCustomerMapper;
import com.holley.emcpshare.dao.IcmPurchaseHisMapper;
import com.holley.emcpshare.dao.ObjEnterpriseMapper;
import com.holley.emcpshare.dao.ObjSubeuuMapper;
import com.holley.emcpshare.dao.PpfCustomerMapper;
import com.holley.emcpshare.dao.PpfPriceRuleMapper;
import com.holley.emcpshare.dao.SysAccountMapper;
import com.holley.emcpshare.dao.SysHostlogMapper;
import com.holley.emcpshare.icmenum.IcmOperateResultTypeEnum;
import com.holley.emcpshare.icmenum.IcmOperateTypeEnum;
import com.holley.emcpshare.model.IcmOperate;
import com.holley.emcpshare.model.IcmParam;
import com.holley.emcpshare.model.IcmParamExample;
import com.holley.emcpshare.model.IcmPointCustomer;
import com.holley.emcpshare.model.IcmPointCustomerExample;
import com.holley.emcpshare.model.IcmPurchaseHis;
import com.holley.emcpshare.model.IcmPurchaseHisExample;
import com.holley.emcpshare.model.ObjEnterprise;
import com.holley.emcpshare.model.ObjEnterpriseExample;
import com.holley.emcpshare.model.ObjSubeuu;
import com.holley.emcpshare.model.ObjSubeuuExample;
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
import com.holley.emcpshare.service.share.IcmService;
import com.holley.platform.common.util.DateUtil;

public class IcmServiceImpl implements IcmService {

    @Resource
    private SysAccountMapper       sysAccountMapper;
    @Resource
    private PpfCustomerMapper      ppfCustomerMapper;
    @Resource
    private ObjEnterpriseMapper    objEnterpriseMapper;
    @Resource
    private ObjSubeuuMapper        objSubeuuMapper;
    @Resource
    private SysHostlogMapper       sysHostlogMapper;
    @Resource
    private IcmParamMapper         icmParamMapper;
    @Resource
    private IcmOperateMapper       icmOperateMapper;
    @Resource
    private IcmPointCustomerMapper icmPointCustomerMapper;
    @Resource
    private IcmPurchaseHisMapper   icmPurchaseHisMapper;
    @Resource
    private PpfPriceRuleMapper     ppfPriceRuleMapper;

    @Override
    public List<SysAccount> selectSysAccountByExample(SysAccountExample example) {
        return sysAccountMapper.selectByExample(example);
    }

    @Override
    public SysAccountDetailVO selectAccountInfoByAccount(String account) {
        return sysAccountMapper.selectAccountInfoByAccount(account);
    }

    @Override
    public List<PpfCustomerVO> selectCustomerByPage(Map<String, Object> params) {
        return ppfCustomerMapper.selectCustomerByPage(params);
    }

    @Override
    public List<MeterParamVO> selectMeterByPage(Map<String, Object> params) {
        return icmParamMapper.selectMeterByPage(params);
    }

    @Override
    public PpfCustomerVO selectCustomerByCustomerNo(Map<String, Object> params) {
        return ppfCustomerMapper.selectCustomerByCustomerNo(params);
    }

    @Override
    public EnergyUnitTree loadEnergyUnitTree(Integer energyUnitId, Integer energyUnitType) {
        EnergyUnitTree energyUnitTree = new EnergyUnitTree();
        if (energyUnitType.equals(ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue())) {
            ObjEnterpriseExample example = new ObjEnterpriseExample();
            ObjEnterpriseExample.Criteria cr1 = example.createCriteria();
            cr1.andEidEqualTo(energyUnitId);
            List<ObjEnterprise> entList = objEnterpriseMapper.selectByExample(example);
            if (entList != null && entList.size() > 0) {
                for (ObjEnterprise objEnterprise : entList) {
                    energyUnitTree.children = new ArrayList<EnergyUnitTree>();
                    energyUnitTree.setId(objEnterprise.getEid());
                    energyUnitTree.setName(objEnterprise.getDisc());
                    energyUnitTree.setType(ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());
                    // 查找顶级企业下的子公司
                    List<EnergyUnitTree> entChildrenList = getEntChildren(objEnterprise.getEid());
                    if (entChildrenList != null && entChildrenList.size() > 0) {
                        energyUnitTree.children.addAll(entChildrenList);
                    }
                    // 查找顶级企业下的次级用能单位
                    List<EnergyUnitTree> euChildrenList = getEuChildren(objEnterprise.getEid(), ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());
                    if (euChildrenList != null && euChildrenList.size() > 0) {
                        energyUnitTree.children.addAll(euChildrenList);
                    }
                }
            }
        } else if (energyUnitType.equals(ObjectTypeEnum.OBJ_SUBEU.getIntValue())) {
            ObjSubeuuExample emp = new ObjSubeuuExample();
            ObjSubeuuExample.Criteria cr = emp.createCriteria();
            cr.andSubeuuidEqualTo(energyUnitId);
            List<ObjSubeuu> list = objSubeuuMapper.selectByExample(emp);
            if (list != null && list.size() > 0) {
                for (ObjSubeuu objSubeuu : list) {
                    energyUnitTree.children = new ArrayList<EnergyUnitTree>();
                    energyUnitTree.setId(objSubeuu.getSubeuuid());
                    energyUnitTree.setName(objSubeuu.getName());
                    energyUnitTree.setType(ObjectTypeEnum.OBJ_SUBEU.getIntValue());
                    // 查找次级用能单位下的次级用能单位
                    List<EnergyUnitTree> euChildrenList = getEuChildren(objSubeuu.getSubeuuid(), ObjectTypeEnum.OBJ_SUBEU.getIntValue());
                    if (euChildrenList != null && euChildrenList.size() > 0) {
                        energyUnitTree.children.addAll(euChildrenList);
                    }
                }
            }
        }
        return energyUnitTree;
    }

    /**
     * 获得企业下的企业节点
     * 
     * @param ownerid
     * @return
     */
    private List<EnergyUnitTree> getEntChildren(Integer ownerid) {
        List<EnergyUnitTree> entList = new ArrayList<EnergyUnitTree>();
        // 查询子企业
        ObjEnterpriseExample emp = new ObjEnterpriseExample();
        ObjEnterpriseExample.Criteria cr = emp.createCriteria();
        cr.andOwnertypeEqualTo(ObjectTypeEnum.OBJ_ENTERPRISE.getShortValue());
        cr.andOwneridEqualTo(ownerid);
        List<ObjEnterprise> list = objEnterpriseMapper.selectByExample(emp);
        for (ObjEnterprise objEnterprise : list) {
            EnergyUnitTree energyUnitTree = new EnergyUnitTree();
            energyUnitTree.children = new ArrayList<EnergyUnitTree>();
            energyUnitTree.setId(objEnterprise.getEid());
            energyUnitTree.setName(objEnterprise.getDisc());
            energyUnitTree.setType(ObjectTypeEnum.OBJ_ENTERPRISE.getIntValue());
            entList.add(energyUnitTree);
        }
        return entList;
    }

    /**
     * 获得企业下的次级用能单位节点
     * 
     * @param ownerid
     * @return
     */
    private List<EnergyUnitTree> getEuChildren(int ownerid, int ownerType) {
        List<EnergyUnitTree> eutList = new ArrayList<EnergyUnitTree>();
        // 查询次级用能单位
        ObjSubeuuExample emp = new ObjSubeuuExample();
        ObjSubeuuExample.Criteria cr = emp.createCriteria();
        cr.andOwnertypeEqualTo((short) ownerType);
        cr.andOwneridEqualTo(ownerid);
        List<ObjSubeuu> list = objSubeuuMapper.selectByExample(emp);
        for (ObjSubeuu objSubeuu : list) {
            EnergyUnitTree energyUnitTree = new EnergyUnitTree();
            energyUnitTree.setId(objSubeuu.getSubeuuid());
            energyUnitTree.setName(objSubeuu.getName());
            energyUnitTree.setType(ObjectTypeEnum.OBJ_SUBEU.getIntValue());
            eutList.add(energyUnitTree);
        }
        return eutList;
    }

    @Override
    public List<BuyElectricHistory> selectBuyHistoryByPage(Map<String, Object> params) {
        return icmOperateMapper.selectBuyHistoryByPage(params);
    }

    @Override
    public List<BuyMeterHistory> selectBuyPurchaseHistoryByPage(Map<String, Object> params) {
        return icmOperateMapper.selectBuyPurchaseHistoryByPage(params);
    }

    @Override
    public boolean makePresetCard(String meterNo, String presetEnergy, String alarmEnergyLimit, String account, String creditEnergyLimit, String pLimit, String meterRate,
                                  String hoardEnergyLimit) {
        int count = 0;
        Integer pointId = Integer.valueOf(meterNo);
        IcmParam record = icmParamMapper.selectByPrimaryKey(pointId);

        IcmOperate icmOperate = new IcmOperate();
        IcmParam icmParam = new IcmParam();

        icmParam.setPointId(pointId);
        icmParam.setMeterNo(meterNo);
        icmParam.setAlarmEnergyLimit(new BigDecimal(alarmEnergyLimit));
        icmParam.setCreditEnergyLimit(new BigDecimal(presetEnergy));
        icmParam.setCreditEnergyLimit(new BigDecimal(creditEnergyLimit));
        icmParam.setpLimit(new BigDecimal(pLimit));
        icmParam.setRate(new BigDecimal(meterRate));
        icmParam.setHoardEnergyLimit(new BigDecimal(hoardEnergyLimit));
        if (record != null) {
            count = count + icmParamMapper.updateByPrimaryKeySelective(icmParam);
            icmOperate.setCustomerId(record.getCustomerId());
            icmOperate.setCustomerNo(record.getCustomerNo());
        } else {
            count = count + icmParamMapper.insertSelective(icmParam);
        }

        icmOperate.setPointId(pointId);
        icmOperate.setOperateTime(new Date());
        icmOperate.setOperateType(IcmOperateTypeEnum.PRESETENERGY.getShortValue());
        icmOperate.setMeterNo(meterNo);
        icmOperate.setAlarmEnergyLimit(new BigDecimal(alarmEnergyLimit));
        icmOperate.setCreditEnergyLimit(new BigDecimal(presetEnergy));
        icmOperate.setCreditEnergyLimit(new BigDecimal(creditEnergyLimit));
        icmOperate.setpLimit(new BigDecimal(pLimit));
        icmOperate.setRate(new BigDecimal(meterRate));
        icmOperate.setHoardEnergyLimit(new BigDecimal(hoardEnergyLimit));
        icmOperate.setOperateMode(OperateModeTypeEnum.CARD.getShortValue());
        icmOperate.setAddTime(new Date());
        icmOperate.setAccount(account);
        icmOperate.setStatus(OperateStatusEnum.SUCCESS.getShortValue());
        count = count + icmOperateMapper.insertSelective(icmOperate);
        return count == 2;
    }

    @Override
    public IcmOperateResultTypeEnum openAccount(String customerId, String customer_no, String meterNo, String buyEnergy, String buyMoney, String alarmEnergyLimit, String pLimit,
                                                String buyCount, String account, String writeCardTime, String rate, String creditEnergyLimit, String hoardEnergyLimit) {
        Integer pointId = Integer.valueOf(meterNo);

        // 1) 检查该电表是否已开户，若已开户直接返回
        IcmPointCustomerExample ipcExample = new IcmPointCustomerExample();
        IcmPointCustomerExample.Criteria ipcCr = ipcExample.createCriteria();
        ipcCr.andPointIdEqualTo(pointId);
        ipcCr.andCustomerIdEqualTo(Integer.valueOf(customerId));
        List<IcmPointCustomer> ipcList = icmPointCustomerMapper.selectByExample(ipcExample);

        IcmParam record = icmParamMapper.selectByPrimaryKey(pointId);

        // icm_param
        IcmParam icmParam = new IcmParam();
        icmParam.setPointId(pointId);
        icmParam.setMeterNo(meterNo);
        icmParam.setAlarmEnergyLimit(new BigDecimal(alarmEnergyLimit));
        icmParam.setpLimit(new BigDecimal(pLimit));
        icmParam.setCustomerId(Integer.valueOf(customerId));
        icmParam.setCustomerNo(customer_no);
        icmParam.setCardCount(Integer.valueOf(buyCount));
        icmParam.setStartTime(DateUtil.LongStrToDate(writeCardTime));
        icmParam.setUpdateTime(new Date());
        icmParam.setRate(new BigDecimal(rate));
        icmParam.setCreditEnergyLimit(new BigDecimal(creditEnergyLimit));
        icmParam.setHoardEnergyLimit(new BigDecimal(hoardEnergyLimit));
        if (record != null && ipcList.size() > 0) {
            if (record.getBuyCount() > 1) {
                return IcmOperateResultTypeEnum.OPEN;
            } else {
                icmParamMapper.updateByPrimaryKeySelective(icmParam);
            }
        } else {
            icmParamMapper.insertSelective(icmParam);
        }

        // 3)保存电表与账户关系

        // icm_point_customer_his
        IcmPointCustomer icmPointCustomer = new IcmPointCustomer();
        icmPointCustomer.setPointId(pointId);
        icmPointCustomer.setCustomerId(Integer.valueOf(customerId));
        icmPointCustomer.setStartTime(DateUtil.LongStrToDate(writeCardTime));
        icmPointCustomer.setAddTime(new Date());
        icmPointCustomerMapper.insertSelective(icmPointCustomer);

        // 4)增加开户记录
        // icm_operate
        IcmOperate icmOperate = new IcmOperate();
        icmOperate.setPointId(pointId);
        icmOperate.setOperateTime(DateUtil.LongStrToDate(writeCardTime));
        icmOperate.setOperateType(IcmOperateTypeEnum.OPENACCOUNT.getShortValue());
        icmOperate.setCustomerNo(customer_no);
        icmOperate.setCustomerId(Integer.valueOf(customerId));
        icmOperate.setMeterNo(meterNo);
        icmOperate.setBuyEnergy(new BigDecimal(buyEnergy));
        icmOperate.setBuyMoney(new BigDecimal(buyMoney));
        icmOperate.setAlarmEnergyLimit(new BigDecimal(alarmEnergyLimit));
        icmOperate.setCreditEnergyLimit(new BigDecimal(creditEnergyLimit));
        icmOperate.setHoardEnergyLimit(new BigDecimal(hoardEnergyLimit));
        icmOperate.setpLimit(new BigDecimal(pLimit));
        icmOperate.setBuyCount(Integer.valueOf(buyCount));
        icmOperate.setOperateMode(OperateModeTypeEnum.CARD.getShortValue());
        icmOperate.setAddTime(new Date());
        icmOperate.setUpdateTime(new Date());
        icmOperate.setAccount(account);
        icmOperate.setRate(new BigDecimal(rate));
        icmOperate.setStatus(OperateStatusEnum.SUCCESS.getShortValue());
        if (record != null && record.getFactoryNo() != null) {
            icmOperate.setFactoryNo(record.getFactoryNo());
        }
        icmOperateMapper.insertSelective(icmOperate);

        // icm_purchase_his
        IcmPurchaseHis icmPurchaseHis = new IcmPurchaseHis();
        icmPurchaseHis.setPointId(pointId);
        icmPurchaseHis.setDataTime(DateUtil.LongStrToDate(writeCardTime));
        icmPurchaseHis.setAlarmEnergy(new BigDecimal(alarmEnergyLimit));
        icmPurchaseHis.setCreditEnergyLimit(new BigDecimal(creditEnergyLimit));
        icmPurchaseHis.setBuyCount(Integer.valueOf(buyCount));
        icmPurchaseHis.setUpdateTime(new Date());
        icmPurchaseHisMapper.insertSelective(icmPurchaseHis);

        return IcmOperateResultTypeEnum.SUCCESS;
    }

    @Override
    public boolean addPurchaseHistory(String meterNo, String totalBuyEnergy, String buyCount, String surplusEnergy, String overdrawEnergy, String writeCardTime) {
        int count = 0;
        IcmParamExample example = new IcmParamExample();
        IcmParamExample.Criteria cr = example.createCriteria();
        cr.andMeterNoEqualTo(meterNo);
        List<IcmParam> list = icmParamMapper.selectByExample(example);
        if (list == null || list.size() < 1) {
            return false;
        }
        Integer pointId = null;
        for (IcmParam icmParam : list) {
            pointId = icmParam.getPointId();
        }
        // icm_param
        IcmParam icmParam = new IcmParam();
        icmParam.setPointId(pointId);
        icmParam.setTotalBuyEnergy(new BigDecimal(totalBuyEnergy));
        icmParam.setBuyCount(Integer.valueOf(buyCount));
        icmParam.setSurplusEnergy(new BigDecimal(surplusEnergy));
        icmParam.setOverdrawEnergy(new BigDecimal(overdrawEnergy));
        icmParam.setUpdateTime(new Date());
        count = count + icmParamMapper.updateByPrimaryKeySelective(icmParam);

        // icm_purchase_his
        IcmPurchaseHisExample icmPurchaseHisExample = new IcmPurchaseHisExample();
        IcmPurchaseHisExample.Criteria ihcr = icmPurchaseHisExample.createCriteria();
        ihcr.andPointIdEqualTo(pointId);
        ihcr.andDataTimeEqualTo(DateUtil.LongStrToDate(writeCardTime));
        List<IcmPurchaseHis> iclist = icmPurchaseHisMapper.selectByExample(icmPurchaseHisExample);
        if (iclist != null && iclist.size() > 0) {
            icmPurchaseHisMapper.deleteByExample(icmPurchaseHisExample);
        }
        IcmPurchaseHis icmPurchaseHis = new IcmPurchaseHis();
        icmPurchaseHis.setPointId(pointId);
        icmPurchaseHis.setDataTime(DateUtil.LongStrToDate(writeCardTime));
        icmPurchaseHis.setBuyCount(Integer.valueOf(buyCount));
        icmPurchaseHis.setTotalBuyEnergy(new BigDecimal(totalBuyEnergy));
        icmPurchaseHis.setSurplusEnergy(new BigDecimal(surplusEnergy));
        icmPurchaseHis.setOverdrawEnergy(new BigDecimal(overdrawEnergy));
        icmPurchaseHis.setDataSource(DataSourceTypeEnum.ADDPURCHASEHISTORY.getShortValue());
        icmPurchaseHis.setUpdateTime(new Date());
        count = count + icmPurchaseHisMapper.insertSelective(icmPurchaseHis);
        return count == 2;
    }

    @Override
    public boolean buyEnergy(String meterNo, String customer_no, String buyEnergy, String buyMoney, String alarmEnergyLimit, String pLimit, String account, String writeCardTime,
                             String buyCount, String rate, String creditEnergyLimit, String hoardEnergyLimit) {
        int count = 0;
        IcmParamExample example = new IcmParamExample();
        IcmParamExample.Criteria cr = example.createCriteria();
        cr.andMeterNoEqualTo(meterNo);
        List<IcmParam> list = icmParamMapper.selectByExample(example);
        if (list == null || list.size() < 1) {
            return false;
        }
        Integer pointId = null;
        for (IcmParam icmParam : list) {
            pointId = icmParam.getPointId();
        }

        // icm_param
        IcmParam icmParam = new IcmParam();
        icmParam.setPointId(pointId);
        icmParam.setAlarmEnergyLimit(new BigDecimal(alarmEnergyLimit));
        icmParam.setpLimit(new BigDecimal(pLimit));
        icmParam.setUpdateTime(new Date());
        icmParam.setCardCount(Integer.valueOf(buyCount));
        icmParam.setRate(new BigDecimal(rate));
        icmParam.setCreditEnergyLimit(new BigDecimal(creditEnergyLimit));
        icmParam.setHoardEnergyLimit(new BigDecimal(hoardEnergyLimit));
        count = count + icmParamMapper.updateByPrimaryKeySelective(icmParam);

        // icm_operate
        IcmOperate icmOperate = new IcmOperate();
        icmOperate.setPointId(pointId);
        icmOperate.setOperateTime(DateUtil.LongStrToDate(writeCardTime));
        icmOperate.setOperateType(IcmOperateTypeEnum.BUYENERGY.getShortValue());
        icmOperate.setCustomerNo(customer_no);
        icmOperate.setCustomerId(Integer.valueOf(customer_no));
        icmOperate.setMeterNo(meterNo);
        icmOperate.setBuyEnergy(new BigDecimal(buyEnergy));
        icmOperate.setBuyMoney(new BigDecimal(buyMoney));
        icmOperate.setAlarmEnergyLimit(new BigDecimal(alarmEnergyLimit));
        icmOperate.setCreditEnergyLimit(new BigDecimal(creditEnergyLimit));
        icmOperate.setHoardEnergyLimit(new BigDecimal(hoardEnergyLimit));
        icmOperate.setpLimit(new BigDecimal(pLimit));
        icmOperate.setOperateMode(OperateModeTypeEnum.CARD.getShortValue());
        icmOperate.setAddTime(new Date());
        icmOperate.setUpdateTime(new Date());
        icmOperate.setFactoryNo(list.get(0).getFactoryNo());
        icmOperate.setAccount(account);
        icmOperate.setBuyCount(Integer.valueOf(buyCount));
        icmOperate.setRate(new BigDecimal(rate));
        icmOperate.setStatus(OperateStatusEnum.SUCCESS.getShortValue());
        count = count + icmOperateMapper.insertSelective(icmOperate);

        // icm_purchase_his
        IcmPurchaseHis icmPurchaseHis = new IcmPurchaseHis();
        icmPurchaseHis.setPointId(pointId);
        icmPurchaseHis.setDataTime(DateUtil.LongStrToDate(writeCardTime));
        icmPurchaseHis.setAlarmEnergy(new BigDecimal(alarmEnergyLimit));
        icmPurchaseHis.setBuyCount(Integer.valueOf(buyCount));
        icmPurchaseHis.setUpdateTime(new Date());
        icmPurchaseHis.setCreditEnergyLimit(new BigDecimal(creditEnergyLimit));
        count = count + icmPurchaseHisMapper.insertSelective(icmPurchaseHis);
        return count == 3;
    }

    @Override
    public MeterVO selectMeterByMeterNo(Map<String, Object> params) {
        return icmParamMapper.selectMeterByMeterNo(params);
    }

    @Override
    public boolean replaceCard(String meter_no, String customer_no, String buyEnergy, String buyMoney, String alarmEnergyLimit, String pLimit, String account, String writeCardTime,
                               String buyCount, String rate, String creditEnergyLimit, String hoardEnergyLimit) {
        boolean result = true;
        IcmParamExample example = new IcmParamExample();
        IcmParamExample.Criteria cr = example.createCriteria();
        cr.andMeterNoEqualTo(meter_no);
        List<IcmParam> list = icmParamMapper.selectByExample(example);
        if (list == null || list.size() < 1) {
            result = false;
        }
        Integer pointId = null;
        for (IcmParam icmParam : list) {
            pointId = icmParam.getPointId();
        }

        // icm_operate
        IcmOperate icmOperate = new IcmOperate();
        icmOperate.setPointId(pointId);
        icmOperate.setOperateTime(DateUtil.LongStrToDate(writeCardTime));
        icmOperate.setOperateType(IcmOperateTypeEnum.BUYENERGY.getShortValue());
        icmOperate.setCustomerNo(customer_no);
        icmOperate.setCustomerId(Integer.valueOf(customer_no));
        icmOperate.setMeterNo(meter_no);
        icmOperate.setBuyEnergy(new BigDecimal(buyEnergy));
        icmOperate.setBuyMoney(new BigDecimal(buyMoney));
        icmOperate.setAlarmEnergyLimit(new BigDecimal(alarmEnergyLimit));
        icmOperate.setCreditEnergyLimit(new BigDecimal(creditEnergyLimit));
        icmOperate.setHoardEnergyLimit(new BigDecimal(hoardEnergyLimit));
        icmOperate.setpLimit(new BigDecimal(pLimit));
        icmOperate.setOperateMode(OperateModeTypeEnum.CARD.getShortValue());
        icmOperate.setAddTime(new Date());
        icmOperate.setAccount(account);
        icmOperate.setBuyCount(Integer.valueOf(buyCount));
        icmOperate.setRate(new BigDecimal(rate));
        icmOperate.setStatus(OperateStatusEnum.SUCCESS.getShortValue());
        if (icmOperateMapper.insertSelective(icmOperate) < 1) {
            result = false;
        }
        return result;
    }

    @Override
    public PpfPriceRuleVO selectPriceByPointid(Integer pointid) {
        return ppfPriceRuleMapper.selectPriceByPointid(pointid);
    }

    @Override
    public List<IcmParam> selectIcmParamByExample(String meter_no) {
        IcmParamExample example = new IcmParamExample();
        IcmParamExample.Criteria cr = example.createCriteria();
        cr.andMeterNoEqualTo(meter_no);
        return icmParamMapper.selectByExample(example);
    }

}
