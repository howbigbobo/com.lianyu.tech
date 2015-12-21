package com.lianyu.tech.website.web.controller;

import com.lianyu.tech.common.domain.DescriptionType;
import com.lianyu.tech.website.builder.DescriptionBuilder;
import com.lianyu.tech.website.vo.DescriptionVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/description/{type}", method = RequestMethod.POST)
    public ModelAndView getDescriptionPage(@PathVariable("type") String type, @RequestParam(value = "page", required = false) Integer page, Map<String, Object> model) {
        DescriptionType descriptionType = DescriptionType.fromName(type);
        int pageNumber = page == null || page <= 0 ? 1 : page;
        List<DescriptionVo> descriptionVos = descriptionBuilder.findByType(descriptionType, pageNumber);
        int count = descriptionBuilder.count(descriptionType);
        model.put("descriptionVos", descriptionVos);
        model.put("count", count);
        return new ModelAndView("dreamer/cases.item", model);
    }
}
