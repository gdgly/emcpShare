package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.PpfCustomerFeeChange;
import com.holley.emcpshare.model.PpfCustomerFeeChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PpfCustomerFeeChangeMapper {
    int countByExample(PpfCustomerFeeChangeExample example);

    int deleteByExample(PpfCustomerFeeChangeExample example);

    int deleteByPrimaryKey(Integer chargeid);

    int insert(PpfCustomerFeeChange record);

    int insertSelective(PpfCustomerFeeChange record);

    List<PpfCustomerFeeChange> selectByExample(PpfCustomerFeeChangeExample example);

    PpfCustomerFeeChange selectByPrimaryKey(Integer chargeid);

    int updateByExampleSelective(@Param("record") PpfCustomerFeeChange record, @Param("example") PpfCustomerFeeChangeExample example);

    int updateByExample(@Param("record") PpfCustomerFeeChange record, @Param("example") PpfCustomerFeeChangeExample example);

    int updateByPrimaryKeySelective(PpfCustomerFeeChange record);

    int updateByPrimaryKey(PpfCustomerFeeChange record);
}