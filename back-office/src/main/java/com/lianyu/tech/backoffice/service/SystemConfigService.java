package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.common.domain.SystemConfig;
import com.lianyu.tech.common.repository.SystemConfigRepository;
import com.lianyu.tech.common.vo.SystemConfigGroup;
import com.lianyu.tech.common.vo.SystemConfigKey;
import com.lianyu.tech.common.vo.SystemConfigView;
import com.lianyu.tech.core.platform.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
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

    public List<SystemConfigGroup> findAllGroup() {
        List<SystemConfig> configs = systemConfigRepository.findAll();
        Map<String, SystemConfigGroup> groupMap = new HashMap<>();
        for (SystemConfig config : configs) {
            if (!groupMap.containsKey(config.getGroupName())) {
                groupMap.put(config.getGroupName(), new SystemConfigGroup());
            }
            SystemConfigGroup group = groupMap.get(config.getGroupName());
            group.setName(config.getGroupName());
            group.setText(config.getGroupText());
            group.setOrder(config.getGroupOrder());

            group.getKeys().add(new SystemConfigKey(config.getKeyName(), config.getKeyText(), config.getContent(), config.getKeyOrder()));
        }
        List<SystemConfigGroup> groups = new ArrayList<>(groupMap.values());
        sortGroup(groups);
        return groups;
    }

    private void sortGroup(List<SystemConfigGroup> groups) {
        for (SystemConfigGroup group : groups) {
            Collections.sort(group.getKeys(), new Comparator<SystemConfigKey>() {
                @Override
                public int compare(SystemConfigKey o1, SystemConfigKey o2) {
                    return Integer.compare(o1.getOrder(), o2.getOrder());
                }
            });
        }

        Collections.sort(groups, new Comparator<SystemConfigGroup>() {
            @Override
            public int compare(SystemConfigGroup o1, SystemConfigGroup o2) {
                return Integer.compare(o1.getOrder(), o2.getOrder());
            }
        });
    }

    @Transactional
    public void saveContent(Map<String, String> configMap) {
        SystemConfigView configView = get();
        for (Map.Entry<String, String> entry : configMap.entrySet()) {
            SystemConfig config = configView.getConfig(entry.getKey());
            if (config != null) {
                updateContent(config, entry.getValue());
            } else {
                throw new ResourceNotFoundException("config key not exist, " + entry.getKey());
            }
        }
    }

    private void updateContent(SystemConfig config, String value) {
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

    @Transactional
    public void saveConfig(SystemConfigGroup group) {
        SystemConfigView configView = get();
        List<SystemConfig> configs = buildConfig(group);
        for (SystemConfig config : configs) {
            SystemConfig existConfig = configView.getConfig(config.fullKey());
            if (existConfig == null) {

            } else {
                addConfig(config);
            }
        }
    }

    private List<SystemConfig> buildConfig(SystemConfigGroup group) {
        List<SystemConfig> configs = new ArrayList<>(group.getKeys().size());
        for (SystemConfigKey key : group.getKeys()) {
            SystemConfig config = new SystemConfig();
            config.setGroupName(group.getName());
            config.setGroupText(group.getText());
            config.setGroupOrder(group.getOrder());
            config.setKeyName(key.getName());
            config.setKeyText(key.getText());
            config.setKeyOrder(key.getOrder());
            configs.add(config);
        }
        return configs;
    }

    private void updateConfig(SystemConfig existConfig, SystemConfig config) {
        existConfig.setGroupName(config.getGroupName());
        existConfig.setGroupText(config.getGroupText());
        existConfig.setGroupOrder(config.getGroupOrder());
        existConfig.setKeyName(config.getKeyName());
        existConfig.setKeyText(config.getKeyText());
        existConfig.setKeyOrder(config.getKeyOrder());
        existConfig.setUpdateUser("");
        existConfig.setUpdateTime(new Date());
        systemConfigRepository.update(existConfig);
    }

    private void addConfig(SystemConfig config) {
        config.setUpdateUser("");
        config.setUpdateTime(new Date());
        config.setCreateTime(new Date());
        config.setCreateUser("");
        config.setContent("");
        systemConfigRepository.create(config);
    }
}
