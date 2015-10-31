package com.lianyu.tech.website.web;


import com.lianyu.tech.core.platform.web.request.RequestContext;
import com.lianyu.tech.core.platform.web.site.cookie.CookieContext;
import com.lianyu.tech.core.platform.web.site.session.SecureSessionContext;
import com.lianyu.tech.core.platform.web.site.session.SessionContext;
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
        map.put("keep", "");
        return map;
    }
}

