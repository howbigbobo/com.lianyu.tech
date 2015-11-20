package com.lianyu.tech.backoffice.web;


import com.lianyu.tech.core.collection.Key;
import com.lianyu.tech.core.json.JSONBinder;
import com.lianyu.tech.core.platform.web.request.RequestContext;
import com.lianyu.tech.core.platform.web.site.cookie.CookieContext;
import com.lianyu.tech.core.platform.web.site.session.SecureSessionContext;
import com.lianyu.tech.core.platform.web.site.session.SessionContext;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Service
public class SiteContext {
    @Inject
    protected SessionContext sessionContext;
    @Inject
    protected SecureSessionContext secureSessionContext;
    @Inject
    protected RequestContext requestContext;
    @Inject
    private CookieContext cookieContext;

    public boolean isLogin() {
        AdminInfo adminInfo = getAdminInfo();
        return adminInfo != null && adminInfo.getAdminId() != null;
    }

    public AdminInfo getAdminInfo() {
        String adminInfoValue = sessionContext.get(SessionConstants.ADMIN_INFO);
        if (!StringUtils.hasText(adminInfoValue)) {
            return null;
        }
        return JSONBinder.binder(AdminInfo.class).fromJSON(adminInfoValue);
    }

    public void login(AdminInfo adminInfo) {
        String adminInfoValue = JSONBinder.binder(AdminInfo.class).toJSON(adminInfo);
        sessionContext.set(SessionConstants.ADMIN_INFO, adminInfoValue);
    }

    public void logout() {
        sessionContext.set(SessionConstants.ADMIN_INFO, "");
    }

    public void setLoginCookie(String name, String pwd) {
        cookieContext.setCookie(CookieConstants.ADMIN_NAME, name);
        cookieContext.setCookie(CookieConstants.ADMIN_PWD, pwd);
    }

    public void deleteLoginCookie() {
        cookieContext.deleteCookie(CookieConstants.ADMIN_NAME);
        cookieContext.deleteCookie(CookieConstants.ADMIN_PWD);
    }

    public void setErrInfo(String type, String msg) {
        sessionContext.set(SessionConstants.ERR_REFER, type);
        sessionContext.set(SessionConstants.ERR_MSG, msg);
    }


    public String getErrRefer() {
        return sessionContext.get(SessionConstants.ERR_REFER);
    }

    public String getErrMsg() {
        return sessionContext.get(SessionConstants.ERR_MSG);
    }

    public void deleteErrInfo() {
        sessionContext.set(SessionConstants.ERR_REFER, null);
        sessionContext.set(SessionConstants.ERR_MSG, null);
    }

    public Map<String, Object> getModel() {
        Map<String, Object> map = new HashMap<>();
        AdminInfo adminInfo = getAdminInfo();
        if (adminInfo != null)
            map.put("accountName", adminInfo.getName());
        return map;
    }

    public <T> void addSession(Key<T> key, T value) {
        sessionContext.set(key, value);
    }

    public <T> T getSession(Key<T> key) {
        return sessionContext.get(key);
    }

    public <T> void removeSession(Key<T> key) {
        sessionContext.set(key, null);
    }
}

