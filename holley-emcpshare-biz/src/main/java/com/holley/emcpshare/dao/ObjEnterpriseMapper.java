package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.ObjEnterprise;
import com.holley.emcpshare.model.ObjEnterpriseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjEnterpriseMapper {
    int countByExample(ObjEnterpriseExample example);

    int deleteByExample(ObjEnterpriseExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(ObjEnterprise record);

    int insertSelective(ObjEnterprise record);

    List<ObjEnterprise> selectByExample(ObjEnterpriseExample example);

    ObjEnterprise selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") ObjEnterprise record, @Param("example") ObjEnterpriseExample example);

    int updateByExample(@Param("record") ObjEnterprise record, @Param("example") ObjEnterpriseExample example);

    int updateByPrimaryKeySelective(ObjEnterprise record);

    int updateByPrimaryKey(ObjEnterprise record);
}