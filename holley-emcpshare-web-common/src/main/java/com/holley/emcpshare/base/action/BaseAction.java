package com.holley.emcpshare.base.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.TokenHelper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.holley.emcpshare.common.util.HMacMD5;
import com.holley.emcpshare.common.util.LocalCacheUtil;
import com.holley.emcpshare.common.util.ShareGloblas;
import com.holley.emcpshare.common.util.ShareSecurityUtil;
import com.holley.emcpshare.model.PpfCustomerExample;
import com.holley.emcpshare.model.SysSecretKey;
import com.holley.emcpshare.model.def.ShareResultBean;
import com.holley.emcpshare.service.share.CommonService;
import com.holley.emcpshare.util.DateMorpherEx;
import com.holley.platform.common.cache.RedisUtil;
import com.holley.platform.common.dataobject.Page;
import com.holley.platform.common.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;

/**
 * 基础strtus的ACTION基类
 * 
 * @author zhouli
 */
public abstract class BaseAction extends ActionSupport implements SessionAware {

    private final static Logger   logger           = Logger.getLogger(BaseAction.class);
    private static final long     serialVersionUID = 1L;

    protected String              MSG              = "msg";                             // add by sc提示信息
    protected String              MEMBER           = "member";                          // add by sc返回主页
    // 返回的错误信息,从国际化资源文件取
    protected boolean             success          = true;
    protected String              message;                                              // json返回页面的
    protected String              encode           = "UTF-8";
    protected static int          limit            = 10;                                // 分页数据大小
    protected static String       ERROR            = "error";
    protected static int          IS_EXPORT        = 1;                                 // 导出Excel标志
    protected static int          MAX_EXPORT       = 3000;                              // 最大导出条数
    protected String              appsecretkey;                                         // app版本号对应的密钥
    protected Map<String, Object> session;
    protected static final int    BY_YEAR          = 1;                                 // 按年
    protected static final int    BY_MONTH         = 2;                                 // 按月
    protected static final int    BY_QUARTER       = 3;                                 // 按季度
    protected static final int    COUNT_SIZE       = 5;                                 // 排行数
    
    @Resource
    protected LocalCacheUtil      localCacheUtil;
    @Resource
    protected CommonService       commonService;

    // @Resource
    // private MessageSendService messageSendService;
    @Before
    public void testBefore() {
        // String data = ServletActionContext.getRequest().getParameter("data");
        // String version = ServletActionContext.getRequest().getParameter("version");
        // String type = ServletActionContext.getRequest().getHeader("platform");// 1:android,2:ios
        // logger.info("解密前：" + data);
        // if (StringUtils.isEmpty(version) || !NumberUtils.isNumber(type)) {
        // return;
        // }
        //
        // AppTypeEnum apptype = AppTypeEnum.getEnmuByValue(Integer.parseInt(type));
        // if (apptype == null) {
        // return;
        // }
        //
        // if (AppTypeEnum.ANDROID == apptype) {
        // appsecretkey = CacheSysHolder.getSysLinkName(LinkTypeEnum.ANDROID_VERSION.getValue(), version);
        // } else if (AppTypeEnum.IOS == apptype) {
        // appsecretkey = CacheSysHolder.getSysLinkName(LinkTypeEnum.IOS_VERSION.getValue(), version);
        // }
        //
        // if (!StringUtils.isEmpty(appsecretkey) && !StringUtils.isEmpty(data)) {
        // if (data.contains("\n")) {
        // data = data.replaceAll("\n", "");
        // }
        // if (data.contains(" ")) {
        // data = data.replaceAll(" ", "+");
        // }
        //
        // try {
        // String jsonstr = SecurityUtil.aesDecode(data, appsecretkey);
        // JSONObject jsonobj = JSONObject.fromObject(jsonstr);
        // ServletActionContext.getRequest().setAttribute("returnBean", jsonobj);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        //
        // }
        System.out.println("test--------------------------------------before");
    }

    @BeforeResult
    public void testAfter() throws Exception {
        ShareResultBean resultBean = (ShareResultBean) ServletActionContext.getRequest().getAttribute("resultBean");
        if (resultBean == null) {
            return;
        }
        Object data = resultBean.getData();
        // data = null;// TODO 暂时不加密

        String oid = resultBean.getOperatorId();
        if (data == null || StringUtil.isEmpty(oid)) {
            return;
        }

        SysSecretKey secretKey = localCacheUtil.getSecretKeyByOperatorID(oid);
        // jsonstr = JsonUtil.bean2json(data);
        String jsonstr = JSON.toJSONString(data, SerializerFeature.WriteMapNullValue);
        this.logger.info("jsonstr:-----" + jsonstr);
        if (!StringUtils.isEmpty(jsonstr)) {
            // AES数据加密
            String jsonstrkey = ShareSecurityUtil.aesEncrypt(jsonstr, secretKey.getDatasecret(), secretKey.getDatasecretiv());
            resultBean.setData(jsonstrkey);
        }
        // resultBean.setData(jsonstr);
        String enData = resultBean.getData() != null ? (String) resultBean.getData() : "";
        System.err.println("encode:----" + enData);
        // String str = oid + enData + resultBean.getTimeStamp() + resultBean.getSeq();

        // HMacMD5 生成标签
        resultBean.setSig(createSig(resultBean.getRet(), resultBean.getMsg(), enData, secretKey.getSigsecret()));
        resultBean.setOperatorId(ShareGloblas.OPERATOR_ID);
        // ServletActionContext.getRequest().setAttribute("anme", "ssss");
        System.out.println("test--------------------------------------after");
    }

    private String createSig(int reg, String msg, String enData, String sigsecret) {
        return HMacMD5.getHmacMd5Str(sigsecret, reg + msg + enData);
    }

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    public Map<String, Object> getApplication() {
        return ActionContext.getContext().getApplication();
    }

    protected String getParameter(String para) {
        String paraValue = this.getRequest().getParameter(para);

        /*
         * if (StringUtils.isEmpty(paraValue)) { Object obj = this.getSession().getAttribute(para); if (obj != null) {
         * return String.valueOf(obj); } else { return null; } }
         */
        return paraValue;
    }

    protected String getStrAttribute(String para) {
        Object obj = this.getRequest().getAttribute("returnBean");
        String result = null;
        if (obj != null) {
            JSONObject jsonObj = (JSONObject) obj;
            try {
                result = jsonObj.getString(para);
            } catch (Exception e) {
                LOG.info(para + "参数不存在...");
            }
        }
        return result;
    }

    protected int getIntAttribute(String para) {
        Object obj = this.getRequest().getAttribute("returnBean");
        int result = 0;
        if (obj != null) {
            JSONObject jsonObj = (JSONObject) obj;
            try {
                result = jsonObj.getInt(para);
            } catch (Exception e) {
                LOG.info(para + "参数不存在...");
            }
        }
        return result;
    }

    protected String getCookieByName(String cookieName) {
        Cookie allCookie[] = getRequest().getCookies();
        if (allCookie != null && allCookie.length != 0) {
            for (int i = 0; i < allCookie.length; i++) {
                String keyname = allCookie[i].getName();
                String value = allCookie[i].getValue();
                if (StringUtils.equals(cookieName, keyname)) {
                    return value;
                }
            }
        }

        return null;
    }

    protected Cookie saveToCookie30Min(String cookieName, String cookieValue) throws Exception {
        return saveToCookie(cookieName, cookieValue, 60 * 30);// cookie保存30分钟
    }

    protected Cookie saveToCookie(String cookieName, String cookieValue) throws Exception {
        return saveToCookie(cookieName, cookieValue, -1);// cookie保存当前会话
    }

    protected Cookie saveToCookie(String cookieName, String cookieValue, int maxAge) throws Exception {
        Cookie cookie = null;
        if (this.getCookieByName(cookieName) == null) {
            cookie = new Cookie(cookieName, cookieValue);
        } else {
            Cookie[] cookies = this.getRequest().getCookies();
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals(cookieName)) {
                    cookie.setValue(cookieValue);
                    break;
                }

            }
        }
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);// 秒
        this.getResponse().addCookie(cookie);
        return cookie;
    }

    /**
     * 是否需要导出excel
     * 
     * @return
     */
    public boolean isExportExcel() {
        String isExport = getRequest().getParameter("isExport");
        return StringUtils.equals("true", isExport);
    }

    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    public ServletContext getServletContext() {
        return ServletActionContext.getServletContext();
    }

    public String getRealyPath(String path) {
        return getServletContext().getRealPath(path);
    }

    public HttpSession getSession() {
        return this.getRequest().getSession();
    }

    public String getSessionID() {
        String jsessionID = getSession().getId();
        if (jsessionID.length() > 32) {
            jsessionID = jsessionID.substring(0, 32);
        }
        return jsessionID;
    }

    public String getRemoteIP() {
        String ip = this.getRequest().getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = this.getRequest().getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = this.getRequest().getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = this.getRequest().getRemoteAddr();
        }

        return ip;
    }

    /**
     * 发送JSON数据
     * 
     * @author shencheng
     * @param json
     */
    protected void printJson(String json) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        } catch (Exception e) {
            logger.info("发送json数据，失败！！");
            e.printStackTrace();
        }
    }

    /**
     * seconds 设置几分钟后可以 重新获取验证码
     *
     * @param seconds
     */

    protected String checkCanGetMobileCode(long seconds) {
        String msg = "success";
        Object codeInteceptor = getSession().getAttribute("phone_code_time");
        if (codeInteceptor != null) {// 申请过一次 计算时间差
            long currTime = System.currentTimeMillis();
            long remainTime = currTime - Long.parseLong(codeInteceptor.toString());
            long get_time = seconds * 60 * 1000;
            if (remainTime < get_time) {
                msg = "请您" + (get_time - remainTime) / (1000) + " 秒后，重新获取验证码";

            } else {
                getSession().setAttribute("phone_code_time", System.currentTimeMillis());
            }
        } else {
            getSession().setAttribute("phone_code_time", System.currentTimeMillis());
        }
        return msg;
    }

    /**
     * 提示消息
     *
     * @param msg
     */
    protected void message(String msg) {
        getRequest().setAttribute("msg", msg);
        // String urltext = "<a href=" + request.getContextPath() + url + " >" + text + "></a>";
        // request.setAttribute("backurl", urltext);
    }

    protected Page returnPage(int currentPage, int limit) {
        currentPage = currentPage == 0 ? 1 : currentPage;
        limit = limit == 0 ? this.limit : limit;
        Page page = new Page((currentPage - 1) * limit, limit);
        return page;
    }

    protected String getServletRealPath(String pathName) {
        return ServletActionContext.getServletContext().getRealPath(pathName);
    }

    protected int getParamInt(String param) {
        return NumberUtils.toInt(getParameter(param));
    }

    protected <T> T JsonToBean(String JsonString, Class<T> clazz) {
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM", "yyyy-MM-dd" }, (Date) null));
        JSONObject jsonObject = JSONObject.fromObject(JsonString);
        T entity = (T) JSONObject.toBean(jsonObject, clazz);
        return entity;
    }

    // protected JsonConfig returnJosnConfig(boolean isFilterNull, Class... filterClass) {
    // JsonConfig jsonConfig = new JsonConfig();
    // if (isFilterNull) {
    // // 过滤空值
    // PropertyFilter filter = new PropertyFilter() {
    //
    // public boolean apply(Object object, String fieldName, Object fieldValue) {
    // return null == fieldValue;
    // }
    // };
    // jsonConfig.setJsonPropertyFilter(filter);
    // }
    // for (Class clazz : filterClass) {
    // jsonConfig.registerJsonValueProcessor(clazz, new JsonDateValueProcessor());
    // }
    // // 日期类型的值转化成yyyy-MM-dd HH:mm:ss
    //
    // return jsonConfig;
    // }

    protected String saveOperatorToken(String OperatorId) {
        String token = UUID.randomUUID().toString().replace("-", "");
        RedisUtil.setString(ShareGloblas.KEY_TOKEN + OperatorId, token, ShareGloblas.TOKEN_AVAILABLE_TIME);
        return token;
    }

    protected String saveToken(String name) {
        String token = TokenHelper.generateGUID();
        session.put(name, token);
        return token;
    }

    protected JSONObject readerLine(ShareResultBean resultBean) {
        String str = ShareGloblas.threadLocal.get();
        ShareGloblas.threadLocal.remove();
        JSONObject jobj = JSONObject.fromObject(str);
        resultBean.setOperatorId(jobj.getString("operatorId"));
        return jobj;
    }

    protected JSONObject getDecodeData(String enData, SysSecretKey sk) throws Exception {
        String str = ShareSecurityUtil.aesDecrypt(enData, sk.getDatasecret(), sk.getDatasecretiv());

        return StringUtil.isEmpty(str) ? null : JSONObject.fromObject(str);
    }

    /**
     * 
     */
    protected boolean checkUserByHH(String hh, int eid) {
        PpfCustomerExample emp = new PpfCustomerExample();
        PpfCustomerExample.Criteria cr = emp.createCriteria();
        cr.andHhEqualTo(hh);
        cr.andEidEqualTo(eid);
        cr.andStatusEqualTo((short) 1);
        int count = commonService.countCustomerByExample(emp);
        return count > 0;
    }

    protected String getDataString(JSONObject data, String key) {
        if (data == null) {
            return "";
        }
        return data.containsKey(key) ? data.getString(key) : "";
    }

    protected int getDataInt(JSONObject data, String key) {
        if (data == null) {
            return 0;
        }
        return data.containsKey(key) ? NumberUtils.toInt(data.getString(key)) : 0;
    }

    protected double getDataDouble(JSONObject data, String key) {
        if (data == null) {
            return 0;
        }
        return data.containsKey(key) ? NumberUtils.toDouble(data.getString(key)) : 0;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getAppsecretkey() {
        return appsecretkey;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
