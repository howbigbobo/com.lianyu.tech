package com.lianyu.tech.backoffice.web.controller.description;

import com.lianyu.tech.backoffice.service.DescriptionService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeSiteController;
import com.lianyu.tech.common.domain.DescriptionType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author bowen
 */
@Controller
public class DescriptionController extends BackOfficeSiteController {
    @Inject
    private DescriptionService descriptionService;

    @RequestMapping(value = "/description/{type}", method = RequestMethod.GET)
    public String list(Map<String, Object> model, @PathVariable("type") String type) {
        DescriptionType descriptionType = DescriptionType.fromName(type);
        model.put("type", descriptionType.name().toLowerCase());
        return "description/description.list";
    }
}
