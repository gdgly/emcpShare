package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.PpfCustomerAccount;
import com.holley.emcpshare.model.PpfCustomerAccountExample;
import com.holley.emcpshare.model.bank.BankBill;

public interface PpfCustomerAccountMapper {

    int countByExample(PpfCustomerAccountExample example);

    int deleteByExample(PpfCustomerAccountExample example);

    int deleteByPrimaryKey(Integer customerid);

    int insert(PpfCustomerAccount record);

    int insertSelective(PpfCustomerAccount record);

    List<PpfCustomerAccount> selectByExample(PpfCustomerAccountExample example);

    PpfCustomerAccount selectByPrimaryKey(Integer customerid);

    int updateByExampleSelective(@Param("record") PpfCustomerAccount record, @Param("example") PpfCustomerAccountExample example);

    int updateByExample(@Param("record") PpfCustomerAccount record, @Param("example") PpfCustomerAccountExample example);

    int updateByPrimaryKeySelective(PpfCustomerAccount record);

    int updateByPrimaryKey(PpfCustomerAccount record);

    // ADD
    /**
     * 根据户号查询用户账户信息
     * 
     * @param hh
     * @return
     */
    PpfCustomerAccount selectCustomerAccountByMap(Map<String, Object> map);

    int updateCustomerAccountByBatch(List<BankBill> list);
}
