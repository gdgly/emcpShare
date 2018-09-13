package com.holley.emcpshare.model.icm;

import java.util.List;

public class BuyElectricHistoryListResult {

    private List<BuyElectricHistory> historyList;
    private Paging                   paging;

    public List<BuyElectricHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<BuyElectricHistory> historyList) {
        this.historyList = historyList;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

}
