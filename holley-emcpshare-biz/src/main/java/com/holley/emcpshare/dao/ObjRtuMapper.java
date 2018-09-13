package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.ObjRtu;
import com.holley.emcpshare.model.ObjRtuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjRtuMapper {
    int countByExample(ObjRtuExample example);

    int deleteByExample(ObjRtuExample example);

    int deleteByPrimaryKey(Integer rtuid);

    int insert(ObjRtu record);

    int insertSelective(ObjRtu record);

    List<ObjRtu> selectByExample(ObjRtuExample example);

    ObjRtu selectByPrimaryKey(Integer rtuid);

    int updateByExampleSelective(@Param("record") ObjRtu record, @Param("example") ObjRtuExample example);

    int updateByExample(@Param("record") ObjRtu record, @Param("example") ObjRtuExample example);

    int updateByPrimaryKeySelective(ObjRtu record);

    int updateByPrimaryKey(ObjRtu record);
}