package com.holley.emcpshare.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.holley.emcpshare.comenum.EnergyTypeEnum;
import com.holley.emcpshare.comenum.FeeCutStatusEnum;
import com.holley.emcpshare.model.bank.BankSurchargeVo;
import com.holley.emcpshare.model.bank.SurchargeConfig;
import com.holley.emcpshare.service.share.BankService;

/**
 * 滞纳金计算任务
 * 
 * @author sc
 */
public class CalculationSurchargeTask {

    private final static Logger logger = Logger.getLogger(CalculationSurchargeTask.class);
    @Resource
    private BankService         bankService;

    public void execute() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("eid", SurchargeConfig.eid);
        params.put("cutStatus", FeeCutStatusEnum.FAIL.getValue());
        params.put("energyType", EnergyTypeEnum.WATER.getValue());
        params.put("cutCount", SurchargeConfig.cutCount);
        params.put("delayMonth", SurchargeConfig.delayMonth);
        List<BankSurchargeVo> list = bankService.selectCustomerFeeMonthOther(params);
        logger.info("滞纳金任务Start...");
        if (list != null && !list.isEmpty()) {
            bankService.updateAndInsertSurcharge(list);
        }
        logger.info("滞纳金任务End...");
    }

}
