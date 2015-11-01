package com.lianyu.tech.website.web.controller;

import com.lianyu.tech.core.platform.web.site.SiteController;
import com.lianyu.tech.core.platform.web.site.cookie.RequireCookie;
import com.lianyu.tech.core.platform.web.site.session.RequireSession;
import com.lianyu.tech.backoffice.web.SiteContext;
import com.lianyu.tech.backoffice.web.interceptor.MasterLayout;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Map;

@Controller
@RequireCookie
@RequireSession
//@LoginRequired
@MasterLayout
public class BackOfficeSiteController extends SiteController {
    @Inject
    private SiteContext siteContext;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView validationError(IllegalArgumentException exception) {
        return validationErrorPage(exception, exception.getMessage());
    }

    private ModelAndView validationErrorPage(Exception exception, String message) {
        Map<String, Object> model = errorPageModelBuilder.buildErrorPageModel(message, exception);
        return new ModelAndView(siteSettings.getErrorPage(), model);
    }

    public SiteContext getSiteContext() {
        return siteContext;
    }

    public void setSiteContext(SiteContext siteContext) {
        this.siteContext = siteContext;
    }
}
