package com.holley.emcpshare.model.dcs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PnCommData implements Serializable {

    private static final long   serialVersionUID = 1L;

    private int                 length           = 0;
    private List<DataItemValue> dataList;

    public PnCommData() {
        length = 0;
        dataList = new ArrayList<DataItemValue>();
    }

    public int getLength() {
        return length;
    }

    public List<DataItemValue> getDataList() {
        return dataList;
    }

    public void addPnData(DataItemValue value) {
        if (dataList == null) {
            length = 0;
            dataList = new ArrayList<DataItemValue>();
        }
        dataList.add(value);
        length++;
    }

}
