package com.holley.emcpshare.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcpshare.comenum.EnergyTypeEnum;
import com.holley.emcpshare.comenum.HistorySearchTypeEnum;
import com.holley.emcpshare.comenum.SuccStatTypeEnum;
import com.holley.emcpshare.common.util.HMacMD5;
import com.holley.emcpshare.common.util.ShareGloblas;
import com.holley.emcpshare.common.util.ShareSecurityUtil;
import com.holley.emcpshare.model.def.QueryBean;
import com.holley.platform.common.cache.RedisUtil;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;

public class HttpRequestUtil {

    private final static Logger logger         = Logger.getLogger(HttpRequestUtil.class);
    private final static String baseurl        = "http://api.map.baidu.com/geoconv/v1/?ak=Gf39Vxv6N9I9pfdb8tyg6GIA&output=json&coords=";
    // private final static String ecbaseurl = "http://localhost:8081/emcp/v1/"; // 测试站地址
    private final static String ecbaseurl      = "http://localhost:8081/emcp/bank/";                                                    // 测试站地址

    // private static String ecbaseurl = "http://120.55.104.220:8780/emcp/v1/"; // 正式站地址
    // private static String ecbaseurl = "http://120.55.104.220:8780/emcp/bank/";
    private static String       oid            = "348375733";
    private static String       operatorSecret = "ktCsIjuiUrcLHVcM";
    private static String       dataSecret     = "wY0I0L46w3edfKi3";
    private static String       dataSecretIV   = "iXfi4JvfSyrz4ct1";
    private static String       sigSecret      = "jRXtTUbObPffvanp";
    public static int           timeout        = 30000;

    // static {
    // InputStream inStream = HttpRequestUtil.class.getClassLoader().getResourceAsStream("openActive.properties");
    // Properties prop = new Properties();
    // try {
    // prop.load(inStream);
    // ecbaseurl = prop.getProperty("openUrl");
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    //
    // }

    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url 发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static JSONArray sendGet(String param) {
        String result = "";
        BufferedReader in = null;
        JSONArray array = null;
        try {
            String urlNameString = baseurl + param;

            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            connection.setConnectTimeout(10000);
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            // Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // for (String key : map.keySet()) {
            // System.out.println(key + "--->" + map.get(key));
            // }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            JSONObject resultJsonObj = JSONObject.fromObject(result);
            if (resultJsonObj.getInt("status") == 0) {
                String resultListJsonObj = resultJsonObj.get("result").toString();
                array = JSONArray.fromObject(resultListJsonObj);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return array;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String queryToken(String oId) throws Exception {
        String localtoken = RedisUtil.getString(ShareGloblas.KEY_PUSH_TOKEN + oId);
        if (StringUtil.isNotEmpty(localtoken)) {
            return localtoken;
        }

        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("OperatorID", Globals.OPERATOR_ID);
        // data.put("TimeStamp", DateUtil.DateToLong14Str(new Date()));
        // data.put("Seq", "0001");

        QueryBean qb = new QueryBean(new Date());
        qb.setOperatorId(ShareGloblas.OPERATOR_ID);

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("OperatorID", ShareGloblas.OPERATOR_ID);
        param.put("OperatorSecret", "qu31xLHf8PoZ9xro");
        // data.put("Sig", "");
        JSONObject jsonObj = httpTest("query_token", param, qb, null);
        String enData = jsonObj.getString("Data");
        String deData = ShareSecurityUtil.aesDecrypt(enData, "wRhI9mOq0H49cZ2Q", "i9SyMklPlsuUmcal");
        if (StringUtil.isNotEmpty(deData)) {
            JSONObject obj = JSONObject.fromObject(deData);
            int succStat = obj.getInt("SuccStat");
            if (SuccStatTypeEnum.SUCCESS.getValue() == succStat) {
                String token = obj.getString("AccessToken");
                int timelong = obj.getInt("TokenAvailableTime");
                RedisUtil.setString(ShareGloblas.KEY_PUSH_TOKEN + oId, token, timelong);
                return token;
            }

        }
        return null;
    }

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

    // public static JSONObject httpTest(String actionUrl, Map<String, Object> param, Map<String, Object> data, String
    // token) throws Exception {
    //
    // String enstr = SecurityUtil.aesEncrypt(JSON.toJSONString(param, SerializerFeature.WriteMapNullValue),
    // "wRhI9mOq0H49cZ2Q", "i9SyMklPlsuUmcal");
    // data.put("Data", enstr);
    //
    // String oid = data.get("OperatorID").toString();
    // String Data = data.get("Data").toString();
    // String TimeStamp = data.get("TimeStamp").toString();
    // String Seq = data.get("Seq").toString();
    // String Sig = oid + Data + TimeStamp + Seq;
    // Sig = HMacMD5.getHmacMd5Str("OpzDCdyuzr0hwxdK", Sig);
    // data.put("Sig", Sig);
    // return httpUrlConnection(ecbaseurl + actionUrl, JSONObject.fromObject(data).toString(), token);
    //
    // }

    public static JSONObject httpTest(String actionUrl, Object param, QueryBean queryBean, String token) throws Exception {

        String enstr = ShareSecurityUtil.aesEncrypt(JSON.toJSONString(param, SerializerFeature.WriteMapNullValue), dataSecret, dataSecretIV);
        queryBean.setData(enstr);
        String OperatorID = queryBean.getOperatorId();
        String Data = queryBean.getData().toString();
        String TimeStamp = queryBean.getTimeStamp();
        String Seq = queryBean.getSeq();
        String Sig = OperatorID + Data + TimeStamp + Seq;
        Sig = HMacMD5.getHmacMd5Str(sigSecret, Sig);
        queryBean.setSig(Sig);
        String params = JSON.toJSONString(queryBean, SerializerFeature.WriteMapNullValue);
        System.out.println(params);
        return httpUrlConnection(ecbaseurl + actionUrl, params, token);
    }

    // TEST
    /**
     * token获取
     * 
     * @param operatorID
     * @throws Exception
     */
    public static void testQueryToken(String operatorID) throws Exception {
        // token 请求
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("operatorId", operatorID);
        param.put("operatorSecret", operatorSecret);
        JSONObject js = httpTest("query_token", param, qb, null);
        decData(js);
    }

    /**
     * 获取月电费账单
     * 
     * @param operatorID
     * @param token
     * @param userId用户编码
     * @param timeList查询时间list
     * @throws Exception
     */
    public static void testqueryMonthlyPowerBillInfo(String operatorID, String token, String userId, List<String> timeList) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("queryTimes", timeList);

        httpTest("query_monthlyPowerBill_info", param, qb, token);

    }

    /**
     * 获取月水费账单
     * 
     * @param operatorID
     * @param token
     * @param userId用户编码
     * @param timeList查询时间list
     * @throws Exception
     */
    public static void testqueryMonthlyWaterBillInfo(String operatorID, String token, String userId, List<String> timeList) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("queryTimes", timeList);
        httpTest("query_monthlyWaterBill_info", param, qb, token);
    }

    /**
     * 查询账户信息
     * 
     * @param operatorID
     * @param token
     * @param userId用户编码
     * @throws Exception
     */
    public static void testQueryAccountInfo(String operatorID, String token, String userId) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        httpTest("query_account_info", param, qb, token);
    }

    /**
     * 账户充值
     * 
     * @param operatorID
     * @param token
     * @param userId用户编码
     * @param tradeNo订单编号
     * @param money充值金额
     * @throws Exception
     */
    public static void testAccountRecharge(String operatorID, String token, String userId, String tradeNo, String money) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("tradeNo", tradeNo);
        param.put("money", money);
        httpTest("account_recharge", param, qb, token);
    }

    /**
     * 远程拉合闸
     * 
     * @param operatorID
     * @param token
     * @param type
     * @param pointId
     * @throws Exception
     */
    public static void testRemoteDisconnect(String operatorID, String token, SwitchTypeEnum type, String pointId) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pointId", pointId);
        param.put("operType", type.getValue());
        httpTest("remote_disconnect", param, qb, token);
    }

    public static void queryRealElectricityInfo(String operatorID, String token, String pointId) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pointId", pointId);
        httpTest("query_realElectricity_info", param, qb, token);
    }

    /**
     * 查询电表历史数据 OPEN 2
     * 
     * @param operatorID 运营商ID
     * @param token 网络凭证
     * @param pointId设备编码
     * @param startTime开始时间
     * @param endTime结束时间
     * @param type查询类型
     * @throws Exception
     */
    public static void queryHistoryElectricityInfo(String operatorID, String token, String pointId, String startTime, String endTime, HistorySearchTypeEnum type) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pointId", pointId);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        param.put("type", type.getValue());
        httpTest("query_historyElectricity_info", param, qb, token);
    }

    /**
     * 查询电表最近一条历史数据OPEN 2
     * 
     * @param operatorID
     * @param token
     * @param pointId
     * @throws Exception
     */
    public static void queryLastHistoryElectricityInfo(String operatorID, String token, String pointId) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pointId", pointId);
        httpTest("query_lastHistoryElectricity_info", param, qb, token);
    }

    /**
     * 批量查询电表最近一条历史数据OPEN 2
     * 
     * @param operatorID
     * @param token
     * @param pointId
     * @throws Exception
     */
    public static void queryLastHistoryElectricityInfoBatch(String operatorID, String token) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        JSONObject jb = httpTest("query_lastHistoryElectricity_infoBatch", param, qb, token);
        String data = jb.getString("data");
        String dedata = ShareSecurityUtil.aesDecrypt(data, dataSecret, dataSecretIV);
        System.out.println(JSONArray.fromObject(dedata));
    }

    /**
     * OPEN 3
     * 
     * @param operatorID
     * @param token
     * @param address
     * @throws Exception
     */
    public static void queryElectricityDataListInfo(String operatorID, String token, String name, String buildingNo, String unitNo) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", name);
        param.put("buildingNo", buildingNo);
        param.put("unitNo", unitNo);
        httpTest("query_electricityDataList_info", param, qb, token);
    }

    // OPEN 4 SATRT

    public static void queryAllLastHistoryElectricityInfo(String operatorID, String token, String pointId, EnergyTypeEnum entype) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pointId", pointId);
        param.put("type", entype.getValue());
        httpTest("query_allLastHistoryElectricity_info", param, qb, token);
    }

    public static void queryRealElectricityDataInfo(String operatorID, String token, String address) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("address", address);
        httpTest("query_realElectricityData_info", param, qb, token);
    }

    // OPEN 4 END

    // 义乌 START
    /**
     * 查询账户信息
     * 
     * @param operatorID
     * @param token
     * @param userId用户编码
     * @throws Exception
     */
    public static void testQueryAccountRechargeInfo(String operatorID, String token, String userId, String startTime, String endTime) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        httpTest("query_accountRecharge_info", param, qb, token);
    }

    /**
     * 用户注册
     * 
     * @throws Exception
     */
    public static void testAccountRegister(String operatorID, String token, String userId, String phone, String time, String name, String linkman) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("phone", phone);
        param.put("time", time);
        param.put("name", name);
        param.put("linkman", linkman);
        httpTest("account_register", param, qb, token);
    }

    /**
     * 用户修改
     * 
     * @throws Exception
     */
    public static void testAccountModify(String operatorID, String token, String userId, String phone, String name, String linkman) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("phone", phone);
        param.put("name", name);
        param.put("linkman", linkman);
        httpTest("account_modify", param, qb, token);
    }

    /**
     * 查询电表日用量
     * 
     * @throws Exception
     */
    public static void testQueryDayPowerDataInfo(String operatorID, String token, String pointId, String dataTime) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("dataTime", dataTime);
        param.put("pointId", pointId);
        httpTest("query_dayPowerData_info", param, qb, token);
    }

    /**
     * 查询水表日用量
     * 
     * @throws Exception
     */
    public static void testQueryDayWaterDataInfo(String operatorID, String token, String pointId, String dataTime) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("dataTime", dataTime);
        param.put("pointId", pointId);
        httpTest("query_dayWaterData_info", param, qb, token);
    }

    // 义乌 END

    // 银行接口 start
    /**
     * 查询水表日用量
     * 
     * @throws Exception
     */
    public static void queryBankBills(String operatorID, String token, String operatorSecret) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("operatorSecret", operatorSecret);
        httpTest("query_bank_bills", param, qb, token);
    }

    /**
     * 查询水表日用量
     * 
     * @throws Exception
     */
    public static void queryBankBillsResult(String operatorID, String token, String operatorSecret, List<String> datas) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("operatorSecret", operatorSecret);
        param.put("datas", datas);
        httpTest("query_bank_bills_result", param, qb, token);
    }

    public static void queryBankContract(String operatorID, String token, String operatorSecret, String hh, String cardNo, String dateTime) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("operatorSecret", operatorSecret);
        param.put("hh", hh);
        param.put("cardNo", cardNo);
        param.put("dateTime", dateTime);
        httpTest("query_bank_contract", param, qb, token);
    }

    public static void queryBankDissolution(String operatorID, String token, String operatorSecret, String hh, String cardNo, String dateTime) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("operatorSecret", operatorSecret);
        param.put("hh", hh);
        param.put("cardNo", cardNo);
        param.put("dateTime", dateTime);
        httpTest("query_bank_dissolution", param, qb, token);
    }

    public static void queryUseraccountInfo(String operatorID, String token, String hh) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", hh);
        httpTest("query_useraccount_info", param, qb, token);
    }

    public static void queryHistoryRealElectricityInfo(String operatorID, String token, String pointId, int energyType) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pointId", pointId);
        param.put("energyType", energyType);
        httpTest("query_history_real_electricity_info", param, qb, token);
    }

    public static void queryPowerZhBmInfo(String token, String dataTime) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(oid);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("dataTime", dataTime);
        httpTest("query_power_zhbm_info", param, qb, token);
    }

    public static void queryRealOrHistoryPowerBmInfo(String token, int type, String organizationCode, String startTime, String endTime) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(oid);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", type);
        param.put("organizationCode", organizationCode);
        param.put("startTime", startTime);
        param.put("endTime", endTime);

        decData(httpTest("query_realOrHistoryPowerBm_info", param, qb, token));
    }

    public static void queryRealOrHistoryWaterBmInfo(String token, int type, String organizationCode, String startTime, String endTime) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(oid);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", type);
        param.put("organizationCode", organizationCode);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        decData(httpTest("query_realOrHistoryWaterBm_info", param, qb, token));
    }

    public static void queryRealOrHistoryGasBmInfo(String token, int type, String organizationCode, String startTime, String endTime) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorId(oid);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", type);
        param.put("organizationCode", organizationCode);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        decData(httpTest("query_realOrHistoryGasBm_info", param, qb, token));
    }

    public static void decData(JSONObject data) throws Exception {
        if (data != null) {
            String enData = data.getString("data");
            if (StringUtil.isNotEmpty(enData)) {
                String s = ShareSecurityUtil.aesDecrypt(enData, dataSecret, dataSecretIV);
                logger.info("data解密：" + s);
            }
        }
    }

    // 银行接口 end
    public static void main(String[] args) {

        String token = "a08c3ffe4288444591b8e7b41a275430";

        try {
            // testQueryToken(oid);
            // testQueryToken(oid);// token获取
            // queryRealOrHistoryPowerBmInfo(token, 1, "电表单元", "2018-07-26 09:00:00", "2018-07-26 09:00:00");
            // queryRealOrHistoryWaterBmInfo(token, 1, "水表单元", "2017-04-02 00:00:00", "2017-05-01 00:00:00");
            // queryRealOrHistoryGasBmInfo(token, 1, "气表单元", "2017-01-01 00:00:00", "2017-01-08 00:00:00");
            // queryPowerZhBmInfo(token, "2018-03-20 14:00:00");
            // queryLastHistoryElectricityInfoBatch(oid, token);
            // queryHistoryRealElectricityInfo(oid, token, "000000061934", EnergyTypeEnum.POWER.getValue());
            // List<String> datas = new ArrayList<String>();
            // datas.add("F101W|F101_W||201803|13.00|16.00|0.00|3.00|6.00|18.00|0.00|123456|2|");
            // datas.add("F101W|F101_W||201805|19.00|22.00|0.00|3.00|6.00|18.00|0.00|123456|0|");
            // datas.add("E201W|E201_W||201801|8.00|10.00|0.00|2.00|6.00|60.00|0.00|101014862851883|G|");
            // datas.add("C201D101W|C201D101_W||201801|57.00|77.00|0.00|20.00|6.00|462.00|0.00|101014862852064|H|");
            // datas.add("C101W|C101_W||201801|5.00|7.00|0.00|2.00|6.00|42.00|0.00|101014862852226|K|");
            // datas.add("B301W|B301_W||201801|5.00|7.00|0.00|2.00|6.00|42.00|0.00|101014862852519|b|");
            // datas.add("F101W|F101_W||201802|11.00|13.00|0.00|2.00|6.00|12.00|0.00|101014862852226|0|");
            // datas.add("G101W|G101_W||201802|9984.00|12.00|0.00|-9972.00|6.00|162.00|0.00|6228580199086341822|0|");
            // datas.add("E201W|E201_W||201802|10.00|11.00|0.00|1.00|6.00|6.00|0.00|101014862851883|0|");
            // datas.add("C201D101W|C201D101_W||201802|77.00|91.00|0.00|14.00|6.00|84.00|0.00|101014862852064|F|");
            // datas.add("C101W|C101_W||201802|7.00|9.00|0.00|2.00|6.00|12.00|0.00|101014862852226|0|");
            //
            // datas.add("B301W|B301_W||201802|7.00|9.00|0.00|2.00|6.00|12.00|0.00|101014862852519|0|");
            // datas.add("F101W|F101_W||201803|13.00|16.00|0.00|3.00|6.00|18.00|0.00|101014862852226|0|");
            // datas.add("G101W|G101_W||201803|12.00|61.00|0.00|49.00|6.00|294.00|0.00|6228580199086341822|0|");
            // datas.add("E201W|E201_W||201803|11.00|15.00|0.00|4.00|6.00|24.00|0.00|101014862851883|0|");
            // datas.add("C201D101W|C201D101_W||201803|91.00|84.00|0.00|-7.00|6.00|42.00|0.00|101014862852064|F|");
            // datas.add("C101W|C101_W||201803|9.00|11.00|0.00|2.00|6.00|12.00|0.00|101014862852226|0|");
            // datas.add("B301W|B301_W||201803|9.00|10.00|0.00|1.00|6.00|6.00|0.00|101014862852519|0|");

            // for (int x = 0; x < 3000; x++) {
            // datas.add(x + "20355|方军红|晨东小区52-2-204|201503|14|22|0|8|1.55|12.40|0.50|6228580899010263600|2099|");
            // }

            // System.out.println(datas.size());
            // queryBankContract(oid, token, operatorSecret, "F101W", "123456", "2017-05-02 15:20:00");
            // queryBankDissolution(oid, token, operatorSecret, "E201W", "123456", "1");
            // queryUseraccountInfo(oid, token, "703");
            // queryBankBillsResult(oid, token, operatorSecret, datas);
            queryBankBills(oid, token, operatorSecret);
            // testQueryDayPowerDataInfo(oid, token, "005800020084", "2017-12-06");
            // testQueryDayWaterDataInfo(oid, token, "111111111111", "2017-04-03");
            // testAccountModify(oid, token, "12345670", "123", "", "");
            // testAccountRegister(oid, token, "12345670", "18868823624", DateUtil.DateToLongStr(new Date()), "华立1",
            // "hello1");
            // testQueryAccountRechargeInfo(oid, token, "12345670", "2017-01-01 00:00:00", "2017-08-01 00:00:00");
            // List<String> timeList = new ArrayList<String>();
            // timeList.add("2017-09");// YYYY-MM
            // testqueryMonthlyPowerBillInfo(oid, token, "159682", timeList);// 查询电表月账单
            // testqueryMonthlyWaterBillInfo(oid, token, "159682", timeList);// 查询水表月账单
            // testQueryAccountInfo(oid, token, "159682");
            // testQueryAccountInfo(oid, token, "12345678901234567890123456789001");// 查询账户信息
            // testRemoteDisconnect(oid, token, SwitchTypeEnum.CONNECT, "000000000012");// 远程拉合闸
            // testAccountRecharge(oid, token, "18868823615", "123456780", "500");// 账户充值
            // queryHistoryElectricityInfo(oid, token, "111111111111", "20171101", "20171109",
            // HistorySearchTypeEnum.ALL);// 查询电表历史记录
            // queryLastHistoryElectricityInfo(oid, token, "000000061934");
            // query_electricityDataList_info(oid, token, "xxx小区");
            // query_allLastHistoryElectricity_info(oid, token, "111111111111");
            // queryAllLastHistoryElectricityInfo(oid, token, "000000031254", EnergyTypeEnum.POWER);
            // queryRealElectricityDataInfo(oid, token, "双新快线公租房1期1幢0301室");
            // queryElectricityDataListInfo(oid, token, "合龙公租房1期", "1", "01");
            // queryRealElectricityInfo(oid, token, "000000369301");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
