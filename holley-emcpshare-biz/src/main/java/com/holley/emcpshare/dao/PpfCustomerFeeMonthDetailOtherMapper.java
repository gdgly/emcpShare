package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.PpfCustomerFeeMonthDetailOther;
import com.holley.emcpshare.model.PpfCustomerFeeMonthDetailOtherExample;
import com.holley.emcpshare.model.PpfCustomerFeeMonthDetailOtherKey;
import com.holley.emcpshare.model.def.PpfCustomerFeeMonthDetailOtherVO;

public interface PpfCustomerFeeMonthDetailOtherMapper {

    int countByExample(PpfCustomerFeeMonthDetailOtherExample example);

    int deleteByExample(PpfCustomerFeeMonthDetailOtherExample example);

    int deleteByPrimaryKey(PpfCustomerFeeMonthDetailOtherKey key);

    int insert(PpfCustomerFeeMonthDetailOther record);

    int insertSelective(PpfCustomerFeeMonthDetailOther record);

    List<PpfCustomerFeeMonthDetailOther> selectByExample(PpfCustomerFeeMonthDetailOtherExample example);

    PpfCustomerFeeMonthDetailOther selectByPrimaryKey(PpfCustomerFeeMonthDetailOtherKey key);

    int updateByExampleSelective(@Param("record") PpfCustomerFeeMonthDetailOther record, @Param("example") PpfCustomerFeeMonthDetailOtherExample example);

    int updateByExample(@Param("record") PpfCustomerFeeMonthDetailOther record, @Param("example") PpfCustomerFeeMonthDetailOtherExample example);

    int updateByPrimaryKeySelective(PpfCustomerFeeMonthDetailOther record);

    int updateByPrimaryKey(PpfCustomerFeeMonthDetailOther record);

    // ADD
    List<PpfCustomerFeeMonthDetailOtherVO> selectCustomerWaterFeeMonthByMap(Map<String, Object> map);
}
