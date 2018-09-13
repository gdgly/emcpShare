package com.holley.emcpshare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.PpfBillResult;
import com.holley.emcpshare.model.PpfBillResultExample;
import com.holley.emcpshare.model.PpfBillResultKey;
import com.holley.emcpshare.model.bank.BankBill;

public interface PpfBillResultMapper {

    int countByExample(PpfBillResultExample example);

    int deleteByExample(PpfBillResultExample example);

    int deleteByPrimaryKey(PpfBillResultKey key);

    int insert(PpfBillResult record);

    int insertSelective(PpfBillResult record);

    List<PpfBillResult> selectByExample(PpfBillResultExample example);

    PpfBillResult selectByPrimaryKey(PpfBillResultKey key);

    int updateByExampleSelective(@Param("record") PpfBillResult record, @Param("example") PpfBillResultExample example);

    int updateByExample(@Param("record") PpfBillResult record, @Param("example") PpfBillResultExample example);

    int updateByPrimaryKeySelective(PpfBillResult record);

    int updateByPrimaryKey(PpfBillResult record);

    int insertByBatch(List<BankBill> list);

    int updateByBatch(List<BankBill> list);
}
