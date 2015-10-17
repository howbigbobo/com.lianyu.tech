package com.lianyu.tech.backoffice.web.controller;

import com.lianyu.tech.core.platform.web.site.cookie.RequireCookie;
import com.lianyu.tech.core.platform.web.site.session.RequireSession;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.HEAD;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.TRACE;

@Controller
@RequireCookie
@RequireSession
public class ResourceNotFoundController extends BackOfficeSiteController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/404", method = {GET, POST, DELETE, HEAD, OPTIONS, PATCH, PUT, TRACE})
    public String resourceNotFound() {
        return "404";
    }

}
