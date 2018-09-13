package com.holley.emcpshare.model.def;

import java.io.Serializable;

import com.holley.emcpshare.comenum.RetTypeEnum;
import com.holley.platform.common.util.StringUtil;

/**
 * 通用数据调用结果返回bean
 * 
 * @author sc
 */
public class ShareResultBean implements Serializable {

    private static final long serialVersionUID = -8974675040908912236L;
    private int               ret              = 0;                    // 返回参数编码
    private String            msg;                                     // 返回信息
    private Object            data;                                    // 数据
    private String            sig;                                     // 参数签名
    // private String timeStamp; // 请求接口时间yyyyMMddHHmmss
    private String            operatorId;                              // 运营商Id

    // private String seq; // 自增序列

    public ShareResultBean() {
        super();
    }

    // public ResultBean(Date date) {
    // long t = date.getTime();
    // this.timeStamp = DateUtil.DateToLong14Str(date);
    // if (Globals.TIME_STTEMP == 0) {
    // Globals.TIME_STTEMP = t;
    // this.seq = String.format("%04d", 1);
    // } else {
    // if (t - Globals.TIME_STTEMP <= 999) {
    // this.seq = String.format("%04d", ++Globals.COUNT_TIME);
    // }
    // }
    // }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        if (StringUtil.isNotEmpty(msg)) {
            return msg;
        }
        return RetTypeEnum.getText(ret);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() throws Exception {
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

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

}
