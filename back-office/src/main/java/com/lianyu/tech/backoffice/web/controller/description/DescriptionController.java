package com.lianyu.tech.backoffice.web.controller.description;

import com.lianyu.tech.backoffice.service.DescriptionService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeSiteController;
import com.lianyu.tech.common.domain.Description;
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
        buildDescriptionTypeModel(model, descriptionType);
        return "description/description.list";
    }

    @RequestMapping(value = "/description/{type}/{id}", method = RequestMethod.GET)
    public String detail(Map<String, Object> model, @PathVariable("type") String type, @PathVariable("id") Integer id) {
        DescriptionType descriptionType = DescriptionType.fromName(type);
        buildDescriptionTypeModel(model, descriptionType);
        return "description/description.detail";
    }

    @RequestMapping(value = "/description/{type}/add", method = RequestMethod.GET)
    public String add(Map<String, Object> model, @PathVariable("type") String type) {
        DescriptionType descriptionType = DescriptionType.fromName(type);
        buildDescriptionTypeModel(model, descriptionType);
        return "description/description.edit";
    }

    @RequestMapping(value = "/description/{type}/edit/{id}", method = RequestMethod.GET)
    public String edit(Map<String, Object> model, @PathVariable("type") String type, @PathVariable("id") Integer id) {

        Description description = descriptionService.get(id);
        if (description == null) {
            return "redirect:/description/" + type.toLowerCase() + "/add";
        }

        DescriptionType descriptionType = DescriptionType.fromName(type);
        buildDescriptionTypeModel(model, descriptionType);
        model.put("descriptionId", id);
        model.put("description", description);
        return "description/description.edit";
    }


    private void buildDescriptionTypeModel(Map<String, Object> model, DescriptionType type) {
        model.put("type", type.name().toLowerCase());
        model.put("descText", type.getText().toLowerCase());
    }
}
