package com.lianyu.tech.backoffice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author bowen.zhang
 */
@Controller
public class ExampleController extends BackOfficeSiteController {
    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String example() {
        return "example";
    }
}
