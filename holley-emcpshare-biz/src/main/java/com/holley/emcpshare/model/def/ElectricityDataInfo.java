package com.holley.emcpshare.model.def;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author open3
 */
public class ElectricityDataInfo {

    @JSONField(ordinal = 1)
    private String     communityName;   // 小区名字
    @JSONField(ordinal = 2)
    private String     buildingNo;      // 幢号
    @JSONField(ordinal = 3)
    private String     unitNo;          // 单元
    @JSONField(ordinal = 4)
    private String     floorNo;         // 楼层
    @JSONField(ordinal = 5)
    private String     roomNo;          // 房间号
    @JSONField(ordinal = 6)
    private String     address;         // 地址信息
    @JSONField(ordinal = 7)
    private String     pointId;         // 设备编码
    @JSONField(ordinal = 8)
    private BigDecimal reading;         // 表码
    @JSONField(ordinal = 9)
    private String     meterReadingTime; // 数据时间yyyy-MM-dd HH:mm:ss
    @JSONField(ordinal = 10)
    private String     operatingTime;   // 数据时间yyyy-MM-dd HH:mm:ss

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getReading() {
        return reading;
    }

    public void setReading(BigDecimal reading) {
        this.reading = reading;
    }

    public String getMeterReadingTime() {
        return meterReadingTime;
    }

    public void setMeterReadingTime(String meterReadingTime) {
        this.meterReadingTime = meterReadingTime;
    }

    public String getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(String operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

}
