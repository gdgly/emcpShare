package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.DatBm;
import com.holley.emcpshare.model.DatBmExample;
import com.holley.emcpshare.model.DatBmKey;
import com.holley.emcpshare.model.def.GuoJiuOtherBmVO;

public interface DatBmMapper {

    int countByExample(DatBmExample example);

    int deleteByExample(DatBmExample example);

    int deleteByPrimaryKey(DatBmKey key);

    int insert(DatBm record);

    int insertSelective(DatBm record);

    List<DatBm> selectByExample(DatBmExample example);

    DatBm selectByPrimaryKey(DatBmKey key);

    int updateByExampleSelective(@Param("record") DatBm record, @Param("example") DatBmExample example);

    int updateByExample(@Param("record") DatBm record, @Param("example") DatBmExample example);

    int updateByPrimaryKeySelective(DatBm record);

    int updateByPrimaryKey(DatBm record);

    DatBm selectLastWaterBm(Map<String, Object> map);

    List<GuoJiuOtherBmVO> selectGjHistoryOthertBm(Map<String, Object> map);
}
