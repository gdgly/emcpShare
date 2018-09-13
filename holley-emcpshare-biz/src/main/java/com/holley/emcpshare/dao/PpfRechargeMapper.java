package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.PpfRecharge;
import com.holley.emcpshare.model.PpfRechargeExample;
import com.holley.emcpshare.model.def.AccountRechargeInfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PpfRechargeMapper {
    int countByExample(PpfRechargeExample example);

    int deleteByExample(PpfRechargeExample example);

    int deleteByPrimaryKey(Integer rechargeid);

    int insert(PpfRecharge record);

    int insertSelective(PpfRecharge record);

    List<PpfRecharge> selectByExample(PpfRechargeExample example);

    PpfRecharge selectByPrimaryKey(Integer rechargeid);

    int updateByExampleSelective(@Param("record") PpfRecharge record, @Param("example") PpfRechargeExample example);

    int updateByExample(@Param("record") PpfRecharge record, @Param("example") PpfRechargeExample example);

    int updateByPrimaryKeySelective(PpfRecharge record);

    int updateByPrimaryKey(PpfRecharge record);
    
    List<AccountRechargeInfo> selectRechargeByMap(Map<String, Object> map);
}