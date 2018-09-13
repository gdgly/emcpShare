package com.holley.emcpshare.model.icm;

/**
 * 用户登录结果
 * 
 * @author Administrator
 */
public class IcmAccountLoginInfo {

    private int    validateResult;// 验证结果
    private int    enterpriseId;  // 企业编码
    private String enterpriseName;// 企业名称

    public int getValidateResult() {
        return validateResult;
    }

    public void setValidateResult(int validateResult) {
        this.validateResult = validateResult;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

}
