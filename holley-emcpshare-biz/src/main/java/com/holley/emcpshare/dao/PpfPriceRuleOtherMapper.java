package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.PpfPriceRuleOther;
import com.holley.emcpshare.model.PpfPriceRuleOtherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PpfPriceRuleOtherMapper {
    int countByExample(PpfPriceRuleOtherExample example);

    int deleteByExample(PpfPriceRuleOtherExample example);

    int deleteByPrimaryKey(Integer priceid);

    int insert(PpfPriceRuleOther record);

    int insertSelective(PpfPriceRuleOther record);

    List<PpfPriceRuleOther> selectByExample(PpfPriceRuleOtherExample example);

    PpfPriceRuleOther selectByPrimaryKey(Integer priceid);

    int updateByExampleSelective(@Param("record") PpfPriceRuleOther record, @Param("example") PpfPriceRuleOtherExample example);

    int updateByExample(@Param("record") PpfPriceRuleOther record, @Param("example") PpfPriceRuleOtherExample example);

    int updateByPrimaryKeySelective(PpfPriceRuleOther record);

    int updateByPrimaryKey(PpfPriceRuleOther record);
}