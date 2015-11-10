package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.common.domain.SystemConfig;
import com.lianyu.tech.common.repository.SystemConfigRepository;
import com.lianyu.tech.common.vo.SystemConfigView;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author bowen
 */
@Service
public class SystemConfigService {
    @Inject
    private SystemConfigRepository systemConfigRepository;

    public SystemConfigView get() {
        List<SystemConfig> configs = systemConfigRepository.findAll();
        return new SystemConfigView(configs);
    }

    @Transactional
    public void save(Map<String, String> configMap) {
        SystemConfigView configView = get();
        for (Map.Entry<String, String> entry : configMap.entrySet()) {
            SystemConfig config = configView.getConfig(entry.getKey());
            if (config != null) {
                update(config, entry.getValue());
            } else {
                add(entry.getKey(), entry.getValue());
            }
        }
    }

    private void update(SystemConfig config, String value) {
        if ((config.getContent() == null && value == null) || config.getContent().equals(value)) return;
        config.setContent(value);
        config.setUpdateUser("");
        config.setUpdateTime(new Date());
        systemConfigRepository.update(config);
    }

    private void add(String key, String value) {
        String[] groupKey = key.split("\\.");
        SystemConfig config = new SystemConfig();
        config.setUpdateUser("");
        config.setUpdateTime(new Date());
        config.setCreateTime(new Date());
        config.setCreateUser("");
        config.setContent(value);
        config.setGroupName(groupKey[0]);
        config.setKeyName(groupKey[1]);
        systemConfigRepository.create(config);
    }
}
