package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.DatBmReal;
import com.holley.emcpshare.model.DatBmRealExample;
import com.holley.emcpshare.model.DatBmRealKey;
import com.holley.emcpshare.model.def.GuoJiuOtherBmVO;

public interface DatBmRealMapper {

    int countByExample(DatBmRealExample example);

    int deleteByExample(DatBmRealExample example);

    int deleteByPrimaryKey(DatBmRealKey key);

    int insert(DatBmReal record);

    int insertSelective(DatBmReal record);

    List<DatBmReal> selectByExample(DatBmRealExample example);

    DatBmReal selectByPrimaryKey(DatBmRealKey key);

    int updateByExampleSelective(@Param("record") DatBmReal record, @Param("example") DatBmRealExample example);

    int updateByExample(@Param("record") DatBmReal record, @Param("example") DatBmRealExample example);

    int updateByPrimaryKeySelective(DatBmReal record);

    int updateByPrimaryKey(DatBmReal record);

    List<GuoJiuOtherBmVO> selectGjRealOtherBm(Map<String, Object> map);
}
