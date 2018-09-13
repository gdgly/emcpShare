package com.holley.emcpshare.model.def;

import java.io.Serializable;
import java.util.Date;

import com.holley.emcpshare.common.util.ShareGloblas;
import com.holley.platform.common.util.DateUtil;

/**
 * 通用数据bean
 * 
 * @author sc
 */
public class QueryBean{
    private Object            data;                                    // 数据
    private String            sig;                                     // 参数签名
    private String            timeStamp;                               // 请求接口时间yyyyMMddHHmmss
    private String            operatorId;                              // 运营商Id
    private String            seq;                                     // 自增序列

    public QueryBean() {
        super();
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }



}
