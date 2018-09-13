package com.holley.emcpshare.intercepter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public abstract class BaseInterceptor extends AbstractInterceptor {

    private static final long   serialVersionUID = -2239644443711524657L;
    @SuppressWarnings("unused")
    private static final Logger logger           = Logger.getLogger(BaseInterceptor.class);

    public abstract String intercept(ActionInvocation invocation) throws Exception;

    protected String getNamespce() {
        return ServletActionContext.getActionMapping().getNamespace();
    }

    protected HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    protected String getServletPath() {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request.getServletPath();
    }

    protected String getSessionID() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String jsessionID = request.getSession().getId();
        if (jsessionID.length() > 32) {
            jsessionID = jsessionID.substring(0, 32);
        }
        return jsessionID;
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
        return data.containsKey(key) ? data.getInt(key) : 0;
    }
}
