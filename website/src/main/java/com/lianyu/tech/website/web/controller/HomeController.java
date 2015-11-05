package com.lianyu.tech.website.web.controller;

import com.lianyu.tech.common.domain.DescriptionType;
import com.lianyu.tech.website.builder.DescriptionBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Map;


@Controller
public class HomeController extends WebsiteSiteController {

    @Inject
    private DescriptionBuilder descriptionBuilder;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        model.put("introduce", descriptionBuilder.findByType(DescriptionType.INTRODUCE));
        return "dreamer/home";
    }
}