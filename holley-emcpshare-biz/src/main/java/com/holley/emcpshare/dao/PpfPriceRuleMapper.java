package com.holley.emcpshare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.PpfPriceRule;
import com.holley.emcpshare.model.PpfPriceRuleExample;
import com.holley.emcpshare.model.icm.PpfPriceRuleVO;

public interface PpfPriceRuleMapper {

    int countByExample(PpfPriceRuleExample example);

    int deleteByExample(PpfPriceRuleExample example);

    int deleteByPrimaryKey(Integer priceid);

    int insert(PpfPriceRule record);

    int insertSelective(PpfPriceRule record);

    List<PpfPriceRule> selectByExample(PpfPriceRuleExample example);

    PpfPriceRule selectByPrimaryKey(Integer priceid);

    int updateByExampleSelective(@Param("record") PpfPriceRule record, @Param("example") PpfPriceRuleExample example);

    int updateByExample(@Param("record") PpfPriceRule record, @Param("example") PpfPriceRuleExample example);

    int updateByPrimaryKeySelective(PpfPriceRule record);

    int updateByPrimaryKey(PpfPriceRule record);

    PpfPriceRuleVO selectPriceByPointid(Integer pointid);
}
