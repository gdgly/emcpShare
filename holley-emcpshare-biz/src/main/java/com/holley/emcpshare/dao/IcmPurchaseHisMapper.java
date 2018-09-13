package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.IcmPurchaseHis;
import com.holley.emcpshare.model.IcmPurchaseHisExample;
import com.holley.emcpshare.model.IcmPurchaseHisKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IcmPurchaseHisMapper {
    int countByExample(IcmPurchaseHisExample example);

    int deleteByExample(IcmPurchaseHisExample example);

    int deleteByPrimaryKey(IcmPurchaseHisKey key);

    int insert(IcmPurchaseHis record);

    int insertSelective(IcmPurchaseHis record);

    List<IcmPurchaseHis> selectByExample(IcmPurchaseHisExample example);

    IcmPurchaseHis selectByPrimaryKey(IcmPurchaseHisKey key);

    int updateByExampleSelective(@Param("record") IcmPurchaseHis record, @Param("example") IcmPurchaseHisExample example);

    int updateByExample(@Param("record") IcmPurchaseHis record, @Param("example") IcmPurchaseHisExample example);

    int updateByPrimaryKeySelective(IcmPurchaseHis record);

    int updateByPrimaryKey(IcmPurchaseHis record);
}