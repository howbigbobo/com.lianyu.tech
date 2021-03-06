package com.lianyu.tech.website.web.controller.verify;


import com.lianyu.tech.common.domain.Account;
import com.lianyu.tech.common.service.AccountService;
import com.lianyu.tech.core.platform.web.rest.RESTController;
import com.lianyu.tech.website.web.AccountInfo;
import com.lianyu.tech.website.web.SiteContext;
import com.lianyu.tech.website.web.request.LoginRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * @author bowen
 */
//@Controller
//@RequireCookie
//@RequireSession
public class LoginRestController extends RESTController {

    @Inject
    private AccountService accountService;
    @Inject
    private VerifyCodeValidator verifyCodeValidator;
    @Inject
    private SiteContext siteContext;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@Valid @RequestBody LoginRequest request) {
        verifyCodeValidator.verify(request.getVerifyCode());
        Account account = accountService.login(request.getName(), request.getPwd());
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setName(account.getName());
        accountInfo.setId(account.getId());
        siteContext.login(accountInfo);
    }
}
