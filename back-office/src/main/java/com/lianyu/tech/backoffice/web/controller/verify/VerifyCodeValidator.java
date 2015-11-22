package com.lianyu.tech.backoffice.web.controller.verify;

import com.lianyu.tech.backoffice.web.SessionConstants;
import com.lianyu.tech.backoffice.web.SiteContext;
import com.lianyu.tech.core.platform.exception.InvalidRequestException;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author bowen
 */
@Service
public class VerifyCodeValidator {
    @Inject
    SiteContext siteContext;

    public void setVerifyCode(String code) {
        siteContext.addSession(SessionConstants.VERIFY_CODE_IMG, code);
    }

    public void verify(String code) {
        String sessionCode = siteContext.getSession(SessionConstants.VERIFY_CODE_IMG);
        if (!StringUtils.hasText(sessionCode)) {
            throw new InvalidRequestException("验证码不存在");
        }
        if (!sessionCode.equalsIgnoreCase(code)) {
            throw new InvalidRequestException("验证码不正确");
        }
    }
}
