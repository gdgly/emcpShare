package com.holley.emcpshare.model.icm;

public class MeterVO {

    private String  meterNo;           // 电表编号
    private String  meterName;         // 电表名称
    private String  factoryNo;         // 出厂编号
    private double  alarmEnergyLimit;  // 报警电量
    private double  hoardEnergyLimit;  // 囤积电量
    private double  creditEnergyLimit; // 赊欠限量
    private double  pLimit;            // 限容功率
    private String  registerNo;        // 系统注册编码
    private String  startTime;         // 开户时间
    private String  customerNo;        // 用户编码
    private Integer cardCount;         // 卡购电次数
    private Integer buyCount;          // 购电次数
    private double  surplusEnergy;     // 剩余电量
    private double  overdrawEnergy;    // 透支电量
    private double  totalBuyEnergy;    // 累计购电量
    private double  meterRate;         // 倍率
    private String  priceName;         // 电价名称
    private Integer priceType;         // 电价类型
    private String  priceTypeName;     // 电价类型名称
    private double  price;             // 电价
    private String  customerName;      // 户名

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }

    public double getAlarmEnergyLimit() {
        return alarmEnergyLimit;
    }

    public void setAlarmEnergyLimit(double alarmEnergyLimit) {
        this.alarmEnergyLimit = alarmEnergyLimit;
    }

    public double getHoardEnergyLimit() {
        return hoardEnergyLimit;
    }

    public void setHoardEnergyLimit(double hoardEnergyLimit) {
        this.hoardEnergyLimit = hoardEnergyLimit;
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

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Integer getCardCount() {
        return cardCount;
    }

    public void setCardCount(Integer cardCount) {
        this.cardCount = cardCount;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public double getSurplusEnergy() {
        return surplusEnergy;
    }

    public void setSurplusEnergy(double surplusEnergy) {
        this.surplusEnergy = surplusEnergy;
    }

    public double getOverdrawEnergy() {
        return overdrawEnergy;
    }

    public void setOverdrawEnergy(double overdrawEnergy) {
        this.overdrawEnergy = overdrawEnergy;
    }

    public double getTotalBuyEnergy() {
        return totalBuyEnergy;
    }

    public void setTotalBuyEnergy(double totalBuyEnergy) {
        this.totalBuyEnergy = totalBuyEnergy;
    }

    public double getMeterRate() {
        return meterRate;
    }

    public void setMeterRate(double meterRate) {
        this.meterRate = meterRate;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public String getPriceTypeName() {
        return priceTypeName;
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
