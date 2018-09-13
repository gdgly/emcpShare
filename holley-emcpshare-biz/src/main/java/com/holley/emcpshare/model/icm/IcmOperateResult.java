package com.holley.emcpshare.model.icm;

public class IcmOperateResult {

    private int operateResult;// 操作结果:0为成功，<0为失败

    public int getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(int operateResult) {
        this.operateResult = operateResult;
    }

}
