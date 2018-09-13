package com.holley.emcpshare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.SysAccount;
import com.holley.emcpshare.model.SysAccountExample;
import com.holley.emcpshare.model.common.SysAccountDetailVO;

public interface SysAccountMapper {

    int countByExample(SysAccountExample example);

    int deleteByExample(SysAccountExample example);

    int deleteByPrimaryKey(String account);

    int insert(SysAccount record);

    int insertSelective(SysAccount record);

    List<SysAccount> selectByExample(SysAccountExample example);

    SysAccount selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") SysAccount record, @Param("example") SysAccountExample example);

    int updateByExample(@Param("record") SysAccount record, @Param("example") SysAccountExample example);

    int updateByPrimaryKeySelective(SysAccount record);

    int updateByPrimaryKey(SysAccount record);

    SysAccountDetailVO selectAccountInfoByAccount(String account);
}
