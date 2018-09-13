package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.ObjPointCommparam;
import com.holley.emcpshare.model.ObjPointCommparamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjPointCommparamMapper {
    int countByExample(ObjPointCommparamExample example);

    int deleteByExample(ObjPointCommparamExample example);

    int deleteByPrimaryKey(Integer pointid);

    int insert(ObjPointCommparam record);

    int insertSelective(ObjPointCommparam record);

    List<ObjPointCommparam> selectByExample(ObjPointCommparamExample example);

    ObjPointCommparam selectByPrimaryKey(Integer pointid);

    int updateByExampleSelective(@Param("record") ObjPointCommparam record, @Param("example") ObjPointCommparamExample example);

    int updateByExample(@Param("record") ObjPointCommparam record, @Param("example") ObjPointCommparamExample example);

    int updateByPrimaryKeySelective(ObjPointCommparam record);

    int updateByPrimaryKey(ObjPointCommparam record);
}