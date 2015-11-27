package com.lianyu.tech.website.web.controller;

import com.lianyu.tech.core.platform.web.site.SiteController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author bowen
 */
@Controller
public class ConstructionController extends SiteController {
    @RequestMapping(value = "/construction", method = RequestMethod.GET)
    public String construction() {
        return "construction";
    }
}
