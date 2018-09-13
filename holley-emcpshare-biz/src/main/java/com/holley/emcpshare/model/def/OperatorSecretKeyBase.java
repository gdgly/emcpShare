package com.holley.emcpshare.model.def;

/**
 * Description: tonken获取
 *
 * @author shen.cheng@holley.cn
 */
public class OperatorSecretKeyBase {

    private String  operatorId;        // 运营商机构ID
    private Integer succStat;          // 0：成功1：失败
    private String  accessToken;       // 唯一token凭证
    private Integer tokenAvailableTime; // 凭证有效期秒
    private Integer failReason;        // 失败原因0：无1：无此运营商2.密钥错误

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getSuccStat() {
        return succStat;
    }

    public void setSuccStat(Integer succStat) {
        this.succStat = succStat;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getTokenAvailableTime() {
        return tokenAvailableTime;
    }

    public void setTokenAvailableTime(Integer tokenAvailableTime) {
        this.tokenAvailableTime = tokenAvailableTime;
    }

    public Integer getFailReason() {
        return failReason;
    }

    public void setFailReason(Integer failReason) {
        this.failReason = failReason;
    }

}
