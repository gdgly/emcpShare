package com.holley.emcpshare.model.icm;

public class BuyMeterHistory {

    private String  dataTime;         // 时间（yyyy-mm-dd hh24:mi:ss）
    private String  meterNo;          // 电表编号
    private String  customerNo;       // 户号
    private double  buyEnergy;        // 购电电量
    private double  buyMoney;         // 购电金额
    private double  totalBuyEnergy;   // 总购电量
    private Integer buyCount;         // 购电次数
    private Integer type;             // 类型
    private String  account;          // 操作账号
    private double  pLimit;           // 限容功率
    private double  alarmEnergyLimit; // 报警电量
    private short   status;           // 记录状态

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getBuyEnergy() {
        return buyEnergy;
    }

    public void setBuyEnergy(double buyEnergy) {
        this.buyEnergy = buyEnergy;
    }

    public double getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(double buyMoney) {
        this.buyMoney = buyMoney;
    }

    public double getTotalBuyEnergy() {
        return totalBuyEnergy;
    }

    public void setTotalBuyEnergy(double totalBuyEnergy) {
        this.totalBuyEnergy = totalBuyEnergy;
    }

    public double getpLimit() {
        return pLimit;
    }

    public void setpLimit(double pLimit) {
        this.pLimit = pLimit;
    }

    public double getAlarmEnergyLimit() {
        return alarmEnergyLimit;
    }

    public void setAlarmEnergyLimit(double alarmEnergyLimit) {
        this.alarmEnergyLimit = alarmEnergyLimit;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

}
