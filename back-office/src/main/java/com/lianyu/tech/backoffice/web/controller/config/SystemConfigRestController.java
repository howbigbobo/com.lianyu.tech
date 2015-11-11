package com.lianyu.tech.backoffice.web.controller.config;

import com.lianyu.tech.backoffice.service.SystemConfigService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import com.lianyu.tech.common.vo.SystemConfigGroup;
import com.lianyu.tech.common.vo.SystemConfigKey;
import com.lianyu.tech.core.platform.exception.InvalidRequestException;
import com.lianyu.tech.core.util.StringUtils;
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
        systemConfigService.saveContent(request);
    }

    @ResponseBody
    @RequestMapping(value = "/config/text/save", method = RequestMethod.POST)
    public void save(@RequestBody SystemConfigGroup request) {
        if (!StringUtils.hasText(request.getName()) || !StringUtils.hasText(request.getText())) {
            throw new InvalidRequestException("配置组名称和中文名不能为空");
        }
        if (CollectionUtils.isEmpty(request.getKeys())) {
            throw new InvalidRequestException("至少需要一个配置项");
        }
        for (SystemConfigKey key : request.getKeys()) {
            if (!StringUtils.hasText(key.getName()) || !StringUtils.hasText(key.getText())) {
                throw new InvalidRequestException("配置项名称和中文名不能为空");
            }
        }

        systemConfigService.saveConfig(request);
    }
}
