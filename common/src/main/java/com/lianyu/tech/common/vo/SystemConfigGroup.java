package com.lianyu.tech.common.vo;

import java.util.List;

/**
 * @author bowen
 */
public class SystemConfigGroup {
    private String group;
    private String name;
    private List<SystemConfigKey> keys;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SystemConfigKey> getKeys() {
        return keys;
    }

    public void setKeys(List<SystemConfigKey> keys) {
        this.keys = keys;
    }
}
