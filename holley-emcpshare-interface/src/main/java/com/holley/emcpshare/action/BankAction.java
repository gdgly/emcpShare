package com.holley.emcpshare.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.holley.emcp.common.constants.ppf.FeeChangeTypeEnum;
import com.holley.emcpshare.bankenum.BankBillReturnStatusEnum;
import com.holley.emcpshare.bankenum.BankPushReturnTypeEnum;
import com.holley.emcpshare.bankenum.BankReturnStatusEnum;
import com.holley.emcpshare.base.action.BaseAction;
import com.holley.emcpshare.comenum.EnergyTypeEnum;
import com.holley.emcpshare.comenum.FeeCheckStatusEnum;
import com.holley.emcpshare.comenum.FeeCutStatusEnum;
import com.holley.emcpshare.comenum.RetTypeEnum;
import com.holley.emcpshare.common.util.ShareGloblas;
import com.holley.emcpshare.common.util.ShareUtil;
import com.holley.emcpshare.model.PpfBillPushReturn;
import com.holley.emcpshare.model.PpfCustomer;
import com.holley.emcpshare.model.PpfCustomerExample;
import com.holley.emcpshare.model.PpfCustomerFeeChange;
import com.holley.emcpshare.model.PpfCustomerFeeChangeExample;
import com.holley.emcpshare.model.PpfCustomerFeeMonthOther;
import com.holley.emcpshare.model.PpfCustomerFeeMonthOtherExample;
import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.model.bank.BankBill;
import com.holley.emcpshare.model.bank.BankBillsRs;
import com.holley.emcpshare.model.bank.BankContractRs;
import com.holley.emcpshare.model.bank.BankDissolutionRs;
import com.holley.emcpshare.model.def.ShareResultBean;
import com.holley.emcpshare.service.share.BankService;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.NumberUtil;
import com.holley.platform.common.util.StringUtil;

/**
 * 共享信息
 * 
 * @author sc
 */
public class BankAction extends BaseAction {

    private final static Logger logger     = Logger.getLogger(BankAction.class);
    private ShareResultBean     resultBean = new ShareResultBean();
    @Resource
    private BankService         bankService;

    /**
     * 签约
     * 
     * @return
     * @throws Exception
     */
    public String queryBankContract() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String operatorsecret = getDataString(data, "operatorSecret");
        String hh = getDataString(data, "hh");// 户号
        String cardNo = getDataString(data, "cardNo");// 卡号
        String dateTime = getDataString(data, "dateTime");// 请求日期
        if (sk == null) {// 无此运营商
            resultBean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
            return SUCCESS;
        }
        if (!sk.getOperatorsecret().equals(operatorsecret)) {
            resultBean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
            return SUCCESS;
        }
        if (StringUtil.isNull(hh, cardNo, dateTime)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        logger.info("queryBankContract:" + data);
        BankContractRs bankContractRs = new BankContractRs();
        resultBean.setData(bankContractRs);
        PpfBillPushReturn billPushReturn = new PpfBillPushReturn();
        billPushReturn.setAddTime(new Date());
        billPushReturn.setContent(data != null ? data.toString() : "");
        billPushReturn.setEnergyType(EnergyTypeEnum.WATER.getShortValue());
        billPushReturn.setType(BankPushReturnTypeEnum.CONTRACT.getShortValue());
        // 插入日志
        bankService.insertAndUpdateBillPush(billPushReturn, null);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hh", hh);
        params.put("eid", sk.getEid());
        params.put("energyType", EnergyTypeEnum.WATER.getValue());
        BankContractRs bankContract = bankService.selectBankContract(params);
        if (bankContract == null) {
            bankContractRs.setReturnCode(BankReturnStatusEnum.USER_NOT_REGISTER);
            return SUCCESS;
        }
        BeanUtils.copyProperties(bankContractRs, bankContract);
        if (StringUtil.isNotEmpty(bankContract.getCardNumber())) {
            bankContractRs.setReturnCode(BankReturnStatusEnum.USER_ALREADY_REGISTER);
            return SUCCESS;
        }
        bankContractRs.setCardNumber(cardNo);
        PpfCustomer modifyCustomer = new PpfCustomer();
        modifyCustomer.setCardno(cardNo);
        modifyCustomer.setUpdatetime(new Date());
        PpfCustomerExample customerEmp = new PpfCustomerExample();
        PpfCustomerExample.Criteria customerCr = customerEmp.createCriteria();
        customerCr.andEidEqualTo(sk.getEid());
        customerCr.andHhEqualTo(hh);
        customerCr.andStatusGreaterThan((short) 0);
        int count = bankService.updateCustomerByExampleSelective(modifyCustomer, customerEmp);
        if (count > 0) {
            bankContractRs.setReturnCode(BankReturnStatusEnum.SUCCESS);
        } else {
            bankContractRs.setReturnCode(BankReturnStatusEnum.UNKNOWN_ERROR);
        }
        return SUCCESS;
    }

    /**
     * 解约
     * 
     * @return
     * @throws Exception
     */
    public String queryBankDissolution() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String operatorsecret = getDataString(data, "operatorSecret");
        String hh = getDataString(data, "hh");// 户号
        String cardNo = getDataString(data, "cardNo");// 卡号
        String dateTime = getDataString(data, "dateTime");// 请求日期
        BankDissolutionRs rsBean = new BankDissolutionRs();
        resultBean.setData(rsBean);
        if (sk == null) {// 无此运营商
            resultBean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
            return SUCCESS;
        }
        if (!sk.getOperatorsecret().equals(operatorsecret)) {
            resultBean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
            return SUCCESS;
        }
        if (StringUtil.isNull(hh, cardNo, dateTime)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        logger.info("queryBankDissolution:" + data);

        PpfBillPushReturn billPushReturn = new PpfBillPushReturn();
        billPushReturn.setAddTime(new Date());
        billPushReturn.setContent(data != null ? data.toString() : "");
        billPushReturn.setEnergyType(EnergyTypeEnum.WATER.getShortValue());
        billPushReturn.setType(BankPushReturnTypeEnum.DISSOLUTION.getShortValue());
        bankService.insertAndUpdateBillPush(billPushReturn, null);

        PpfCustomerExample customerEmp = new PpfCustomerExample();
        PpfCustomerExample.Criteria customerCr = customerEmp.createCriteria();
        customerCr.andEidEqualTo(sk.getEid());
        customerCr.andHhEqualTo(hh);
        customerCr.andCardnoEqualTo(cardNo);
        customerCr.andStatusGreaterThan((short) 0);
        List<PpfCustomer> list = bankService.selectCustomerByExample(customerEmp);
        if (list == null || list.isEmpty()) {
            rsBean.setReturnCode(BankReturnStatusEnum.USER_NOT_REGISTER);
            return SUCCESS;
        }
        customerEmp.clear();
        customerCr = customerEmp.createCriteria();
        customerCr.andEidEqualTo(sk.getEid());
        customerCr.andHhEqualTo(hh);
        customerCr.andStatusGreaterThan((short) 0);
        PpfCustomer modifyCustomer = new PpfCustomer();
        modifyCustomer.setCardno("");// 解约置空卡号
        modifyCustomer.setUpdatetime(new Date());
        int count = bankService.updateCustomerByExampleSelective(modifyCustomer, customerEmp);
        if (count > 0) {
            rsBean.setReturnCode(BankReturnStatusEnum.SUCCESS);
        } else {
            rsBean.setReturnCode(BankReturnStatusEnum.UNKNOWN_ERROR);
        }
        return SUCCESS;
    }

    /**
     * 返回账单结果信息
     * 
     * @return
     * @throws Exception
     */
    public String queryBankBillsResult() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String operatorsecret = getDataString(data, "operatorSecret");
        String datas = getDataString(data, "datas");
        if (sk == null) {// 无此运营商
            resultBean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
            return SUCCESS;
        }
        if (!sk.getOperatorsecret().equals(operatorsecret)) {
            resultBean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
            return SUCCESS;
        }
        logger.info("【处理前的账单】:" + datas);
        PpfBillPushReturn billPushReturn = new PpfBillPushReturn();
        billPushReturn.setAddTime(new Date());
        billPushReturn.setContent(datas);
        billPushReturn.setEnergyType(EnergyTypeEnum.WATER.getShortValue());
        billPushReturn.setType(BankPushReturnTypeEnum.RETURN.getShortValue());
        bankService.insertAndUpdateBillPush(billPushReturn, null);
        List<BankBill> bankReturnList = null;
        if (StringUtil.isNotEmpty(datas)) {
            List<String> dataList = JSON.parseArray(datas, String.class);
            if (dataList != null && !dataList.isEmpty()) {
                bankReturnList = new ArrayList<BankBill>();
                for (String str : dataList) {
                    List<String> tempList = new ArrayList<String>();
                    ShareUtil.getParam(str, tempList);
                    BankBill bill = getParamBean(tempList);
                    if (bill != null) {
                        bankReturnList.add(bill);
                    }
                }
            }
        }

        if (bankReturnList != null && !bankReturnList.isEmpty()) {
            logger.info("【处理后的账单】:" + JSON.toJSONString(bankReturnList, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));
            // 扣款成功的账单
            List<BankBill> successBankReturnList = new ArrayList<BankBill>();
            // 扣款失败的账单
            List<BankBill> unSuccessBankReturnList = new ArrayList<BankBill>();
            List<String> hhList = returHhs(bankReturnList);
            PpfCustomerExample customerEmp = new PpfCustomerExample();
            PpfCustomerExample.Criteria customerCr = customerEmp.createCriteria();
            customerCr.andHhIn(hhList);
            customerCr.andEidEqualTo(sk.getEid());
            customerCr.andStatusGreaterThan((short) 0);
            List<PpfCustomer> customerList = bankService.selectCustomerByExample(customerEmp);

            // 塞入对应的用户ID
            for (BankBill tempBill : bankReturnList) {
                for (PpfCustomer customer : customerList) {
                    if (tempBill.getHh().equals(customer.getHh())) {
                        tempBill.setCustomerId(customer.getCustomerid());
                        break;
                    }
                }
            }
            // 过滤错误的账单
            Iterator<BankBill> it = bankReturnList.iterator();
            while (it.hasNext()) {
                BankBill banbill = it.next();
                if (banbill.getCustomerId() == null) {
                    logger.info("【删除未知用户的账单】：" + JSON.toJSONString(banbill, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));
                    it.remove();
                }
            }

            // 过滤已经处理的账单
            PpfCustomerFeeMonthOtherExample customerFeeMonthOtherEmp = new PpfCustomerFeeMonthOtherExample();
            PpfCustomerFeeMonthOtherExample.Criteria customerFeeMonthOtherCriteria = customerFeeMonthOtherEmp.createCriteria();
            customerFeeMonthOtherCriteria.andDatatimeIn(returnDataTimes(bankReturnList));
            customerFeeMonthOtherCriteria.andCustomeridIn(returnCustomerIds(bankReturnList));
            customerFeeMonthOtherCriteria.andEnergytypeEqualTo(EnergyTypeEnum.WATER.getShortValue());
            customerFeeMonthOtherCriteria.andCutstatusEqualTo(FeeCutStatusEnum.SUCCESS.getShortValue());

            List<PpfCustomerFeeMonthOther> recrods = bankService.selectCustomerFeeMonthOtherByExample(customerFeeMonthOtherEmp);

            Iterator<BankBill> it2 = bankReturnList.iterator();
            if (!recrods.isEmpty()) {
                while (it2.hasNext()) {
                    BankBill temp = it2.next();
                    for (PpfCustomerFeeMonthOther record : recrods) {
                        if (temp.getDataTime().equals(record.getDatatime()) && temp.getCustomerId().equals(record.getCustomerid())) {
                            logger.info("【删除已成功扣款的账单】：" + JSON.toJSONString(temp, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));
                            it2.remove();
                            break;
                        }
                    }
                }
            }
            // 正常数据划分交易成功的和失败的记录
            for (BankBill tempBill : bankReturnList) {
                String returnStatus = tempBill.getReturnStatus();

                if (StringUtil.isNotEmpty(returnStatus)) {
                    if (BankBillReturnStatusEnum.SUCCESS.getValue().equals(returnStatus)) {
                        successBankReturnList.add(tempBill);
                    } else {
                        unSuccessBankReturnList.add(tempBill);
                    }
                } else {
                    unSuccessBankReturnList.add(tempBill);
                }
            }
            bankService.updateBankReturnBills(bankReturnList, successBankReturnList, unSuccessBankReturnList, sk.getEid());
        }
        return SUCCESS;
    }

    /**
     * 查询账单信息
     * 
     * @return
     * @throws Exception
     */
    public String queryBankBills() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String operatorsecret = getDataString(data, "operatorSecret");
        BankBillsRs rsBean = new BankBillsRs();
        resultBean.setData(rsBean);
        if (sk == null) {// 无此运营商
            resultBean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
            return SUCCESS;
        }
        if (!sk.getOperatorsecret().equals(operatorsecret)) {
            resultBean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("energyType", EnergyTypeEnum.WATER.getValue());
        param.put("feeCheckStatus", FeeCheckStatusEnum.CHECKED.getValue());
        param.put("eid", sk.getEid());
        List<BankBill> bankBillList = bankService.queryBankBills(param);
        // 无需扣款的账单直接更新成已扣款状态
        List<BankBill> dispenseBankBillList = new ArrayList<BankBill>();
        if (!bankBillList.isEmpty()) {
            // 查询是否有追退费情况
            PpfCustomerFeeChangeExample feeChangeEmp = new PpfCustomerFeeChangeExample();
            PpfCustomerFeeChangeExample.Criteria feeChangeCr = feeChangeEmp.createCriteria();
            feeChangeCr.andCustomeridIn(returnCustomerIds(bankBillList));
            feeChangeCr.andDatatimeIn(returnDataTimes(bankBillList));
            feeChangeCr.andEnergytypeEqualTo(EnergyTypeEnum.WATER.getShortValue());
            int count = bankService.countCustomerFeeChangeByExample(feeChangeEmp);
            // 追退费处理
            if (count > 0) {
                List<PpfCustomerFeeChange> feeChangeList = bankService.selectCustomerFeeChangeByExample(feeChangeEmp);
                for (PpfCustomerFeeChange feeChange : feeChangeList) {
                    for (BankBill bankBill : bankBillList) {
                        if (feeChange.getDatatime().equals(bankBill.getDataTime()) && feeChange.getCustomerid().equals(bankBill.getCustomerId())) {
                            if (feeChange.getType().equals(FeeChangeTypeEnum.ADD_FEE.getShortValue())) {
                                // 追费
                                bankBill.setMoney(NumberUtil.add(bankBill.getMoney(), feeChange.getMoney()));
                            } else if (feeChange.getType().equals(FeeChangeTypeEnum.SUBTRACT_FEE.getShortValue())) {
                                // 退费
                                bankBill.setMoney(NumberUtil.sub(bankBill.getMoney(), feeChange.getMoney()));
                            }
                            break;
                        }
                    }
                }
            }
            Iterator<BankBill> it = bankBillList.iterator();
            // 排除异常账单
            while (it.hasNext()) {
                BankBill tempBill = it.next();
                if (tempBill.getMoney().compareTo(BigDecimal.ZERO) <= 0) {
                    dispenseBankBillList.add(tempBill);
                    it.remove();
                }
            }
        }
        // 更新无需扣款的账单直接设为已扣款add 2018-9-13
        if (!dispenseBankBillList.isEmpty()) {
            bankService.updateDispenseCustomerFeeMonthOtherByBatch(dispenseBankBillList);
        }
        List<String> rsList = wrapSeparatorStrBatch(bankBillList);
        rsBean.setDatas(rsList);
        PpfBillPushReturn billPushReturn = new PpfBillPushReturn();
        billPushReturn.setAddTime(new Date());
        billPushReturn.setContent(JSON.toJSONString(rsList));
        billPushReturn.setEnergyType(EnergyTypeEnum.WATER.getShortValue());
        billPushReturn.setType(BankPushReturnTypeEnum.PUSH.getShortValue());
        bankService.insertAndUpdateBillPush(billPushReturn, bankBillList);
        return SUCCESS;
    }

    private List<Integer> returnCustomerIds(List<BankBill> list) {
        Set<Integer> customerIds = new HashSet<Integer>();
        for (BankBill bill : list) {
            customerIds.add(bill.getCustomerId());
        }
        return new ArrayList<Integer>(customerIds);
    }

    private List<Date> returnDataTimes(List<BankBill> list) {
        Set<Date> dataTimes = new HashSet<Date>();
        for (BankBill bill : list) {
            dataTimes.add(bill.getDataTime());
        }
        return new ArrayList<Date>(dataTimes);
    }

    private List<String> returHhs(List<BankBill> list) {
        Set<String> hhs = new HashSet<String>();
        for (BankBill bill : list) {
            hhs.add(bill.getHh());
        }
        return new ArrayList<String>(hhs);
    }

    private String wrapSeparatorStr(BankBill monthBill) {
        StringBuffer buf = new StringBuffer();
        buf.append(ShareUtil.getDefaultStr(monthBill.getHh())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getHm())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getAddress())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getDataTimeStr())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getPreNum())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getCurrentNum())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getOtherNum())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getRealNum())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getPrice())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getMoney())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getRebate())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareUtil.getDefaultStr(monthBill.getCardNum())).append(ShareGloblas.LYSW_DELIMITER);
        buf.append(ShareGloblas.LYSW_DELIMITER);
        return buf.toString();
    }

    public List<String> wrapSeparatorStrBatch(List<BankBill> bonthBillList) {
        List<String> list = new ArrayList<String>(bonthBillList.size());
        for (BankBill bill : bonthBillList) {
            list.add(wrapSeparatorStr(bill));
        }
        return list;
    }

    private BankBill getParamBean(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        } else if (list.size() != ShareGloblas.BANK_RETURN_SIZE) {
            logger.info("【账单长度有误】：" + JSON.toJSONString(list, SerializerFeature.WriteMapNullValue));
            return null;
        }
        String hh = list.get(0);// 户号
        String hm = list.get(1);// 户名
        String address = list.get(2);// 地址
        String dateTime = list.get(3);// 账单时间月份

        String preNum = list.get(4);// 上期度数
        String currentNum = list.get(5);// 本期度数
        String otherNum = list.get(6);// 其他度数
        String realNum = list.get(7);// 实际度数
        String price = list.get(8);// 单价
        String money = list.get(9);// 金额
        String rebate = list.get(10);// 滞纳金

        String cardNum = list.get(11);// 卡号
        String returnStatus = list.get(12);// 返回状态
        if (StringUtil.isEmpty(hh) || StringUtil.isEmpty(dateTime) || StringUtil.isEmpty(returnStatus)) {
            logger.info("【账单缺少必要参数】：" + JSON.toJSONString(list, SerializerFeature.WriteMapNullValue));
            return null;
        }
        Date date = DateUtil.StrToDate(dateTime, DateUtil.YEARMONTH);
        if (date == null) {
            logger.info("【账单日期有误】：" + JSON.toJSONString(list, SerializerFeature.WriteMapNullValue));
            return null;
        }
        BankBill returnBill = new BankBill();
        returnBill.setHh(hh);
        returnBill.setHm(hm);
        returnBill.setAddress(address);
        returnBill.setDataTime(date);
        returnBill.setPreNum(ShareUtil.getDefaultDecimal(preNum));
        returnBill.setCurrentNum(ShareUtil.getDefaultDecimal(currentNum));
        returnBill.setOtherNum(ShareUtil.getDefaultDecimal(otherNum));
        returnBill.setRealNum(ShareUtil.getDefaultDecimal(realNum));
        returnBill.setPrice(ShareUtil.getDefaultDecimal(price));
        returnBill.setMoney(ShareUtil.getDefaultDecimal(money));
        returnBill.setRebate(ShareUtil.getDefaultDecimal(rebate));
        returnBill.setCardNum(cardNum);
        returnBill.setReturnStatus(returnStatus);
        return returnBill;
    }

    // GET SET
    public ShareResultBean getResultBean() {
        return resultBean;
    }
}
