package com.lianyu.tech.backoffice.web;


import com.lianyu.tech.core.collection.Key;
import com.lianyu.tech.core.json.JSONBinder;
import com.lianyu.tech.core.platform.web.request.RequestContext;
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

    public boolean isLogin() {
        Boolean isLogin = sessionContext.get(SessionConstants.ACCOUNT_IS_LOGIN);
        return isLogin != null && isLogin;
    }

    public AccountInfo getAdminInfo() {
        String adminInfoValue = sessionContext.get(SessionConstants.ACCOUNT_LOGIN);
        if (!StringUtils.hasText(adminInfoValue)) {
            return null;
        }
        return JSONBinder.binder(AccountInfo.class).fromJSON(adminInfoValue);
    }

    public void login(AccountInfo accountInfo) {
        String adminInfoValue = JSONBinder.binder(AccountInfo.class).toJSON(accountInfo);
        sessionContext.set(SessionConstants.ACCOUNT_IS_LOGIN, true);
        sessionContext.set(SessionConstants.ACCOUNT_LOGIN, adminInfoValue);
    }

    public void logout() {
        sessionContext.invalidate();
    }

    public Map<String, Object> getModel() {
        Map<String, Object> map = new HashMap<>();
        AccountInfo accountInfo = getAdminInfo();
        if (accountInfo != null)
            map.put("account", accountInfo);
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

