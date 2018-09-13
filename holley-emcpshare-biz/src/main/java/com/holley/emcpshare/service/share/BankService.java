package com.holley.emcpshare.service.share;

import java.util.List;
import java.util.Map;

import com.holley.emcpshare.model.PpfBillPushReturn;
import com.holley.emcpshare.model.PpfCustomer;
import com.holley.emcpshare.model.PpfCustomerExample;
import com.holley.emcpshare.model.PpfCustomerFeeChange;
import com.holley.emcpshare.model.PpfCustomerFeeChangeExample;
import com.holley.emcpshare.model.PpfCustomerFeeMonthOther;
import com.holley.emcpshare.model.PpfCustomerFeeMonthOtherExample;
import com.holley.emcpshare.model.bank.BankBill;
import com.holley.emcpshare.model.bank.BankContractRs;
import com.holley.emcpshare.model.bank.BankSurchargeVo;

public interface BankService {

    List<BankBill> queryBankBills(Map<String, Object> param);

    int countCustomerFeeChangeByExample(PpfCustomerFeeChangeExample example);

    List<PpfCustomerFeeChange> selectCustomerFeeChangeByExample(PpfCustomerFeeChangeExample example);

    int insertAndUpdateBillPush(PpfBillPushReturn record, List<BankBill> bankBillList);

    void updateBankReturnBills(List<BankBill> allBankReturnList, List<BankBill> successBankReturnList, List<BankBill> unSuccessBankReturnList, Integer eid);

    int insertBillResultByBatch(List<BankBill> list);

    List<PpfCustomer> selectCustomerByExample(PpfCustomerExample example);

    BankContractRs selectBankContract(Map<String, Object> params);

    int updateCustomerByExampleSelective(PpfCustomer record, PpfCustomerExample example);

    List<BankSurchargeVo> selectCustomerFeeMonthOther(Map<String, Object> params);

    void updateAndInsertSurcharge(List<BankSurchargeVo> list);

    List<PpfCustomerFeeMonthOther> selectCustomerFeeMonthOtherByExample(PpfCustomerFeeMonthOtherExample example);

    int updateSuccessCustomerFeeMonthOtherByBatch(List<BankBill> successBankReturnList);

    int updateUnSuccessCustomerFeeMonthOtherByBatch(List<BankBill> unSuccessBankReturnList);

    int updateDispenseCustomerFeeMonthOtherByBatch(List<BankBill> dispenseBankReturnList);
}
