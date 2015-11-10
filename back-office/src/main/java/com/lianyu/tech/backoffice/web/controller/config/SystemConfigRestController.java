package com.lianyu.tech.backoffice.web.controller.config;

import com.lianyu.tech.backoffice.service.SystemConfigService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author bowen
 */
@Controller
public class SystemConfigRestController extends BackOfficeRestController {
    @Inject
    private SystemConfigService systemConfigService;

    @ResponseBody
    @RequestMapping(value = "/config/save", method = RequestMethod.POST)
    public void save(@RequestBody Map<String, String> request) {
        if (CollectionUtils.isEmpty(request)) return;
        systemConfigService.save(request);
    }
}
