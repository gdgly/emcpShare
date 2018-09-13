package com.holley.emcpshare.model.dcs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LowRtuCommData {

    private String                rtuAddr;
    private int                   length;
    private int                   total;              // 帧总数
    private int                   current;            // 当前帧序号
    private List<MeterCommData>   meterCommDataList;
    private List<LowPointALRData> lowPointALRDataList;
    private boolean               dataError;
    private Map<String, String>   paraMap;            // 集中器参数
    private String                result;             // 结果信息

    public LowRtuCommData() {
        meterCommDataList = new LinkedList<MeterCommData>();
        paraMap = new HashMap<String, String>();
        length = 0;
    }

    public String getRtuAddr() {
        return rtuAddr;
    }

    public void setRtuAddr(String rtuAddr) {
        this.rtuAddr = rtuAddr;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<MeterCommData> getMeterCommDataList() {
        return meterCommDataList;
    }

    public void setMeterCommDataList(List<MeterCommData> meterCommDataList) {
        this.meterCommDataList = meterCommDataList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean isDataError() {
        return dataError;
    }

    public void setDataError(boolean dataError) {
        this.dataError = dataError;
    }

    public List<LowPointALRData> getLowPointALRDataList() {
        return lowPointALRDataList;
    }

    public void setLowPointALRDataList(List<LowPointALRData> lowPointALRDataList) {
        this.lowPointALRDataList = lowPointALRDataList;
    }

    public Map<String, String> getParaMap() {
        return paraMap;
    }

    public void setParaMap(Map<String, String> paraMap) {
        this.paraMap = paraMap;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
