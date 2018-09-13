package com.holley.emcpshare.task;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.holley.emcpshare.comenum.EnergyTypeEnum;
import com.holley.emcpshare.comenum.TarrifTypeEnum;
import com.holley.emcpshare.dao.DatBmMapper;
import com.holley.emcpshare.dao.DatPowerBmMapper;
import com.holley.emcpshare.model.DatBm;
import com.holley.emcpshare.model.DatPowerBm;
import com.holley.platform.common.util.NumberUtil;

public class CreateGJDataTask {

    @Resource
    private DatBmMapper      datBmMapper;
    @Resource
    private DatPowerBmMapper datPowerBmMapper;

    public CreateGJDataTask() {

    }

    public CreateGJDataTask(String s) {
        System.out.println(s);
    }

    public void execute() {
        Date now = new Date();
        if (GJDataConfig.powerTime.getTime() < now.getTime()) {
            // power
            if (GJDataConfig.isPointTime(GJDataConfig.powerTime)) {
                BigDecimal addData = GJDataConfig.getJFPGAddData();
                BigDecimal addJainData = NumberUtil.mul(addData, new BigDecimal("0.1"));
                BigDecimal addFengData = NumberUtil.mul(addData, new BigDecimal("0.2"));
                BigDecimal addPingData = NumberUtil.mul(addData, new BigDecimal("0.5"));
                BigDecimal addGuData = NumberUtil.sub(addData, GJDataConfig.getAddData(addJainData, addFengData, addPingData));

                GJDataConfig.powerJianBm = NumberUtil.add(GJDataConfig.powerJianBm, addJainData);
                GJDataConfig.powerFengBm = NumberUtil.add(GJDataConfig.powerFengBm, addFengData);
                GJDataConfig.powerPingBm = NumberUtil.add(GJDataConfig.powerPingBm, addPingData);
                GJDataConfig.powerGuBm = NumberUtil.add(GJDataConfig.powerGuBm, addGuData);

                System.out.println("多费率电表数据：");
                DatPowerBm powerBmBean = new DatPowerBm();
                powerBmBean.setDatatime(GJDataConfig.powerTime);
                powerBmBean.setPhasetype((short) 0);
                powerBmBean.setPointid(GJDataConfig.powerPointId);
                powerBmBean.setTarriftypeid(TarrifTypeEnum.TARRIF_ZONG.getShortValue());
                powerBmBean.setZybm(GJDataConfig.powerZongBm);
                System.out.println("总电表数据" + JSON.toJSONString(powerBmBean, SerializerFeature.WriteDateUseDateFormat));
                datPowerBmMapper.insertSelective(powerBmBean);
                powerBmBean.setTarriftypeid(TarrifTypeEnum.TARRIF_JIAN.getShortValue());
                powerBmBean.setZybm(GJDataConfig.powerJianBm);
                System.out.println("尖电表数据：" + JSON.toJSONString(powerBmBean, SerializerFeature.WriteDateUseDateFormat));
                datPowerBmMapper.insertSelective(powerBmBean);
                powerBmBean.setTarriftypeid(TarrifTypeEnum.TARRIF_FENG.getShortValue());
                powerBmBean.setZybm(GJDataConfig.powerFengBm);
                System.out.println("峰电表数据：" + JSON.toJSONString(powerBmBean, SerializerFeature.WriteDateUseDateFormat));
                datPowerBmMapper.insertSelective(powerBmBean);
                powerBmBean.setTarriftypeid(TarrifTypeEnum.TARRIF_PING.getShortValue());
                powerBmBean.setZybm(GJDataConfig.powerPingBm);
                System.out.println("平电表数据：" + JSON.toJSONString(powerBmBean, SerializerFeature.WriteDateUseDateFormat));
                datPowerBmMapper.insertSelective(powerBmBean);
                powerBmBean.setTarriftypeid(TarrifTypeEnum.TARRIF_GU.getShortValue());
                powerBmBean.setZybm(GJDataConfig.powerGuBm);
                System.out.println("谷电表数据：" + JSON.toJSONString(powerBmBean, SerializerFeature.WriteDateUseDateFormat));
                datPowerBmMapper.insertSelective(powerBmBean);
            } else {
                DatPowerBm powerBmBean = new DatPowerBm();
                powerBmBean.setDatatime(GJDataConfig.powerTime);
                powerBmBean.setPhasetype((short) 0);
                powerBmBean.setPointid(GJDataConfig.powerPointId);
                powerBmBean.setTarriftypeid(TarrifTypeEnum.TARRIF_ZONG.getShortValue());
                powerBmBean.setZybm(GJDataConfig.powerZongBm);
                System.out.println("总电表数据：" + JSON.toJSONString(powerBmBean, SerializerFeature.WriteDateUseDateFormat));
                datPowerBmMapper.insertSelective(powerBmBean);
            }
            nextPowerData();
        }

        // water
        if (GJDataConfig.waterTime.getTime() < now.getTime()) {
            DatBm waterBmBean = new DatBm();
            waterBmBean.setPointid(GJDataConfig.waterPointId);
            waterBmBean.setDataitem((short) 30);
            waterBmBean.setEnergytype(EnergyTypeEnum.WATER.getShortValue());
            waterBmBean.setBm(GJDataConfig.waterBm);
            waterBmBean.setDatatime(GJDataConfig.waterTime);
            System.out.println("水表数据：" + JSON.toJSONString(waterBmBean, SerializerFeature.WriteDateUseDateFormat));
            datBmMapper.insertSelective(waterBmBean);
            nextWaterData();
        }

        // gas小于当前时间插入保证不出现超前的数据
        if (GJDataConfig.gasTime.getTime() < now.getTime()) {
            DatBm gasBmBean = new DatBm();
            gasBmBean.setPointid(GJDataConfig.gasPointId);
            gasBmBean.setDataitem((short) 36);
            gasBmBean.setEnergytype(EnergyTypeEnum.GAS.getShortValue());
            gasBmBean.setBm(GJDataConfig.gasBm);
            gasBmBean.setDatatime(GJDataConfig.gasTime);
            System.out.println("气表数据：" + JSON.toJSONString(gasBmBean, SerializerFeature.WriteDateUseDateFormat));
            datBmMapper.insertSelective(gasBmBean);
            nextGasData();
        }

    }

    private void nextWaterData() {
        System.out.println("nextWaterData");
        BigDecimal waterRandomData = GJDataConfig.getRandomData(10);
        GJDataConfig.waterBm = NumberUtil.add(GJDataConfig.waterBm, waterRandomData);
        GJDataConfig.waterTime = GJDataConfig.nextDay(GJDataConfig.waterTime);
    }

    private void nextGasData() {
        BigDecimal gasRandomData = GJDataConfig.getRandomData(10);
        GJDataConfig.gasBm = NumberUtil.add(GJDataConfig.gasBm, gasRandomData);
        GJDataConfig.gasTime = GJDataConfig.nextDay(GJDataConfig.gasTime);
    }

    private void nextPowerData() {
        BigDecimal powerRandomData = GJDataConfig.getRandomData(10);
        GJDataConfig.powerZongBm = NumberUtil.add(GJDataConfig.powerZongBm, powerRandomData);
        GJDataConfig.powerTime = GJDataConfig.nextHour(GJDataConfig.powerTime);
    }
}
