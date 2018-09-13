package com.holley.emcpshare.model;

import java.util.Date;

public class PpfCustomer {
    private Integer customerid;

    private String hm;

    private String hh;

    private Short type;

    private String linkman;

    private String phone;

    private String address;

    private Short demandprop;

    private String voltageclass;

    private Date createtime;

    private String cardno;

    private Integer eid;

    private Short status;

    private String creator;

    private Date updatetime;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getHm() {
        return hm;
    }

    public void setHm(String hm) {
        this.hm = hm == null ? null : hm.trim();
    }

    public String getHh() {
        return hh;
    }

    public void setHh(String hh) {
        this.hh = hh == null ? null : hh.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Short getDemandprop() {
        return demandprop;
    }

    public void setDemandprop(Short demandprop) {
        this.demandprop = demandprop;
    }

    public String getVoltageclass() {
        return voltageclass;
    }

    public void setVoltageclass(String voltageclass) {
        this.voltageclass = voltageclass == null ? null : voltageclass.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}