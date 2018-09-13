package com.holley.emcpshare.model.icm;

import java.util.List;

public class MeterListResult {

    private List<MeterParamVO> meterList;
    private Paging             paging;

    public List<MeterParamVO> getMeterList() {
        return meterList;
    }

    public void setMeterList(List<MeterParamVO> meterList) {
        this.meterList = meterList;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

}
