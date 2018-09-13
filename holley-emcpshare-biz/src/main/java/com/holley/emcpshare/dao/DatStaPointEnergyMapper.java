package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.DatStaPointEnergy;
import com.holley.emcpshare.model.DatStaPointEnergyExample;
import com.holley.emcpshare.model.DatStaPointEnergyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatStaPointEnergyMapper {
    int countByExample(DatStaPointEnergyExample example);

    int deleteByExample(DatStaPointEnergyExample example);

    int deleteByPrimaryKey(DatStaPointEnergyKey key);

    int insert(DatStaPointEnergy record);

    int insertSelective(DatStaPointEnergy record);

    List<DatStaPointEnergy> selectByExample(DatStaPointEnergyExample example);

    DatStaPointEnergy selectByPrimaryKey(DatStaPointEnergyKey key);

    int updateByExampleSelective(@Param("record") DatStaPointEnergy record, @Param("example") DatStaPointEnergyExample example);

    int updateByExample(@Param("record") DatStaPointEnergy record, @Param("example") DatStaPointEnergyExample example);

    int updateByPrimaryKeySelective(DatStaPointEnergy record);

    int updateByPrimaryKey(DatStaPointEnergy record);
}