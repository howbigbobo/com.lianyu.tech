package com.lianyu.tech.website.web.controller;

import com.lianyu.tech.website.builder.DescriptionBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author bowen
 */
@Controller
public class DescriptionController extends WebsiteSiteController {

    @Inject
    private DescriptionBuilder descriptionBuilder;

    @RequestMapping(value = "/description/{id}", method = RequestMethod.GET)
    public ModelAndView getDescription(@PathVariable("id") int descriptionId, Map<String, Object> model) {
        model.put("descriptionVo", descriptionBuilder.get(descriptionId));
        return new ModelAndView("dreamer/slider.content1.ftl", model);
    }
}