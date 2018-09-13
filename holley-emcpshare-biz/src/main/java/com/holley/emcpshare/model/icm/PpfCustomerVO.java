package com.holley.emcpshare.model.icm;

public class PpfCustomerVO {

    private Integer customerId;  // 用户编码
    private String  Hh;          // ppf_户号
    private String  customerNo;  // icm_户号
    private String  customerName;// 户名
    private int     customerType;// 用户类型
    private String  linkman;     // 联系人
    private String  phone;       // 手机号码
    private String  status;      // 状态

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getHh() {
        return Hh;
    }

    public void setHh(String hh) {
        Hh = hh;
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

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
