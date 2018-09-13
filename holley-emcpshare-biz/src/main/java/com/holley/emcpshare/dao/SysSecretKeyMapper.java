package com.holley.emcpshare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.model.SysSecretKeyExample;

public interface SysSecretKeyMapper {

    int countByExample(SysSecretKeyExample example);

    int deleteByExample(SysSecretKeyExample example);

    int deleteByPrimaryKey(String operatorid);

    int insert(SysSecretKey record);

    int insertSelective(SysSecretKey record);

    List<SysSecretKey> selectByExample(SysSecretKeyExample example);

    SysSecretKey selectByPrimaryKey(String operatorid);

    int updateByExampleSelective(@Param("record") SysSecretKey record, @Param("example") SysSecretKeyExample example);

    int updateByExample(@Param("record") SysSecretKey record, @Param("example") SysSecretKeyExample example);

    int updateByPrimaryKeySelective(SysSecretKey record);

    int updateByPrimaryKey(SysSecretKey record);
}
