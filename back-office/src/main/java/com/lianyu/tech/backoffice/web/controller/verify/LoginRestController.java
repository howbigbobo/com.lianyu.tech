package com.lianyu.tech.backoffice.web.controller.verify;

import com.lianyu.tech.backoffice.web.request.LoginRequest;
import com.lianyu.tech.common.service.AccountService;
import com.lianyu.tech.core.platform.web.rest.RESTController;
import com.lianyu.tech.core.platform.web.site.session.RequireSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * @author bowen
 */
@Controller
@RequireSession
public class LoginRestController extends RESTController {

    @Inject
    private AccountService accountService;
    @Inject
    private VerifyCodeValidator verifyCodeValidator;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@Valid @RequestBody LoginRequest request) {
        verifyCodeValidator.verify(request.getVerifyCode());
        accountService.login(request.getName(), request.getPwd());
    }
}
