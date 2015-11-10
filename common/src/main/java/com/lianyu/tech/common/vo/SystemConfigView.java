package com.lianyu.tech.common.vo;

import com.lianyu.tech.common.domain.SystemConfig;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bowen
 */
public class SystemConfigView implements Serializable {
    private static final long serialVersionUID = 3606379366237106079L;

    private Map<String, SystemConfig> configMap;
    private int size;

    public SystemConfigView(List<SystemConfig> systemConfigs) {
        size = systemConfigs.size();
        configMap = new HashMap<>(size, 1);
        for (SystemConfig systemConfig : systemConfigs) {
            configMap.put(buildKey(systemConfig), systemConfig);
        }
    }

    public String get(String key) {
        String lowerKey = key.toLowerCase();
        SystemConfig config = configMap.get(lowerKey);
        return config == null ? "" : config.getContent();
    }

    public SystemConfig getConfig(String key) {
        String lowerKey = key.toLowerCase();
        return configMap.get(lowerKey);
    }

    public boolean contain(String key) {
        String lowerKey = key.toLowerCase();
        return configMap.containsKey(lowerKey);
    }

    public int getSize() {
        return size;
    }

    private String buildKey(SystemConfig systemConfig) {
        return (systemConfig.getGroupName() + "." + systemConfig.getKeyName()).toLowerCase();
    }
}
