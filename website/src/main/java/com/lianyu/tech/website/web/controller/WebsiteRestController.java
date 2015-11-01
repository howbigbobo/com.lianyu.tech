package com.lianyu.tech.website.web.controller;

import com.lianyu.tech.core.platform.web.rest.RESTController;
import com.lianyu.tech.core.platform.web.rest.exception.ErrorResponse;
import com.lianyu.tech.core.platform.web.rest.exception.ErrorResponseBuilder;
import com.lianyu.tech.core.platform.web.site.cookie.RequireCookie;
import com.lianyu.tech.core.platform.web.site.session.RequireSession;
import com.lianyu.tech.website.web.SiteContext;
import com.lianyu.tech.website.web.interceptor.MasterLayout;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.inject.Inject;

@RestController
@RequireCookie
@RequireSession
@MasterLayout
public class WebsiteRestController extends RESTController {
    @Inject
    private SiteContext siteContext;
    @Inject
    private ErrorResponseBuilder errorResponseBuilder;

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.REQUEST_ENTITY_TOO_LARGE)
    @ResponseBody
    public ErrorResponse requestTooLarge(MaxUploadSizeExceededException e) {
        return errorResponseBuilder.createErrorResponse(e);
    }

    public SiteContext getSiteContext() {
        return siteContext;
    }

    public void setSiteContext(SiteContext siteContext) {
        this.siteContext = siteContext;
    }
}
