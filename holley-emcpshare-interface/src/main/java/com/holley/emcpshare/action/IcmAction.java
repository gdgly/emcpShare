package com.holley.emcpshare.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.holley.emcpshare.base.action.BaseAction;
import com.holley.emcpshare.comenum.CheckAccountFailReasonTypeEnum;
import com.holley.emcpshare.comenum.PriceTypeEnum;
import com.holley.emcpshare.comenum.RetTypeEnum;
import com.holley.emcpshare.icmenum.IcmOperateResultTypeEnum;
import com.holley.emcpshare.model.IcmParam;
import com.holley.emcpshare.model.SysAccount;
import com.holley.emcpshare.model.SysAccountExample;
import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.model.common.SysAccountDetailVO;
import com.holley.emcpshare.model.def.ShareResultBean;
import com.holley.emcpshare.model.icm.BuyElectricHistory;
import com.holley.emcpshare.model.icm.BuyElectricHistoryListResult;
import com.holley.emcpshare.model.icm.BuyMeterHistory;
import com.holley.emcpshare.model.icm.BuyMeterHistoryListResult;
import com.holley.emcpshare.model.icm.CustomerListResult;
import com.holley.emcpshare.model.icm.EnergyUnitTree;
import com.holley.emcpshare.model.icm.IcmAccountLoginInfo;
import com.holley.emcpshare.model.icm.IcmOperateResult;
import com.holley.emcpshare.model.icm.MeterListResult;
import com.holley.emcpshare.model.icm.MeterParamVO;
import com.holley.emcpshare.model.icm.MeterVO;
import com.holley.emcpshare.model.icm.Paging;
import com.holley.emcpshare.model.icm.PpfCustomerVO;
import com.holley.emcpshare.model.icm.PpfPriceRuleVO;
import com.holley.emcpshare.service.share.IcmService;
import com.holley.platform.common.constants.AccountTypeEnum;
import com.holley.platform.common.constants.Globals;
import com.holley.platform.common.dataobject.Page;
import com.holley.platform.common.security.RijndaelUtil;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;
import com.holley.platform.common.web.util.Validator;

import net.sf.json.JSONObject;

/**
 * 卡表操作
 */
public class IcmAction extends BaseAction {

    @Resource
    private IcmService         icmService;
    private ShareResultBean    resultBean      = new ShareResultBean();
    protected static final int PAGESIZE        = 20;                   // 默认每页显示多少条
    private int                RET_CODE_FAILED = -1;                   // 参数编码为-1，取msg信息查看错误原因

    /**
     * 用户登录
     * 
     * @return
     * @throws Exception
     */
    public String login() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        String account = getDataString(data, "account");// 账号
        String password = getDataString(data, "password");// 密码
        IcmAccountLoginInfo accountinfo = new IcmAccountLoginInfo();
        if (StringUtil.isEmpty(account)) {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("账号不不能为空!");
            return SUCCESS;
        }
        if (password == null || "".equals(password) || !Validator.isPassword(password)) {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("请正确填写[6-16]位数字字母组合的密码!");
            return SUCCESS;
        }
        SysAccountExample sysEmp = new SysAccountExample();
        SysAccountExample.Criteria sysCr = sysEmp.createCriteria();
        sysCr.andAccountEqualTo(account);
        List<SysAccount> accountList = icmService.selectSysAccountByExample(sysEmp);
        if (accountList == null || accountList.size() <= 0) {
            accountinfo.setValidateResult(CheckAccountFailReasonTypeEnum.ACCOUNT_NOT_EXIST.getValue());
            resultBean.setData(accountinfo);
            return SUCCESS;
        }
        SysAccount sysAccount = accountList.get(0);
        AccountTypeEnum accountType = AccountTypeEnum.getEnmuByValue(sysAccount.getType());
        if (!accountType.equals(AccountTypeEnum.ENTERPRISE) && !accountType.equals(AccountTypeEnum.OPERATOR)) {
            accountinfo.setValidateResult(CheckAccountFailReasonTypeEnum.ACCOUNT_ILLEGAL.getValue());
            resultBean.setData(accountinfo);
            return SUCCESS;
        }
        if (!sysAccount.getDepartmentid().equals(sk.getEid())) {
            accountinfo.setValidateResult(CheckAccountFailReasonTypeEnum.ACCOUNT_ILLEGAL.getValue());
            resultBean.setData(accountinfo);
            return SUCCESS;
        }
        if (!RijndaelUtil.encodePassword(password).equals(sysAccount.getPassword())) {
            accountinfo.setValidateResult(CheckAccountFailReasonTypeEnum.PASSWORD_ERROR.getValue());
            resultBean.setData(accountinfo);
            return SUCCESS;
        }

        SysAccountDetailVO accountDetailVO = icmService.selectAccountInfoByAccount(account);
        accountinfo.setEnterpriseId(accountDetailVO.getDepartmentid());
        accountinfo.setEnterpriseName(accountDetailVO.getEnterpriseName());
        accountinfo.setValidateResult(CheckAccountFailReasonTypeEnum.SUCCESS.getValue());
        resultBean.setData(accountinfo);
        return SUCCESS;
    }

    /**
     * 分页查询最近购电记录
     * 
     * @return
     * @throws Exception
     */
    public String history() throws Exception {
        JSONObject data = analyzeJSONObject();
        String enterpriseId = getDataString(data, "enterpriseId");// 企业编码
        String customerNo = getDataString(data, "customerNo");// 户号
        int pageNo = getDataInt(data, "pageNo");// 页码
        int pageSize = getDataInt(data, "pageSize");// 每页显示多少条
        pageSize = pageSize == 0 ? PAGESIZE : pageSize;
        if (StringUtil.isNotDigits(customerNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("户号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(enterpriseId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("企业编码" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        String customer_no = StringUtil.AddjustLength(customerNo, 10, "0");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("enterpriseId", Integer.valueOf(enterpriseId));
        params.put("customer_no", customer_no);
        Page page = this.returnPage(pageNo, pageSize);
        params.put(Globals.PAGE, page);
        List<BuyElectricHistory> list = icmService.selectBuyHistoryByPage(params);
        Paging paging = new Paging();
        paging.setPageNo(Integer.valueOf(pageNo));
        paging.setPageSize(Integer.valueOf(pageSize));
        paging.setRecordCount(page.getTotalProperty());
        BuyElectricHistoryListResult result = new BuyElectricHistoryListResult();
        result.setHistoryList(list);
        result.setPaging(paging);
        resultBean.setData(result);
        return SUCCESS;
    }

    /**
     * 分页查询电表的购电记录
     * 
     * @return
     * @throws Exception
     */
    public String purchaseHistory() throws Exception {
        JSONObject data = analyzeJSONObject();
        String enterpriseId = getDataString(data, "enterpriseId");// 企业编码
        String meterNo = getDataString(data, "meterNo");// 电表编号
        int pageNo = getDataInt(data, "pageNo");// 页码
        int pageSize = getDataInt(data, "pageSize");// 每页显示多少条
        pageSize = pageSize == 0 ? PAGESIZE : pageSize;
        if (StringUtil.isNotDigits(meterNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表编号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(enterpriseId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("企业编码" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        String meter_no = StringUtil.AddjustLength(meterNo, 10, "0");

        // 查询开户时间
        List<IcmParam> ipList = icmService.selectIcmParamByExample(meter_no);
        IcmParam icmParam = ipList.get(0);
        if (ipList == null || ipList.size() == 0 || icmParam == null || icmParam.getStartTime() == null) {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("该表未开户!");
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("enterpriseId", Integer.valueOf(enterpriseId));
        params.put("meterNo", meter_no);
        params.put("starttime", DateUtil.DateToLongStr(icmParam.getStartTime()));
        Page page = this.returnPage(pageNo, pageSize);
        params.put(Globals.PAGE, page);
        List<BuyMeterHistory> list = icmService.selectBuyPurchaseHistoryByPage(params);
        Paging paging = new Paging();
        paging.setPageNo(Integer.valueOf(pageNo));
        paging.setPageSize(Integer.valueOf(pageSize));
        paging.setRecordCount(page.getTotalProperty());
        BuyMeterHistoryListResult result = new BuyMeterHistoryListResult();
        result.setHistoryList(list);
        result.setPaging(paging);
        resultBean.setData(result);
        return SUCCESS;
    }

    /**
     * 制作预置卡 * @return
     * 
     * @throws Exception
     */
    public String makePresetCard() throws Exception {
        JSONObject data = analyzeJSONObject();
        String meterNo = getDataString(data, "meterNo");// 电表编号
        String presetEnergy = getDataString(data, "presetEnergy");// 预置电量
        String alarmEnergyLimit = getDataString(data, "alarmEnergyLimit");// 报警电量
        String account = getDataString(data, "account");// 账号
        String creditEnergyLimit = getDataString(data, "creditEnergyLimit");// 赊欠电量
        String pLimit = getDataString(data, "pLimit");// 限容功率
        String meterRate = getDataString(data, "meterRate");// 倍率
        String hoardEnergyLimit = getDataString(data, "hoardEnergyLimit");// 囤积限量
        if (StringUtil.isNotDigits(meterNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表编号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(presetEnergy)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("预置电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(alarmEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("报警电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(creditEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg(" 赊欠电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(pLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("限容功率" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(meterRate)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("倍率" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(hoardEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("囤积限量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isEmpty(account)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("账号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }

        boolean result = icmService.makePresetCard(meterNo, presetEnergy, alarmEnergyLimit, account, creditEnergyLimit, pLimit, meterRate, hoardEnergyLimit);
        IcmOperateResult operateResult = new IcmOperateResult();
        operateResult.setOperateResult(result ? IcmOperateResultTypeEnum.SUCCESS.getValue() : IcmOperateResultTypeEnum.FAIL.getValue());
        resultBean.setData(operateResult);
        return SUCCESS;
    }

    /**
     * 开户
     * 
     * @return
     * @throws Exception
     */
    public String openAccount() throws Exception {
        JSONObject data = analyzeJSONObject();
        String customerId = getDataString(data, "customerId");// 客户编码
        String customerNo = getDataString(data, "customerNo");// 户号
        String meterNo = getDataString(data, "meterNo");// 电表编号
        String buyEnergy = getDataString(data, "buyEnergy");// 购电电量
        String buyMoney = getDataString(data, "buyMoney");// 购电金额
        String alarmEnergyLimit = getDataString(data, "alarmEnergyLimit");// 报警电量
        String pLimit = getDataString(data, "pLimit");// 限容功率
        String buyCount = getDataString(data, "buyCount");// 购电次数
        String account = getDataString(data, "account");// 操作账号
        String writeCardTime = getDataString(data, "writeCardTime");// 写卡时间(yyyy-mm-dd hh24:mi:ss)
        String rate = getDataString(data, "rate");// 电表倍率
        String creditEnergyLimit = getDataString(data, "creditEnergyLimit");// 赊欠限量
        String hoardEnergyLimit = getDataString(data, "hoardEnergyLimit");// 囤积电量

        if (StringUtil.isNotNumber(buyEnergy)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(buyMoney)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电金额" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(alarmEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("报警电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(pLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("限容功率" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(rate)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表倍率" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(creditEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("赊欠限量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(hoardEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("囤积电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(customerId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("客户编码" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(customerNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("户号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(meterNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表编号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(buyCount)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电次数" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isEmpty(account)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("操作账号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        String customer_no = StringUtil.AddjustLength(customerNo, 10, "0");
        String meter_no = StringUtil.AddjustLength(meterNo, 10, "0");

        PpfPriceRuleVO ppfPriceRuleVO = icmService.selectPriceByPointid(Integer.valueOf(meterNo));
        if (ppfPriceRuleVO.getValue1() == null) {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("无电价!");
            return SUCCESS;
        }
        Double price = Double.valueOf(ppfPriceRuleVO.getValue1().toString());
        if (checkBuymoneyAndBuyenergy(Double.valueOf(buyEnergy), Double.valueOf(buyMoney), price)) {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("购电金额计算有误!");
        }
        IcmOperateResultTypeEnum result = icmService.openAccount(customerId, customer_no, meter_no, buyEnergy, buyMoney, alarmEnergyLimit, pLimit, buyCount, account, writeCardTime,
                                                                 rate, creditEnergyLimit, hoardEnergyLimit);
        IcmOperateResult operateResult = new IcmOperateResult();
        operateResult.setOperateResult(result.getValue());
        resultBean.setData(operateResult);
        return SUCCESS;
    }

    /**
     * 补购电卡
     * 
     * @return
     * @throws Exception
     */
    public String replaceCard() throws Exception {
        JSONObject data = analyzeJSONObject();
        String meterNo = getDataString(data, "meterNo");// 电表编号
        String customerNo = getDataString(data, "customerNo");// 户号
        String buyEnergy = getDataString(data, "buyEnergy");// 购电电量
        String buyMoney = getDataString(data, "buyMoney");// 购电金额
        String alarmEnergyLimit = getDataString(data, "alarmEnergyLimit");// 报警电量
        String pLimit = getDataString(data, "pLimit");// 限容功率
        String account = getDataString(data, "account");// 操作账号
        String writeCardTime = getDataString(data, "writeCardTime");// 写卡时间(yyyy-mm-dd hh24:mi:ss)
        String buyCount = getDataString(data, "buyCount");// 购电次数
        String rate = getDataString(data, "rate");// 电表倍率
        String creditEnergyLimit = getDataString(data, "creditEnergyLimit");// 赊欠限量
        String hoardEnergyLimit = getDataString(data, "hoardEnergyLimit");// 囤积电量
        if (StringUtil.isNotNumber(buyEnergy)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(buyMoney)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电金额" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(alarmEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("报警电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(pLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("限容功率" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(rate)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表倍率" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(creditEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("赊欠限量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(hoardEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("囤积电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(customerNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("户号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(meterNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表编号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(buyCount)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电次数" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isEmpty(account)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        String customer_no = StringUtil.AddjustLength(customerNo, 10, "0");
        String meter_no = StringUtil.AddjustLength(meterNo, 10, "0");

        PpfPriceRuleVO ppfPriceRuleVO = icmService.selectPriceByPointid(Integer.valueOf(meterNo));
        if (ppfPriceRuleVO.getValue1() == null) {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("该计量点没有设置电价!");
            return SUCCESS;
        }
        Double price = Double.valueOf(ppfPriceRuleVO.getValue1().toString());
        if (checkBuymoneyAndBuyenergy(Double.valueOf(buyEnergy), Double.valueOf(buyMoney), price)) {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("购电金额计算有误!");
            return SUCCESS;
        }
        boolean result = icmService.replaceCard(meter_no, customer_no, buyEnergy, buyMoney, alarmEnergyLimit, pLimit, account, writeCardTime, buyCount, rate, creditEnergyLimit,
                                                hoardEnergyLimit);
        IcmOperateResult operateResult = new IcmOperateResult();
        operateResult.setOperateResult(result ? IcmOperateResultTypeEnum.SUCCESS.getValue() : IcmOperateResultTypeEnum.FAIL.getValue());
        resultBean.setData(operateResult);
        return SUCCESS;
    }

    /**
     * 读卡返写
     * 
     * @return
     * @throws Exception
     */
    public String addPurchaseHistory() throws Exception {
        JSONObject data = analyzeJSONObject();
        String meterNo = getDataString(data, "meterNo");// 电表编号
        String totalBuyEnergy = getDataString(data, "totalBuyEnergy");// 总购电量
        String buyCount = getDataString(data, "buyCount");// 购电次数
        String surplusEnergy = getDataString(data, "surplusEnergy");// 剩余电量
        String overdrawEnergy = getDataString(data, "overdrawEnergy");// 透支电量
        String writeCardTime = getDataString(data, "writeCardTime");// 写卡时间(yyyy-mm-dd hh24:mi:ss)
        if (StringUtil.isNotNumber(totalBuyEnergy)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("总购电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(surplusEnergy)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("剩余电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(overdrawEnergy)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("透支电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(meterNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表编号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(buyCount)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电次数" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        String meter_no = StringUtil.AddjustLength(meterNo, 10, "0");

        boolean result = icmService.addPurchaseHistory(meter_no, totalBuyEnergy, buyCount, surplusEnergy, overdrawEnergy, writeCardTime);
        IcmOperateResult operateResult = new IcmOperateResult();
        operateResult.setOperateResult(result ? IcmOperateResultTypeEnum.SUCCESS.getValue() : IcmOperateResultTypeEnum.FAIL.getValue());
        resultBean.setData(operateResult);
        return SUCCESS;
    }

    /**
     * 购电
     * 
     * @return
     * @throws Exception
     */
    public String buyEnergy() throws Exception {
        JSONObject data = analyzeJSONObject();
        String meterNo = getDataString(data, "meterNo");// 电表编号
        String customerNo = getDataString(data, "customerNo");// 户号
        String buyEnergy = getDataString(data, "buyEnergy");// 购电电量
        String buyMoney = getDataString(data, "buyMoney");// 购电金额
        String alarmEnergyLimit = getDataString(data, "alarmEnergyLimit");// 报警电量
        String pLimit = getDataString(data, "pLimit");// 限容功率
        String account = getDataString(data, "account");// 操作账号
        String writeCardTime = getDataString(data, "writeCardTime");// 写卡时间(yyyy-mm-dd hh24:mi:ss)
        String buyCount = getDataString(data, "buyCount");// 购电次数
        String rate = getDataString(data, "rate");// 电表倍率
        String creditEnergyLimit = getDataString(data, "creditEnergyLimit");// 赊欠限量
        String hoardEnergyLimit = getDataString(data, "hoardEnergyLimit");// 囤积电量
        if (StringUtil.isNotNumber(buyEnergy)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(buyMoney)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电金额" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(alarmEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("报警电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(pLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("限容功率" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(rate)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表倍率" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(creditEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("赊欠限量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(hoardEnergyLimit)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("囤积电量" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(customerNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("户号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(meterNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表编号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotNumber(buyCount)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("购电次数" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isEmpty(account)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("操作账号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        String customer_no = StringUtil.AddjustLength(customerNo, 10, "0");
        String meter_no = StringUtil.AddjustLength(meterNo, 10, "0");

        PpfPriceRuleVO ppfPriceRuleVO = icmService.selectPriceByPointid(Integer.valueOf(meterNo));
        if (ppfPriceRuleVO.getValue1() == null) {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("无电价!");
            return SUCCESS;
        }
        Double price = Double.valueOf(ppfPriceRuleVO.getValue1().toString());
        if (checkBuymoneyAndBuyenergy(Double.valueOf(buyEnergy), Double.valueOf(buyMoney), price)) {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("购电金额计算有误!");
        }
        boolean result = icmService.buyEnergy(meter_no, customer_no, buyEnergy, buyMoney, alarmEnergyLimit, pLimit, account, writeCardTime, buyCount, rate, creditEnergyLimit,
                                              hoardEnergyLimit);
        IcmOperateResult operateResult = new IcmOperateResult();
        operateResult.setOperateResult(result ? IcmOperateResultTypeEnum.SUCCESS.getValue() : IcmOperateResultTypeEnum.FAIL.getValue());
        resultBean.setData(operateResult);
        return SUCCESS;
    }

    /**
     * 分页查询用户信息
     * 
     * @return
     * @throws Exception
     */
    public String customerList() throws Exception {
        JSONObject data = analyzeJSONObject();
        String enterpriseId = getDataString(data, "enterpriseId");// 企业编码
        String customerName = getDataString(data, "customerName");// 用户名称
        String mobile = getDataString(data, "mobile");// 手机号码
        int pageNo = getDataInt(data, "pageNo");// 页码
        int pageSize = getDataInt(data, "pageSize");// 每页显示多少条
        pageSize = pageSize == 0 ? PAGESIZE : pageSize;
        if (StringUtil.isNotDigits(enterpriseId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("企业编码" + RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("enterpriseId", Integer.valueOf(enterpriseId));
        if (StringUtil.isNotEmpty(customerName)) {
            params.put("customerName", customerName);
        }
        if (StringUtil.isNotEmpty(mobile)) {
            params.put("mobile", mobile);
        }
        Page page = this.returnPage(pageNo, pageSize);
        params.put(Globals.PAGE, page);
        List<PpfCustomerVO> list = icmService.selectCustomerByPage(params);
        Paging paging = new Paging();
        paging.setPageNo(Integer.valueOf(pageNo));
        paging.setPageSize(Integer.valueOf(pageSize));
        paging.setRecordCount(page.getTotalProperty());
        CustomerListResult result = new CustomerListResult();
        result.setCustomerList(list);
        result.setPaging(paging);
        resultBean.setData(result);
        return SUCCESS;
    }

    /**
     * 分页查询电表信息
     * 
     * @return
     * @throws Exception
     */
    public String meterList() throws Exception {
        JSONObject data = analyzeJSONObject();
        String energyUnitId = getDataString(data, "energyUnitId");// 用能单位编码
        String energyUnitType = getDataString(data, "energyUnitType");// 用能单位类型
        String meterName = getDataString(data, "meterName");// 电表名称
        int pageNo = getDataInt(data, "pageNo");// 页码
        int pageSize = getDataInt(data, "pageSize");// 每页显示多少条
        pageSize = pageSize == 0 ? PAGESIZE : pageSize;
        if (StringUtil.isNotDigits(energyUnitId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("用能单位编码" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(energyUnitType)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("用能单位类型" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("energyUnitId", energyUnitId);
        params.put("energyUnitType", energyUnitType);
        if (StringUtil.isNotEmpty(meterName)) {
            params.put("meterName", meterName);
        }
        Page page = this.returnPage(pageNo, pageSize);
        params.put(Globals.PAGE, page);
        List<MeterParamVO> list = icmService.selectMeterByPage(params);
        Paging paging = new Paging();
        paging.setPageNo(Integer.valueOf(pageNo));
        paging.setRecordCount(page.getTotalProperty());
        MeterListResult result = new MeterListResult();
        result.setMeterList(list);
        result.setPaging(paging);
        resultBean.setData(result);
        return SUCCESS;
    }

    /**
     * 查询单个用户信息
     * 
     * @return
     * @throws Exception
     */
    public String customer() throws Exception {
        JSONObject data = analyzeJSONObject();
        String enterpriseId = getDataString(data, "enterpriseId");// 企业编码
        String customerNo = getDataString(data, "customerNo");// 户号
        if (StringUtil.isNotDigits(customerNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("户号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(enterpriseId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("企业编码" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        Integer customer_no = Integer.valueOf(customerNo);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("enterpriseId", Integer.valueOf(enterpriseId));
        params.put("customer_no", customer_no);
        PpfCustomerVO customer = icmService.selectCustomerByCustomerNo(params);
        resultBean.setData(customer);
        return SUCCESS;
    }

    /**
     * 查询单个电表信息
     * 
     * @return
     * @throws Exception
     */
    public String meter() throws Exception {
        JSONObject data = analyzeJSONObject();
        String enterpriseId = getDataString(data, "enterpriseId");// 企业编码
        String meterNo = getDataString(data, "meterNo");// 电表编号
        if (StringUtil.isNotDigits(meterNo)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("电表编号" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(enterpriseId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("企业编码" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        String meter_no = StringUtil.AddjustLength(meterNo, 10, "0");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("enterpriseId", Integer.valueOf(enterpriseId));
        params.put("meterNo", meter_no);
        MeterVO meter = icmService.selectMeterByMeterNo(params);
        if (meter != null) {
            meter.setPriceTypeName(meter.getPriceType() == null ? "" : PriceTypeEnum.getText(meter.getPriceType()));
            resultBean.setData(meter);
        } else {
            resultBean.setRet(RET_CODE_FAILED);
            resultBean.setMsg("此表不存在!");
        }
        return SUCCESS;
    }

    /**
     * 获取用能单位树
     * 
     * @return
     * @throws Exception
     */
    public String energyUnitTree() throws Exception {
        JSONObject data = analyzeJSONObject();
        String energyUnitId = getDataString(data, "energyUnitId");// 用能单位编码
        String energyUnitType = getDataString(data, "energyUnitType");// 用能单位类型
        if (StringUtil.isNotDigits(energyUnitId)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("用能单位编码" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        if (StringUtil.isNotDigits(energyUnitType)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            resultBean.setMsg("用能单位类型" + RetTypeEnum.PARAM_ERROR.getText());
            return SUCCESS;
        }
        EnergyUnitTree tree = icmService.loadEnergyUnitTree(Integer.valueOf(energyUnitId), Integer.valueOf(energyUnitType));
        resultBean.setData(tree);
        return SUCCESS;
    }

    /**
     * 解析JSONObject公共方法
     * 
     * @return
     * @throws Exception
     */
    private JSONObject analyzeJSONObject() throws Exception {
        JSONObject rs = readerLine(resultBean);
        String operatorId = resultBean.getOperatorId();
        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        JSONObject data = getDecodeData(rs.getString("data"), sk);
        return data;
    }

    /**
     * 检查购电金额>=购电电量 * 电价，若不满足直接返回提示购电金额计算有误
     * 
     * @return
     */
    private boolean checkBuymoneyAndBuyenergy(Double buyEnergy, Double buyMoney, Double price) {
        if (buyMoney >= buyEnergy * price) {
            return false;
        }
        return true;
    }

    // GET SET
    public ShareResultBean getResultBean() {
        return resultBean;
    }
}
