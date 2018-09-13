package com.holley.emcpshare.model.icm;

import java.util.List;

public class CustomerListResult {

    private List<PpfCustomerVO> customerList;
    private Paging              paging;

    public List<PpfCustomerVO> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<PpfCustomerVO> customerList) {
        this.customerList = customerList;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

}
