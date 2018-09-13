package com.holley.emcpshare.model.icm;

public class MeterParamVO {

    private int     meterId;           // 电表id
    private String  meterName;         // 电表名称
    private String  meterNo;           // 电表编号
    private int     ownerId;           // 所属单位编码
    private String  ownerName;         // 所属单位名称
    private int     ownerType;         // 所属单位类型
    private String  customerNo;        // 户号
    private String  customerName;      // 户名
    private double  alarmEnergyLimit;  // 报警电量
    private double  creditEnergyLimit; // 赊欠电量
    private double  pLimit;            // 限容功率
    private Integer status;            // 状态
    private double  meterRate;         // 电表倍率
    private double  price;             // 单价

    public int getMeterId() {
        return meterId;
    }

    public void setMeterId(int meterId) {
        this.meterId = meterId;
    }

    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(int ownerType) {
        this.ownerType = ownerType;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public double getAlarmEnergyLimit() {
        return alarmEnergyLimit;
    }

    public void setAlarmEnergyLimit(double alarmEnergyLimit) {
        this.alarmEnergyLimit = alarmEnergyLimit;
    }

    public double getCreditEnergyLimit() {
        return creditEnergyLimit;
    }

    public void setCreditEnergyLimit(double creditEnergyLimit) {
        this.creditEnergyLimit = creditEnergyLimit;
    }

    public double getpLimit() {
        return pLimit;
    }

    public void setpLimit(double pLimit) {
        this.pLimit = pLimit;
    }

    public double getMeterRate() {
        return meterRate;
    }

    public void setMeterRate(double meterRate) {
        this.meterRate = meterRate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
