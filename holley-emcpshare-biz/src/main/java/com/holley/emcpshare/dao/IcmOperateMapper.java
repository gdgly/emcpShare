package com.holley.emcpshare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.emcpshare.model.IcmOperate;
import com.holley.emcpshare.model.IcmOperateExample;
import com.holley.emcpshare.model.IcmOperateKey;
import com.holley.emcpshare.model.icm.BuyElectricHistory;
import com.holley.emcpshare.model.icm.BuyMeterHistory;

public interface IcmOperateMapper {

    int countByExample(IcmOperateExample example);

    int deleteByExample(IcmOperateExample example);

    int deleteByPrimaryKey(IcmOperateKey key);

    int insert(IcmOperate record);

    int insertSelective(IcmOperate record);

    List<IcmOperate> selectByExample(IcmOperateExample example);

    IcmOperate selectByPrimaryKey(IcmOperateKey key);

    int updateByExampleSelective(@Param("record") IcmOperate record, @Param("example") IcmOperateExample example);

    int updateByExample(@Param("record") IcmOperate record, @Param("example") IcmOperateExample example);

    int updateByPrimaryKeySelective(IcmOperate record);

    int updateByPrimaryKey(IcmOperate record);

    // 根据CustomerNo查记录
    List<BuyElectricHistory> selectBuyHistoryByPage(Map<String, Object> params);

    // 根据MeterNo查记录
    List<BuyMeterHistory> selectBuyPurchaseHistoryByPage(Map<String, Object> params);
}
