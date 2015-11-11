package com.lianyu.tech.common.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bowen
 */
public class SystemConfigGroup {
    private String name;
    private String text;
    private int order;
    private List<SystemConfigKey> keys = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<SystemConfigKey> getKeys() {
        return keys;
    }

    public void setKeys(List<SystemConfigKey> keys) {
        this.keys = keys;
    }
}
