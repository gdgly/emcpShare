package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.ObjSubeuu;
import com.holley.emcpshare.model.ObjSubeuuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjSubeuuMapper {
    int countByExample(ObjSubeuuExample example);

    int deleteByExample(ObjSubeuuExample example);

    int deleteByPrimaryKey(Integer subeuuid);

    int insert(ObjSubeuu record);

    int insertSelective(ObjSubeuu record);

    List<ObjSubeuu> selectByExample(ObjSubeuuExample example);

    ObjSubeuu selectByPrimaryKey(Integer subeuuid);

    int updateByExampleSelective(@Param("record") ObjSubeuu record, @Param("example") ObjSubeuuExample example);

    int updateByExample(@Param("record") ObjSubeuu record, @Param("example") ObjSubeuuExample example);

    int updateByPrimaryKeySelective(ObjSubeuu record);

    int updateByPrimaryKey(ObjSubeuu record);
}