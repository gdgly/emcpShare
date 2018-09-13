package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.ViewPoint;
import com.holley.emcpshare.model.ViewPointExample;
import com.holley.emcpshare.model.ViewPointKey;
import com.holley.emcpshare.model.def.ViewPointVO;

public interface ViewPointMapper {

    int countByExample(ViewPointExample example);

    int deleteByExample(ViewPointExample example);

    int deleteByPrimaryKey(ViewPointKey key);

    int insert(ViewPoint record);

    int insertSelective(ViewPoint record);

    List<ViewPoint> selectByExample(ViewPointExample example);

    ViewPoint selectByPrimaryKey(ViewPointKey key);

    int updateByExampleSelective(@Param("record") ViewPoint record, @Param("example") ViewPointExample example);

    int updateByExample(@Param("record") ViewPoint record, @Param("example") ViewPointExample example);

    int updateByPrimaryKeySelective(ViewPoint record);

    int updateByPrimaryKey(ViewPoint record);

    List<ViewPointVO> selectPointsByViewPoint(Map<String, Object> map);

}
