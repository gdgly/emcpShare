package com.holley.emcpshare.model.icm;

public class BuyElectricHistory {

    private String  customerNo;       // 户号
    private String  meterNo;          // 电表编号
    private double  meterRate;        // 电表倍率
    private double  alarmEnergyLimit; // 报警电量
    private double  pLimit;           // 限容功率
    private double  buyMoney;         // 购电金额
    private double  buyEnergy;        // 购电电量
    private double  totalBuyMoney;    // 总购电量
    private Integer buyCount;         // 购电次数
    private String  dataTime;         // 购电时间（yyyy-mm-dd hh24:mi:ss）
    private String  account;          // 操作账号
    private String  customerName;     // 户名
    private short   status;           // 记录状态

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public double getMeterRate() {
        return meterRate;
    }

    public void setMeterRate(double meterRate) {
        this.meterRate = meterRate;
    }

    public double getAlarmEnergyLimit() {
        return alarmEnergyLimit;
    }

    public void setAlarmEnergyLimit(double alarmEnergyLimit) {
        this.alarmEnergyLimit = alarmEnergyLimit;
    }

    public double getpLimit() {
        return pLimit;
    }

    public void setpLimit(double pLimit) {
        this.pLimit = pLimit;
    }

    public double getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(double buyMoney) {
        this.buyMoney = buyMoney;
    }

    public double getBuyEnergy() {
        return buyEnergy;
    }

    public void setBuyEnergy(double buyEnergy) {
        this.buyEnergy = buyEnergy;
    }

    public double getTotalBuyMoney() {
        return totalBuyMoney;
    }

    public void setTotalBuyMoney(double totalBuyMoney) {
        this.totalBuyMoney = totalBuyMoney;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

}
