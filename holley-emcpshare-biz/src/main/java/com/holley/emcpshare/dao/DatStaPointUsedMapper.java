package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.DatStaPointUsed;
import com.holley.emcpshare.model.DatStaPointUsedExample;
import com.holley.emcpshare.model.DatStaPointUsedKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatStaPointUsedMapper {
    int countByExample(DatStaPointUsedExample example);

    int deleteByExample(DatStaPointUsedExample example);

    int deleteByPrimaryKey(DatStaPointUsedKey key);

    int insert(DatStaPointUsed record);

    int insertSelective(DatStaPointUsed record);

    List<DatStaPointUsed> selectByExample(DatStaPointUsedExample example);

    DatStaPointUsed selectByPrimaryKey(DatStaPointUsedKey key);

    int updateByExampleSelective(@Param("record") DatStaPointUsed record, @Param("example") DatStaPointUsedExample example);

    int updateByExample(@Param("record") DatStaPointUsed record, @Param("example") DatStaPointUsedExample example);

    int updateByPrimaryKeySelective(DatStaPointUsed record);

    int updateByPrimaryKey(DatStaPointUsed record);
}