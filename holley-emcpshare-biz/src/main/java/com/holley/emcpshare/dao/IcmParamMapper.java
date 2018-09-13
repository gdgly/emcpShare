package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.IcmParam;
import com.holley.emcpshare.model.IcmParamExample;
import com.holley.emcpshare.model.icm.MeterParamVO;
import com.holley.emcpshare.model.icm.MeterVO;

public interface IcmParamMapper {

    int countByExample(IcmParamExample example);

    int deleteByExample(IcmParamExample example);

    int deleteByPrimaryKey(Integer pointId);

    int insert(IcmParam record);

    int insertSelective(IcmParam record);

    List<IcmParam> selectByExample(IcmParamExample example);

    IcmParam selectByPrimaryKey(Integer pointId);

    int updateByExampleSelective(@Param("record") IcmParam record, @Param("example") IcmParamExample example);

    int updateByExample(@Param("record") IcmParam record, @Param("example") IcmParamExample example);

    int updateByPrimaryKeySelective(IcmParam record);

    int updateByPrimaryKey(IcmParam record);

    List<MeterParamVO> selectMeterByPage(Map<String, Object> params);

    MeterVO selectMeterByMeterNo(Map<String, Object> params);
}
