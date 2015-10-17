package com.lianyu.tech.backoffice.web.controller;

import com.lianyu.tech.core.platform.web.site.SiteController;
import com.lianyu.tech.core.platform.web.site.cookie.RequireCookie;
import com.lianyu.tech.core.platform.web.site.session.RequireSession;
import com.lianyu.tech.core.util.DigestUtils;
import com.lianyu.tech.backoffice.service.AdminService;
import com.lianyu.tech.backoffice.web.AdminInfo;
import com.lianyu.tech.backoffice.web.SiteContext;
import com.lianyu.tech.backoffice.web.request.LoginValidRequest;
import com.lianyu.tech.backoffice.web.vo.ValidLoginResultView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@RequireCookie
@RequireSession
@Controller
public class LoginController extends SiteController {
    @Inject
    SiteContext siteContext;
    @Inject
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> model) {
        AdminInfo adminInfo = new AdminInfo();
        siteContext.login(adminInfo);
        model.put("isLoginOut", "N");

        String errRefer = siteContext.getErrRefer();
        String errMsg = siteContext.getErrMsg();
        if (errRefer != null && errMsg != null) {
            ValidLoginResultView validLoginResultView = new ValidLoginResultView();
            validLoginResultView.setErrRefer(ValidLoginResultView.ErrRefer.fromString(errRefer));
            validLoginResultView.setErrMsg(errMsg);
            model.put("validLoginResultView", validLoginResultView);
        }
        return "login";
    }

    @RequestMapping(value = "/login/valid", method = RequestMethod.POST)
    public String loginValid(@Valid LoginValidRequest loginValidRequest) throws UnsupportedEncodingException {
        ValidLoginResultView validLoginResultView = adminService.validLogin(loginValidRequest.getName(), loginValidRequest.getPwd(),
            "Y".equalsIgnoreCase(loginValidRequest.getIsSecure()));

        if (validLoginResultView.getErrMsg() == null || validLoginResultView.getErrMsg().isEmpty()) {
            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setAdminId(validLoginResultView.getAdminId());
            adminInfo.setName(loginValidRequest.getName());
            siteContext.login(adminInfo);
            if ("on".equalsIgnoreCase(loginValidRequest.getRememberMe())) {
                String securePwd = getSecurePwd(loginValidRequest);
                siteContext.setLoginCookie(loginValidRequest.getName(), securePwd);
            } else {
                siteContext.deleteLoginCookie();
            }
            siteContext.deleteErrInfo();
            return "redirect:/home";
        } else if ("Y".equalsIgnoreCase(loginValidRequest.getIsLoginOut())) {
            siteContext.setErrInfo(validLoginResultView.getErrRefer().toString(), validLoginResultView.getErrMsg());
            siteContext.setLoginCookie(loginValidRequest.getName(), loginValidRequest.getPwd());
            return "redirect:/loginOut";
        } else {
            siteContext.setErrInfo(validLoginResultView.getErrRefer().toString(), validLoginResultView.getErrMsg());
            siteContext.setLoginCookie(loginValidRequest.getName(), loginValidRequest.getPwd());
            return "redirect:/login";
        }
    }

    private String getSecurePwd(LoginValidRequest loginValidRequest) {
        String securePwd;
        if ("Y".equalsIgnoreCase(loginValidRequest.getIsSecure())) {
            securePwd = loginValidRequest.getPwd();
        } else {
            securePwd = DigestUtils.sha512(loginValidRequest.getPwd());
        }
        return securePwd;
    }


    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(Map<String, Object> model) {
        siteContext.logout();
        model.put("isLoginOut", "Y");
        String errRefer = siteContext.getErrRefer();
        String errMsg = siteContext.getErrMsg();
        if (errRefer != null && errMsg != null) {
            ValidLoginResultView validLoginResultView = new ValidLoginResultView();
            validLoginResultView.setErrRefer(ValidLoginResultView.ErrRefer.fromString(errRefer));
            validLoginResultView.setErrMsg(errMsg);
            model.put("validLoginResultView", validLoginResultView);
        }

        return "login";
    }
}
