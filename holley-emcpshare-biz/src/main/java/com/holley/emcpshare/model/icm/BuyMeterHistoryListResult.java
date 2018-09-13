package com.holley.emcpshare.model.icm;

import java.util.List;

public class BuyMeterHistoryListResult {

    private List<BuyMeterHistory> historyList;
    private Paging                paging;

    public List<BuyMeterHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<BuyMeterHistory> historyList) {
        this.historyList = historyList;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

}
