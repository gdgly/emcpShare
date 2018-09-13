package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.DatPowerSsl;
import com.holley.emcpshare.model.DatPowerSslExample;
import com.holley.emcpshare.model.DatPowerSslKey;

public interface DatPowerSslMapper {

    int countByExample(DatPowerSslExample example);

    int deleteByExample(DatPowerSslExample example);

    int deleteByPrimaryKey(DatPowerSslKey key);

    int insert(DatPowerSsl record);

    int insertSelective(DatPowerSsl record);

    List<DatPowerSsl> selectByExample(DatPowerSslExample example);

    DatPowerSsl selectByPrimaryKey(DatPowerSslKey key);

    int updateByExampleSelective(@Param("record") DatPowerSsl record, @Param("example") DatPowerSslExample example);

    int updateByExample(@Param("record") DatPowerSsl record, @Param("example") DatPowerSslExample example);

    int updateByPrimaryKeySelective(DatPowerSsl record);

    int updateByPrimaryKey(DatPowerSsl record);

    DatPowerSsl selectLastPowerSsl(Map<String, Object> map);
}
