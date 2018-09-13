package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.SysHostlog;
import com.holley.emcpshare.model.SysHostlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysHostlogMapper {
    int countByExample(SysHostlogExample example);

    int deleteByExample(SysHostlogExample example);

    int deleteByPrimaryKey(Integer hostlogid);

    int insert(SysHostlog record);

    int insertSelective(SysHostlog record);

    List<SysHostlog> selectByExample(SysHostlogExample example);

    SysHostlog selectByPrimaryKey(Integer hostlogid);

    int updateByExampleSelective(@Param("record") SysHostlog record, @Param("example") SysHostlogExample example);

    int updateByExample(@Param("record") SysHostlog record, @Param("example") SysHostlogExample example);

    int updateByPrimaryKeySelective(SysHostlog record);

    int updateByPrimaryKey(SysHostlog record);
}