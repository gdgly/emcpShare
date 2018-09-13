package com.holley.emcpshare.model.def;

import java.util.List;

/**
 * 电表历史数据列表
 * 
 * @author sc
 */
public class HistoryElectricityInfoBase {

    private List<HistoryElectricityInfo> historyElectricityInofs;

    public List<HistoryElectricityInfo> getHistoryElectricityInofs() {
        return historyElectricityInofs;
    }

    public void setHistoryElectricityInofs(List<HistoryElectricityInfo> historyElectricityInofs) {
        this.historyElectricityInofs = historyElectricityInofs;
    }

}
