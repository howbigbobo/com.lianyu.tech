package com.lianyu.tech.backoffice.web.controller.config;

import com.lianyu.tech.backoffice.service.SystemConfigService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeSiteController;
import com.lianyu.tech.common.vo.SystemConfigs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author bowen
 */
@Controller
public class SystemConfigController extends BackOfficeSiteController {
    @Inject
    private SystemConfigService systemConfigService;

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String config(Map<String, Object> model) {
        model.put("config", systemConfigService.get());
        model.put("configGroups", SystemConfigs.getInstance().getGroups());
        return "config/config.edit";
    }
}
