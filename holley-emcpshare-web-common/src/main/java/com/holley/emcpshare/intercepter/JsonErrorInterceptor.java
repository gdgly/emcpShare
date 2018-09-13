package com.holley.emcpshare.intercepter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.holley.emcpshare.comenum.RetTypeEnum;
import com.holley.emcpshare.common.util.HMacMD5;
import com.holley.emcpshare.common.util.LocalCacheUtil;
import com.holley.emcpshare.common.util.ShareGloblas;
import com.holley.emcpshare.common.util.ShareSecurityUtil;
import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.model.def.ShareResultBean;
import com.holley.platform.common.cache.RedisUtil;
import com.holley.platform.common.util.StringUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * JSON调用异常拦截
 * 
 * @author sc
 */
public class JsonErrorInterceptor extends BaseInterceptor {

    private static final Logger log              = Logger.getLogger(JsonErrorInterceptor.class);
    private static final long   serialVersionUID = 1L;
    @Resource
    private LocalCacheUtil      localCacheUtil;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {

            String path = getServletPath().replaceFirst("/", "");
            log.info("拦截器调用到了。。。" + path);
            if ("v1/notification_stationStatus".equals(path)) {
                return invocation.invoke();
            }
            log.info("读取到token。。。" + getRequest().getHeader("authorization"));

            ValueStack st = invocation.getStack();
            ShareResultBean bean = (ShareResultBean) st.findValue("resultBean");
            JSONObject da = readerLine();
            log.info("读取到数据。。。" + da);
            String operatorID = getDataString(da, "operatorId");
            SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorID);
            if (sk == null) {
                bean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
                return "errorjson";
            }

            if (!checkSig(da, sk)) {
                bean.setRet(RetTypeEnum.SIG_ERROR.getValue());
                return "errorjson";
            }
            ShareGloblas.threadLocal.set(da.toString());

            if (!"v1/query_token".equals(path)) {
                if (cheackOperatorKey(da, invocation)) {
                    return invocation.invoke();
                } else {
                    bean.setRet(RetTypeEnum.TOKEN_ERROR.getValue());
                    return "errorjson";
                }
            }
        } catch (Exception e) {
            log.info("非法调用");
            ValueStack st = invocation.getStack();
            ShareResultBean bean = (ShareResultBean) st.findValue("resultBean");
            if (bean != null) {
                bean.setRet(RetTypeEnum.SYS_ERROR.getValue());
            }
            e.printStackTrace();
            return "errorjson";
        }
        return invocation.invoke();
    }

    private boolean checkSig(JSONObject da, SysSecretKey sk) {
        String operatorID = getDataString(da, "operatorId");
        String sig = getDataString(da, "sig");
        String key = sk.getSigsecret();
        String data = getDataString(da, "data");
        String tempdate = getDataString(da, "timeStamp");
        String seq = getDataString(da, "seq");
        String str = operatorID + data + tempdate + seq;
        String lsig = HMacMD5.getHmacMd5Str(key, str);
        System.out.println("okSig：" + lsig);
        System.out.println("querySig：" + sig);
        return lsig.equals(sig);
    }

    private boolean cheackOperatorKey(JSONObject da, ActionInvocation invocation) throws Exception {
        ValueStack st = invocation.getStack();
        ShareResultBean bean = (ShareResultBean) st.findValue("resultBean");
        try {
            String operatorID = getDataString(da, "operatorId");
            // String requestToken = da.getString("Token");
            String requestToken = getRequest().getHeader("authorization");
            // String[] tokens = requestToken.split(" ");
            // requestToken = tokens[1];
            System.out.println("传送的token：----" + requestToken);
            String localToken = RedisUtil.getString(ShareGloblas.KEY_TOKEN + operatorID);
            System.out.println("存储的token：----" + localToken);
            if (StringUtil.isNull(requestToken, localToken) || !requestToken.equals(localToken)) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private JSONObject readerLine() {
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputReader = null;
        BufferedReader bufferReader = null;
        JSONObject rs = null;
        try {
            inputReader = new InputStreamReader(getRequest().getInputStream(), "UTF-8");
            bufferReader = new BufferedReader(inputReader);
            String line = null;
            while ((line = bufferReader.readLine()) != null) {
                sb.append(line);
            }
            String temp = sb.toString();
            if (temp.startsWith("data:")) {
                temp.substring("data:".length(), temp.length());
            }
            rs = JSONObject.fromObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (inputReader != null) {
                try {
                    inputReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return rs;
    }

    private JSONObject getDecodeData(String enData, SysSecretKey sk) throws Exception {
        String str = ShareSecurityUtil.aesDecrypt(enData, sk.getDatasecret(), sk.getDatasecretiv());
        return JSONObject.fromObject(str);
    }
}
