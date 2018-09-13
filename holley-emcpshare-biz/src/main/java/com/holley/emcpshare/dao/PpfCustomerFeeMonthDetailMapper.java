package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.PpfCustomerFeeMonthDetail;
import com.holley.emcpshare.model.PpfCustomerFeeMonthDetailExample;
import com.holley.emcpshare.model.PpfCustomerFeeMonthDetailKey;
import com.holley.emcpshare.model.def.PpfCustomerFeeMonthDetailVO;

public interface PpfCustomerFeeMonthDetailMapper {

    int countByExample(PpfCustomerFeeMonthDetailExample example);

    int deleteByExample(PpfCustomerFeeMonthDetailExample example);

    int deleteByPrimaryKey(PpfCustomerFeeMonthDetailKey key);

    int insert(PpfCustomerFeeMonthDetail record);

    int insertSelective(PpfCustomerFeeMonthDetail record);

    List<PpfCustomerFeeMonthDetail> selectByExample(PpfCustomerFeeMonthDetailExample example);

    PpfCustomerFeeMonthDetail selectByPrimaryKey(PpfCustomerFeeMonthDetailKey key);

    int updateByExampleSelective(@Param("record") PpfCustomerFeeMonthDetail record, @Param("example") PpfCustomerFeeMonthDetailExample example);

    int updateByExample(@Param("record") PpfCustomerFeeMonthDetail record, @Param("example") PpfCustomerFeeMonthDetailExample example);

    int updateByPrimaryKeySelective(PpfCustomerFeeMonthDetail record);

    int updateByPrimaryKey(PpfCustomerFeeMonthDetail record);

    // ADD
    List<PpfCustomerFeeMonthDetailVO> selectCustomerPowerFeeMonthByMap(Map<String, Object> map);
}
