package com.lianyu.tech.common.vo;

/**
 * @author bowen
 */
public class SystemConfigKey {

    private String group;
    private String key;
    private String name;

    public SystemConfigKey(String group, String key, String name) {
        this.group = group;
        this.key = key;
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullKey() {
        return group + "." + key;
    }
}
