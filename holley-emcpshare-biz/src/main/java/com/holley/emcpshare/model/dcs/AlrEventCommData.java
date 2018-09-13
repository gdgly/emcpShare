package com.holley.emcpshare.model.dcs;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class AlrEventCommData implements Serializable {

    private static final long   serialVersionUID = 1L;

    private String              alr;                  // 告警编码
    private String              pn;                   // 测量点号
    private String              datetime;             // 告警事件
    private List<DataItemValue> daList;               // 告警参数内容

    public String getAlr() {
        return alr;
    }

    public void addDataItem(DataItemValue v) {
        if (daList == null) {
            daList = new LinkedList<DataItemValue>();
        }
        daList.add(v);
    }

    public void setAlr(String alr) {
        this.alr = alr;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public List<DataItemValue> getDaList() {
        return daList;
    }

    public void setDaList(List<DataItemValue> daList) {
        this.daList = daList;
    }

}
