package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.ObjSleepCmd;
import com.holley.emcpshare.model.ObjSleepCmdExample;
import com.holley.emcpshare.model.ObjSleepCmdKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjSleepCmdMapper {
    int countByExample(ObjSleepCmdExample example);

    int deleteByExample(ObjSleepCmdExample example);

    int deleteByPrimaryKey(ObjSleepCmdKey key);

    int insert(ObjSleepCmd record);

    int insertSelective(ObjSleepCmd record);

    List<ObjSleepCmd> selectByExample(ObjSleepCmdExample example);

    ObjSleepCmd selectByPrimaryKey(ObjSleepCmdKey key);

    int updateByExampleSelective(@Param("record") ObjSleepCmd record, @Param("example") ObjSleepCmdExample example);

    int updateByExample(@Param("record") ObjSleepCmd record, @Param("example") ObjSleepCmdExample example);

    int updateByPrimaryKeySelective(ObjSleepCmd record);

    int updateByPrimaryKey(ObjSleepCmd record);
}