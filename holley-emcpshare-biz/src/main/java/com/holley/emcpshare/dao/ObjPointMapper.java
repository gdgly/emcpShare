package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.ObjPoint;
import com.holley.emcpshare.model.ObjPointExample;
import com.holley.emcpshare.model.dcs.PointConfGDTO;

public interface ObjPointMapper {

    int countByExample(ObjPointExample example);

    int deleteByExample(ObjPointExample example);

    int deleteByPrimaryKey(Integer pointid);

    int insert(ObjPoint record);

    int insertSelective(ObjPoint record);

    List<ObjPoint> selectByExample(ObjPointExample example);

    ObjPoint selectByPrimaryKey(Integer pointid);

    int updateByExampleSelective(@Param("record") ObjPoint record, @Param("example") ObjPointExample example);

    int updateByExample(@Param("record") ObjPoint record, @Param("example") ObjPointExample example);

    int updateByPrimaryKeySelective(ObjPoint record);

    int updateByPrimaryKey(ObjPoint record);

    // add
    List<PointConfGDTO> selectByRtuidAndPointId(Map<String, Object> param);

    ObjPoint selectPointByMap(Map<String, Object> param);

    List<ObjPoint> selectPointsByCusId(Map<String, Object> param);
}
