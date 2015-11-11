package com.lianyu.tech.website.builder;

import com.lianyu.tech.common.domain.SystemConfig;
import com.lianyu.tech.common.repository.SystemConfigRepository;
import com.lianyu.tech.common.vo.SystemConfigView;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author bowen
 */
@Service
public class SystemConfigBuilder {

    @Inject
    private SystemConfigRepository systemConfigRepository;

    public SystemConfigView get() {
        List<SystemConfig> configs = systemConfigRepository.findAll();
        return new SystemConfigView(configs);
    }
}
