package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.PpfBillPushReturn;
import com.holley.emcpshare.model.PpfBillPushReturnExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PpfBillPushReturnMapper {
    int countByExample(PpfBillPushReturnExample example);

    int deleteByExample(PpfBillPushReturnExample example);

    int deleteByPrimaryKey(Date addTime);

    int insert(PpfBillPushReturn record);

    int insertSelective(PpfBillPushReturn record);

    List<PpfBillPushReturn> selectByExampleWithBLOBs(PpfBillPushReturnExample example);

    List<PpfBillPushReturn> selectByExample(PpfBillPushReturnExample example);

    PpfBillPushReturn selectByPrimaryKey(Date addTime);

    int updateByExampleSelective(@Param("record") PpfBillPushReturn record, @Param("example") PpfBillPushReturnExample example);

    int updateByExampleWithBLOBs(@Param("record") PpfBillPushReturn record, @Param("example") PpfBillPushReturnExample example);

    int updateByExample(@Param("record") PpfBillPushReturn record, @Param("example") PpfBillPushReturnExample example);

    int updateByPrimaryKeySelective(PpfBillPushReturn record);

    int updateByPrimaryKeyWithBLOBs(PpfBillPushReturn record);

    int updateByPrimaryKey(PpfBillPushReturn record);
}