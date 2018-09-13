package com.holley.emcpshare.service.shareImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.holley.emcp.common.constants.ppf.FeeChangeTypeEnum;
import com.holley.emcpshare.comenum.EnergyTypeEnum;
import com.holley.emcpshare.common.util.ShareUtil;
import com.holley.emcpshare.dao.PpfBillPushReturnMapper;
import com.holley.emcpshare.dao.PpfBillResultMapper;
import com.holley.emcpshare.dao.PpfCustomerAccountMapper;
import com.holley.emcpshare.dao.PpfCustomerFeeChangeMapper;
import com.holley.emcpshare.dao.PpfCustomerFeeMonthOtherMapper;
import com.holley.emcpshare.dao.PpfCustomerMapper;
import com.holley.emcpshare.dao.PpfSurchargeMapper;
import com.holley.emcpshare.model.PpfBillPushReturn;
import com.holley.emcpshare.model.PpfCustomer;
import com.holley.emcpshare.model.PpfCustomerExample;
import com.holley.emcpshare.model.PpfCustomerFeeChange;
import com.holley.emcpshare.model.PpfCustomerFeeChangeExample;
import com.holley.emcpshare.model.PpfCustomerFeeMonthOther;
import com.holley.emcpshare.model.PpfCustomerFeeMonthOtherExample;
import com.holley.emcpshare.model.PpfSurcharge;
import com.holley.emcpshare.model.PpfSurchargeExample;
import com.holley.emcpshare.model.PpfSurchargeKey;
import com.holley.emcpshare.model.bank.BankBill;
import com.holley.emcpshare.model.bank.BankContractRs;
import com.holley.emcpshare.model.bank.BankSurchargeVo;
import com.holley.emcpshare.model.bank.SurchargeConfig;
import com.holley.emcpshare.service.share.BankService;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.NumberUtil;

public class BankServiceImpl implements BankService {

    private final static Logger            logger = Logger.getLogger(BankServiceImpl.class);
    @Resource
    private PpfCustomerFeeMonthOtherMapper ppfCustomerFeeMonthOtherMapper;
    @Resource
    private PpfCustomerFeeChangeMapper     ppfCustomerFeeChangeMapper;
    @Resource
    private PpfBillPushReturnMapper        ppfBillPushReturnMapper;
    @Resource
    private PpfBillResultMapper            ppfBillResultMapper;
    @Resource
    private PpfSurchargeMapper             ppfSurchargeMapper;
    @Resource
    private PpfCustomerMapper              ppfCustomerMapper;
    @Resource
    private PpfCustomerAccountMapper       ppfCustomerAccountMapper;

    @Override
    public List<BankBill> queryBankBills(Map<String, Object> param) {
        return ppfCustomerFeeMonthOtherMapper.queryBankBills(param);
    }

    @Override
    public int countCustomerFeeChangeByExample(PpfCustomerFeeChangeExample example) {
        return ppfCustomerFeeChangeMapper.countByExample(example);
    }

    @Override
    public List<PpfCustomerFeeChange> selectCustomerFeeChangeByExample(PpfCustomerFeeChangeExample example) {
        return ppfCustomerFeeChangeMapper.selectByExample(example);
    }

    @Override
    public int insertAndUpdateBillPush(PpfBillPushReturn record, List<BankBill> bankBillList) {
        // 插入日志记录
        int count = ppfBillPushReturnMapper.insert(record);
        if (bankBillList != null && !bankBillList.isEmpty()) {
            List<BankBill> firstBankBillList = returnFirstBankBill(bankBillList);
            if (!firstBankBillList.isEmpty()) {
                // 初始化插入ppf_bill_result
                count += ppfBillResultMapper.insertByBatch(firstBankBillList);
            }

            count += ppfCustomerFeeMonthOtherMapper.updateUncutCustomerFeeMonthOtherByBatch(bankBillList);
            //
            // List<Integer> customerIds = returnCustomerIdsByBill(bankBillList);
            // List<Date> dataTimes = returnDataTimes(bankBillList);
            //
            // PpfCustomerFeeMonthOther customerFeeMonthOther = new PpfCustomerFeeMonthOther();
            // customerFeeMonthOther.setCutstatus(FeeCutStatusEnum.UNCUT.getShortValue());
            //
            // PpfCustomerFeeMonthOtherExample customerFeeMonthOtherEmp = new PpfCustomerFeeMonthOtherExample();
            // PpfCustomerFeeMonthOtherExample.Criteria customerFeeMonthOtherCr =
            // customerFeeMonthOtherEmp.createCriteria();
            // customerFeeMonthOtherCr.andCustomeridIn(customerIds);
            // customerFeeMonthOtherCr.andDatatimeIn(dataTimes);
            // customerFeeMonthOtherCr.andEnergytypeEqualTo(EnergyTypeEnum.WATER.getShortValue());
            // count += ppfCustomerFeeMonthOtherMapper.updateByExampleSelective(customerFeeMonthOther,
            // customerFeeMonthOtherEmp);
        }
        return count;
    }

    @Override
    public void updateBankReturnBills(List<BankBill> allBankReturnList, List<BankBill> successBankReturnList, List<BankBill> unSuccessBankReturnList, Integer eid) {
        // 更新ppfBillResult表
        if (!allBankReturnList.isEmpty()) {
            ppfBillResultMapper.updateByBatch(allBankReturnList);
        }
        // 处理扣款成功的账单
        if (!successBankReturnList.isEmpty()) {
            ppfCustomerFeeMonthOtherMapper.updateSuccessCustomerFeeMonthOtherByBatch(successBankReturnList);
            // 平账户（更新账户信息）
            ppfCustomerAccountMapper.updateCustomerAccountByBatch(successBankReturnList);
        }
        // 处理扣款失败的账单
        if (!unSuccessBankReturnList.isEmpty()) {
            ppfCustomerFeeMonthOtherMapper.updateUnSuccessCustomerFeeMonthOtherByBatch(unSuccessBankReturnList);
        }

    }

    private List<Integer> returnCustomerIdsByCustomer(List<PpfCustomer> list) {
        List<Integer> customerIds = new ArrayList<Integer>(list.size());
        for (PpfCustomer customer : list) {
            customerIds.add(customer.getCustomerid());
        }
        return customerIds;
    }

    private List<Integer> returnCustomerIdsByBill(List<BankBill> list) {
        List<Integer> customerIds = new ArrayList<Integer>(list.size());
        for (BankBill bill : list) {
            customerIds.add(bill.getCustomerId());
        }
        return customerIds;
    }

    private List<Date> returnDataTimes(List<BankBill> list) {
        Set<Date> dataTimes = new HashSet<Date>();
        for (BankBill bill : list) {
            dataTimes.add(bill.getDataTime());
        }
        return new ArrayList<Date>(dataTimes);
    }

    private List<BankBill> returnFirstBankBill(List<BankBill> list) {
        List<BankBill> firstBills = new ArrayList<BankBill>();
        for (BankBill bill : list) {
            if (bill.getCutstatus() == null) {
                firstBills.add(bill);
            }
        }
        return firstBills;
    }

    private List<String> returHhs(List<BankBill> list) {
        Set<String> hhs = new HashSet<String>();
        for (BankBill bill : list) {
            hhs.add(bill.getHh());
        }
        return new ArrayList<String>(hhs);
    }

    private List<Integer> returnCustomerIds(List<BankBill> list) {
        Set<Integer> customerIds = new HashSet<Integer>();
        for (BankBill bill : list) {
            customerIds.add(bill.getCustomerId());
        }
        return new ArrayList<Integer>(customerIds);
    }

    @Override
    public int insertBillResultByBatch(List<BankBill> list) {
        return ppfBillResultMapper.insertByBatch(list);
    }

    @Override
    public List<PpfCustomer> selectCustomerByExample(PpfCustomerExample example) {
        return ppfCustomerMapper.selectByExample(example);
    }

    @Override
    public BankContractRs selectBankContract(Map<String, Object> params) {
        return ppfCustomerMapper.selectBankContract(params);
    }

    @Override
    public int updateCustomerByExampleSelective(PpfCustomer record, PpfCustomerExample example) {
        return ppfCustomerMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<BankSurchargeVo> selectCustomerFeeMonthOther(Map<String, Object> params) {
        return ppfCustomerFeeMonthOtherMapper.selectCustomerFeeMonthOther(params);
    }

    @Override
    public void updateAndInsertSurcharge(List<BankSurchargeVo> list) {
        /*
         * List<BankSurchargeVo> surchargeList = new ArrayList<BankSurchargeVo>(); for (BankSurchargeVo surcharge :
         * list) { List<String> monthList = DateUtil.getMonthBetween(surcharge.getAddTime(), surcharge.getUpdateTime(),
         * DateUtil.YEARMONTH); int mongthSize = monthList.size() - 1; if (surcharge.getCutCount() >=
         * SurchargeConfig.cutCount && mongthSize >= SurchargeConfig.delayMonth) { surchargeList.add(surcharge); } }
         */
        logger.info("滞纳金任务数:" + list.size());
        if (!list.isEmpty()) {
            BigDecimal rate = new BigDecimal(SurchargeConfig.rate);
            PpfSurchargeExample surchargeEmp = new PpfSurchargeExample();
            PpfSurchargeExample.Criteria surchargeCr = null;
            Date updateTime = new Date();
            BigDecimal calcFee = null;
            BigDecimal allSurchargerate = null;
            Date endTime = null;
            int countDay = 0;
            for (BankSurchargeVo vo : list) {
                PpfSurcharge newSurcharge = new PpfSurcharge();
                PpfSurchargeKey key = new PpfSurchargeKey();
                key.setCustomerId(vo.getCustomerId());
                key.setDataTime(vo.getDataTime());
                key.setEnergyType(vo.getEnergyType());
                PpfSurcharge surcharge = ppfSurchargeMapper.selectByPrimaryKey(key);
                if (surcharge != null) {
                    calcFee = surcharge.getFee();
                    Date oldDate = DateUtil.StrToDate(DateUtil.DateToYYYYMMStr(surcharge.getUpdateTime()), DateUtil.MONTHTIME);
                    Date newDate = DateUtil.StrToDate(DateUtil.DateToYYYYMMStr(updateTime), DateUtil.MONTHTIME);
                    if (oldDate.getTime() < newDate.getTime()) {
                        endTime = ShareUtil.getNextMonth(surcharge.getEndTime());
                        countDay = DateUtil.getIntervalDays(surcharge.getEndTime(), endTime);
                        allSurchargerate = ShareUtil.getMulMoney(ShareUtil.getMulMoney(rate, calcFee), new BigDecimal(countDay + "")).setScale(2, BigDecimal.ROUND_DOWN);
                        short calcCount = surcharge.getCalcCount();
                        calcCount++;
                        newSurcharge.setCalcCount(calcCount);
                        newSurcharge.setUpdateTime(updateTime);
                        newSurcharge.setEndTime(endTime);
                        newSurcharge.setMoney(ShareUtil.getAddMoney(surcharge.getMoney(), allSurchargerate).setScale(2, BigDecimal.ROUND_DOWN));
                        surchargeEmp.clear();
                        surchargeCr = surchargeEmp.createCriteria();
                        surchargeCr.andDataTimeEqualTo(surcharge.getDataTime());
                        surchargeCr.andCustomerIdEqualTo(surcharge.getCustomerId());
                        surchargeCr.andEnergyTypeEqualTo(surcharge.getEnergyType());
                        ppfSurchargeMapper.updateByExampleSelective(newSurcharge, surchargeEmp);
                        logger.info("【滞纳金账单信息】：用户ID >>" + vo.getCustomerId() + " 账单时间 >>" + DateUtil.DateToYYYYMMStr(vo.getDataTime()) + " 计算本金 >>" + calcFee + " 计算月份 >>"
                                    + DateUtil.DateToYYYYMMStr(surcharge.getEndTime()) + " 计算天数 >>" + countDay + " 滞纳金 >>" + allSurchargerate + " 计算利率 >>" + rate);
                    }
                } else {
                    calcFee = vo.getFee();
                    PpfCustomerFeeChangeExample feeChangeEmp = new PpfCustomerFeeChangeExample();
                    PpfCustomerFeeChangeExample.Criteria feeChangeCr = feeChangeEmp.createCriteria();
                    feeChangeCr.andCustomeridEqualTo(vo.getCustomerId());
                    feeChangeCr.andDatatimeEqualTo(vo.getDataTime());
                    feeChangeCr.andEnergytypeEqualTo(EnergyTypeEnum.WATER.getShortValue());
                    List<PpfCustomerFeeChange> feeChangeList = ppfCustomerFeeChangeMapper.selectByExample(feeChangeEmp);
                    if (feeChangeList != null && !feeChangeList.isEmpty()) {
                        BigDecimal tempFee = vo.getFee();
                        for (PpfCustomerFeeChange feeChange : feeChangeList) {
                            if (feeChange.getType().equals(FeeChangeTypeEnum.ADD_FEE.getShortValue())) {
                                // 追费
                                tempFee = NumberUtil.add(tempFee, feeChange.getMoney());
                            } else if (feeChange.getType().equals(FeeChangeTypeEnum.SUBTRACT_FEE.getShortValue())) {
                                // 退费
                                tempFee = NumberUtil.sub(tempFee, feeChange.getMoney());
                            }
                        }
                        calcFee = tempFee;
                    }
                    Date startTime = DateUtil.getFirstDayOfMonth(vo.getAddTime());
                    endTime = ShareUtil.getNextMonth(startTime);
                    countDay = DateUtil.getIntervalDays(startTime, endTime);
                    allSurchargerate = ShareUtil.getMulMoney(ShareUtil.getMulMoney(rate, calcFee), new BigDecimal(countDay + "")).setScale(2, BigDecimal.ROUND_DOWN);
                    newSurcharge.setStartTime(startTime);
                    newSurcharge.setCalcCount((short) 1);
                    newSurcharge.setCustomerId(vo.getCustomerId());
                    newSurcharge.setDataTime(vo.getDataTime());
                    newSurcharge.setEnergyType(vo.getEnergyType());
                    newSurcharge.setUpdateTime(updateTime);
                    newSurcharge.setEndTime(endTime);
                    newSurcharge.setMoney(allSurchargerate);
                    newSurcharge.setFee(calcFee);
                    ppfSurchargeMapper.insert(newSurcharge);
                    logger.info("【滞纳金账单信息】：用户ID >>" + vo.getCustomerId() + " 账单时间 >>" + DateUtil.DateToYYYYMMStr(vo.getDataTime()) + " 计算本金 >>" + calcFee + " 计算月份 >>"
                                + DateUtil.DateToYYYYMMStr(startTime) + " 计算天数 >>" + countDay + " 滞纳金 >>" + allSurchargerate + " 计算利率 >>" + rate);
                }
            }
        }
    }

    @Override
    public List<PpfCustomerFeeMonthOther> selectCustomerFeeMonthOtherByExample(PpfCustomerFeeMonthOtherExample example) {
        return ppfCustomerFeeMonthOtherMapper.selectByExample(example);
    }

    @Override
    public int updateSuccessCustomerFeeMonthOtherByBatch(List<BankBill> successBankReturnList) {
        return ppfCustomerFeeMonthOtherMapper.updateSuccessCustomerFeeMonthOtherByBatch(successBankReturnList);
    }

    @Override
    public int updateUnSuccessCustomerFeeMonthOtherByBatch(List<BankBill> unSuccessBankReturnList) {
        return ppfCustomerFeeMonthOtherMapper.updateUnSuccessCustomerFeeMonthOtherByBatch(unSuccessBankReturnList);
    }

    @Override
    public int updateDispenseCustomerFeeMonthOtherByBatch(List<BankBill> dispenseBankReturnList) {
        return ppfCustomerFeeMonthOtherMapper.updateDispenseCustomerFeeMonthOtherByBatch(dispenseBankReturnList);
    }

}
