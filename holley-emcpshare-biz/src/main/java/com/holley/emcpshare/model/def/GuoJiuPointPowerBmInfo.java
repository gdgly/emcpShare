package com.holley.emcpshare.model.def;

import java.util.ArrayList;
import java.util.List;

/**
 * 国久接口项目
 * 
 * @author lenovo
 */
public class GuoJiuPointPowerBmInfo {

    private String          address;                                       // 地址
    private String          name;                                          // 表名称
    private String          pointId;                                       // 表编码
    List<GuoJiuPowerBmInfo> powerData = new ArrayList<GuoJiuPowerBmInfo>();

    public GuoJiuPointPowerBmInfo(String address, String name, String pointId) {
        this.address = address;
        this.name = name;
        this.pointId = pointId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public List<GuoJiuPowerBmInfo> getPowerData() {
        return powerData;
    }

    public void setPowerData(List<GuoJiuPowerBmInfo> powerData) {
        this.powerData = powerData;
    }

}
