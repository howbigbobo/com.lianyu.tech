package com.lianyu.tech.backoffice.web.controller.verify;

import com.lianyu.tech.backoffice.web.SiteContext;
import com.lianyu.tech.common.service.AccountService;
import com.lianyu.tech.core.platform.web.site.SiteController;
import com.lianyu.tech.core.platform.web.site.cookie.RequireCookie;
import com.lianyu.tech.core.platform.web.site.session.RequireSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@RequireCookie
@RequireSession
@Controller
public class LoginController extends SiteController {
    @Inject
    SiteContext siteContext;
    @Inject
    AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut() {
        siteContext.logout();
        return "login";
    }
}
