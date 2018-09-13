package com.holley.emcpshare.model.common;

public class Paging {

    private int pageNo;     // 页码
    private int pageSize;   // 每页显示多少条
    private int recordCount;// 总记录数

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

}
