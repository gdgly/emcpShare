package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.PpfCustomerFeeMonthOther;
import com.holley.emcpshare.model.PpfCustomerFeeMonthOtherExample;
import com.holley.emcpshare.model.PpfCustomerFeeMonthOtherKey;
import com.holley.emcpshare.model.bank.BankBill;
import com.holley.emcpshare.model.bank.BankSurchargeVo;

public interface PpfCustomerFeeMonthOtherMapper {

    int countByExample(PpfCustomerFeeMonthOtherExample example);

    int deleteByExample(PpfCustomerFeeMonthOtherExample example);

    int deleteByPrimaryKey(PpfCustomerFeeMonthOtherKey key);

    int insert(PpfCustomerFeeMonthOther record);

    int insertSelective(PpfCustomerFeeMonthOther record);

    List<PpfCustomerFeeMonthOther> selectByExample(PpfCustomerFeeMonthOtherExample example);

    PpfCustomerFeeMonthOther selectByPrimaryKey(PpfCustomerFeeMonthOtherKey key);

    int updateByExampleSelective(@Param("record") PpfCustomerFeeMonthOther record, @Param("example") PpfCustomerFeeMonthOtherExample example);

    int updateByExample(@Param("record") PpfCustomerFeeMonthOther record, @Param("example") PpfCustomerFeeMonthOtherExample example);

    int updateByPrimaryKeySelective(PpfCustomerFeeMonthOther record);

    int updateByPrimaryKey(PpfCustomerFeeMonthOther record);

    // add
    /**
     * 查询账单信息
     * 
     * @param param
     * @return
     */
    List<BankBill> queryBankBills(Map<String, Object> param);

    List<BankSurchargeVo> selectCustomerFeeMonthOther(Map<String, Object> params);

    int updateSuccessCustomerFeeMonthOtherByBatch(List<BankBill> successBankReturnList);

    int updateUnSuccessCustomerFeeMonthOtherByBatch(List<BankBill> unSuccessBankReturnList);

    int updateUncutCustomerFeeMonthOtherByBatch(List<BankBill> unSuccessBankReturnList);

    int updateDispenseCustomerFeeMonthOtherByBatch(List<BankBill> dispenseBankReturnList);
}
