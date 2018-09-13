package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.PpfCustomer;
import com.holley.emcpshare.model.PpfCustomerExample;
import com.holley.emcpshare.model.bank.BankContractRs;
import com.holley.emcpshare.model.def.AccountUserInfoVO;
import com.holley.emcpshare.model.icm.PpfCustomerVO;

public interface PpfCustomerMapper {

    int countByExample(PpfCustomerExample example);

    int deleteByExample(PpfCustomerExample example);

    int deleteByPrimaryKey(Integer customerid);

    int insert(PpfCustomer record);

    int insertSelective(PpfCustomer record);

    List<PpfCustomer> selectByExample(PpfCustomerExample example);

    PpfCustomer selectByPrimaryKey(Integer customerid);

    int updateByExampleSelective(@Param("record") PpfCustomer record, @Param("example") PpfCustomerExample example);

    int updateByExample(@Param("record") PpfCustomer record, @Param("example") PpfCustomerExample example);

    int updateByPrimaryKeySelective(PpfCustomer record);

    int updateByPrimaryKey(PpfCustomer record);

    List<PpfCustomerVO> selectCustomerByPage(Map<String, Object> params);

    PpfCustomerVO selectCustomerByCustomerNo(Map<String, Object> params);

    BankContractRs selectBankContract(Map<String, Object> params);

    AccountUserInfoVO selectCustomerAccountInfoByMap(Map<String, Object> params);
}
