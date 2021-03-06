package com.holley.emcpshare.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.holley.emcpshare.common.util.HMacMD5;
import com.holley.emcpshare.common.util.ShareSecurityUtilDemo;
import com.holley.emcpshare.model.def.QueryBean;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;

public class HttpRequestUtilDemo {

    private final static Logger logger         = Logger.getLogger(HttpRequestUtilDemo.class);
    private final static String ecbaseurl      = "http://183.129.224.70:4882/emcp/v1/";      // 测试站地址

    // private static String ecbaseurl = "http://120.55.104.220:8780/emcp/v1/";正式站地址
    private static String       operatorSecret = "";                                         // 商户密钥
    private static String       dataSecret     = "";                                         // 消息密钥
    private static String       dataSecretIV   = "";                                         // 消息密钥初始化向量
    private static String       sigSecret      = "";                                         // 签名密钥
    private static int          timeout        = 10000;                                      // 超时时间ms
    private static String       oid            = "";                                         // 商户编码

    public static JSONObject httpUrlConnection(String baseurl, String requestString, String token) {
        BufferedReader responseReader = null;
        try {
            // 建立连接
            URL url = new URL(baseurl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            // //设置连接属性
            httpConn.setDoOutput(true);// 使用 URL 连接进行输出
            httpConn.setDoInput(true);// 使用 URL 连接进行输入
            httpConn.setUseCaches(false);// 忽略缓存
            httpConn.setRequestMethod("POST");// 设置URL请求方法
            httpConn.setConnectTimeout(timeout);
            httpConn.setReadTimeout(timeout);
            // String requestString =
            // "{operatorId:348375727,operatorSecret:123,sig:1F28FB25653BF36B6485DB0BDF38839B,data:NEODLvcvWaUNSt6tjAYp/6Uu2b0ALLMNCvrINsCpwm2pdpQ3cMjp8Q9krGXvFHDGHTfo1t8nss4vQ/MJLHRdJA==,timeStamp:123,seq:0001}";

            // 设置请求属性
            // 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
            byte[] requestStringBytes = requestString.getBytes("UTF-8");
            httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length);
            httpConn.setRequestProperty("Content-Type", "application/octet-stream");
            httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
            httpConn.setRequestProperty("Charset", "UTF-8");
            //
            if (StringUtil.isNotEmpty(token)) {
                httpConn.setRequestProperty("authorization", token);
            }

            // 建立输出流，并写入数据
            OutputStream outputStream = httpConn.getOutputStream();
            outputStream.write(requestStringBytes);
            outputStream.close();
            // 获得响应状态
            int responseCode = httpConn.getResponseCode();
            StringBuffer sb = new StringBuffer();

            if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
                // 当正确响应时处理数据
                String readLine;

                // 处理响应流，必须与服务器响应流输出的编码一致
                responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                // responseReader.close();
            }
            logger.info(sb.toString());
            return JSONObject.fromObject(sb.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (responseReader != null) {
                try {
                    responseReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    public static JSONObject httpTest(String actionUrl, Object param, QueryBean queryBean, String token) throws Exception {

        String enstr = ShareSecurityUtilDemo.aesEncrypt(JSON.toJSONString(param, SerializerFeature.WriteMapNullValue), dataSecret, dataSecretIV);
        queryBean.setData(enstr);
        String OperatorID = queryBean.getOperatorId();
        String Data = queryBean.getData().toString();
        String TimeStamp = queryBean.getTimeStamp();
        String Seq = queryBean.getSeq();
        String Sig = OperatorID + Data + TimeStamp + Seq;
        Sig = HMacMD5.getHmacMd5Str(sigSecret, Sig);
        queryBean.setSig(Sig);
        return httpUrlConnection(ecbaseurl + actionUrl, JSON.toJSONString(queryBean, SerializerFeature.WriteMapNullValue), token);

    }

    // TEST
    /**
     * token获取
     * 
     * @param operatorID
     * @throws Exception
     */
    public static JSONObject queryToken() throws Exception {
        // token 请求
        QueryBean qb = new QueryBean();
        qb.setOperatorId(oid);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("operatorId", oid);
        param.put("operatorSecret", operatorSecret);
        return httpTest("query_token", param, qb, null);
    }

    /**
     * 查询账户信息实例
     * 
     * @param operatorID
     * @param token
     * @param userId用户编码
     * @throws Exception
     */
    public static JSONObject queryAccountInfo(String token, String userId) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(oid);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        return httpTest("query_account_info", param, qb, token);
    }

    public static void main(String[] args) {

        String token = "";
        try {
            JSONObject jsonobj = queryToken();// token获取
            String deStr = ShareSecurityUtilDemo.aesDecrypt(jsonobj.getString("data"), dataSecret, dataSecretIV);
            logger.info("data解密数据：" + deStr);
            // queryAccountInfo(token, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
