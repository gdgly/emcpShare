package com.holley.emcpshare.dao;

import com.holley.emcpshare.model.IcmPointCustomer;
import com.holley.emcpshare.model.IcmPointCustomerExample;
import com.holley.emcpshare.model.IcmPointCustomerKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IcmPointCustomerMapper {
    int countByExample(IcmPointCustomerExample example);

    int deleteByExample(IcmPointCustomerExample example);

    int deleteByPrimaryKey(IcmPointCustomerKey key);

    int insert(IcmPointCustomer record);

    int insertSelective(IcmPointCustomer record);

    List<IcmPointCustomer> selectByExample(IcmPointCustomerExample example);

    IcmPointCustomer selectByPrimaryKey(IcmPointCustomerKey key);

    int updateByExampleSelective(@Param("record") IcmPointCustomer record, @Param("example") IcmPointCustomerExample example);

    int updateByExample(@Param("record") IcmPointCustomer record, @Param("example") IcmPointCustomerExample example);

    int updateByPrimaryKeySelective(IcmPointCustomer record);

    int updateByPrimaryKey(IcmPointCustomer record);
}