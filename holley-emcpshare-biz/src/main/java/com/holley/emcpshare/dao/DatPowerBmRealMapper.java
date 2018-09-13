package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.DatPowerBmReal;
import com.holley.emcpshare.model.DatPowerBmRealExample;
import com.holley.emcpshare.model.DatPowerBmRealKey;
import com.holley.emcpshare.model.def.GuoJiuPowerBmVO;
import com.holley.emcpshare.model.def.HistoryElectricityInfo;

public interface DatPowerBmRealMapper {

    int countByExample(DatPowerBmRealExample example);

    int deleteByExample(DatPowerBmRealExample example);

    int deleteByPrimaryKey(DatPowerBmRealKey key);

    int insert(DatPowerBmReal record);

    int insertSelective(DatPowerBmReal record);

    List<DatPowerBmReal> selectByExample(DatPowerBmRealExample example);

    DatPowerBmReal selectByPrimaryKey(DatPowerBmRealKey key);

    int updateByExampleSelective(@Param("record") DatPowerBmReal record, @Param("example") DatPowerBmRealExample example);

    int updateByExample(@Param("record") DatPowerBmReal record, @Param("example") DatPowerBmRealExample example);

    int updateByPrimaryKeySelective(DatPowerBmReal record);

    int updateByPrimaryKey(DatPowerBmReal record);

    List<HistoryElectricityInfo> selectLastPowerBmBatch(Integer eid);

    List<GuoJiuPowerBmVO> selectGjRealPowerBm(Map<String, Object> map);
}
