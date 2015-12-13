package com.lianyu.tech.website.web.controller;

import com.lianyu.tech.website.builder.DescriptionBuilder;
import com.lianyu.tech.website.vo.DescriptionVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * @author bowen
 */
@Controller
public class DescriptionRestController extends WebsiteRestController {

    @Inject
    private DescriptionBuilder descriptionBuilder;

    @ResponseBody
    @RequestMapping(value = "/description/{id}", method = RequestMethod.POST)
    public DescriptionVo getDescription(@PathVariable("id") int descriptionId) {
        return descriptionBuilder.get(descriptionId);
    }
}
