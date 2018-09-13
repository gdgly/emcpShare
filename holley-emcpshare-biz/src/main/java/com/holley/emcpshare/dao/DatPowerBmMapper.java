package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.DatPowerBm;
import com.holley.emcpshare.model.DatPowerBmExample;
import com.holley.emcpshare.model.DatPowerBmKey;
import com.holley.emcpshare.model.def.GuoJiuPowerBmVO;
import com.holley.emcpshare.model.def.HongQiaoJiChangPowerZhBmVO;

public interface DatPowerBmMapper {

    int countByExample(DatPowerBmExample example);

    int deleteByExample(DatPowerBmExample example);

    int deleteByPrimaryKey(DatPowerBmKey key);

    int insert(DatPowerBm record);

    int insertSelective(DatPowerBm record);

    List<DatPowerBm> selectByExample(DatPowerBmExample example);

    DatPowerBm selectByPrimaryKey(DatPowerBmKey key);

    int updateByExampleSelective(@Param("record") DatPowerBm record, @Param("example") DatPowerBmExample example);

    int updateByExample(@Param("record") DatPowerBm record, @Param("example") DatPowerBmExample example);

    int updateByPrimaryKeySelective(DatPowerBm record);

    int updateByPrimaryKey(DatPowerBm record);

    List<DatPowerBm> selectPowerBmByDays(Map<String, Object> map);

    List<DatPowerBm> selectAllPowerBmByDays(Map<String, Object> map);

    List<DatPowerBm> selectPowerBmByPointId(Map<String, Object> map);

    List<HongQiaoJiChangPowerZhBmVO> selectPowerZhBm(Map<String, Object> map);

    List<GuoJiuPowerBmVO> selectGjHistoryPowerBm(Map<String, Object> map);
}
