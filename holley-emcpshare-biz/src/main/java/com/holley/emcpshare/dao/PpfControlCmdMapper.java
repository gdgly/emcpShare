package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.PpfControlCmd;
import com.holley.emcpshare.model.PpfControlCmdExample;
import com.holley.emcpshare.model.PpfControlCmdKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PpfControlCmdMapper {
    int countByExample(PpfControlCmdExample example);

    int deleteByExample(PpfControlCmdExample example);

    int deleteByPrimaryKey(PpfControlCmdKey key);

    int insert(PpfControlCmd record);

    int insertSelective(PpfControlCmd record);

    List<PpfControlCmd> selectByExample(PpfControlCmdExample example);

    PpfControlCmd selectByPrimaryKey(PpfControlCmdKey key);

    int updateByExampleSelective(@Param("record") PpfControlCmd record, @Param("example") PpfControlCmdExample example);

    int updateByExample(@Param("record") PpfControlCmd record, @Param("example") PpfControlCmdExample example);

    int updateByPrimaryKeySelective(PpfControlCmd record);

    int updateByPrimaryKey(PpfControlCmd record);
}