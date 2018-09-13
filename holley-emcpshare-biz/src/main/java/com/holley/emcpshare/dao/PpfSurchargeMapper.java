package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.PpfSurcharge;
import com.holley.emcpshare.model.PpfSurchargeExample;
import com.holley.emcpshare.model.PpfSurchargeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PpfSurchargeMapper {
    int countByExample(PpfSurchargeExample example);

    int deleteByExample(PpfSurchargeExample example);

    int deleteByPrimaryKey(PpfSurchargeKey key);

    int insert(PpfSurcharge record);

    int insertSelective(PpfSurcharge record);

    List<PpfSurcharge> selectByExample(PpfSurchargeExample example);

    PpfSurcharge selectByPrimaryKey(PpfSurchargeKey key);

    int updateByExampleSelective(@Param("record") PpfSurcharge record, @Param("example") PpfSurchargeExample example);

    int updateByExample(@Param("record") PpfSurcharge record, @Param("example") PpfSurchargeExample example);

    int updateByPrimaryKeySelective(PpfSurcharge record);

    int updateByPrimaryKey(PpfSurcharge record);
}