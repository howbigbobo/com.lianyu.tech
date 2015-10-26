package com.lianyu.tech.common.domain;

import com.lianyu.tech.core.platform.exception.ResourceNotFoundException;

/**
 * @author bowen.zhang
 */
public enum DescriptionType {
    CASES("案例"),
    INTRODUCE("简介"),
    NEWS("动态");

    private String text;

    DescriptionType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static DescriptionType fromName(String name) {
        for (DescriptionType type : values()) {
            if (type.name().equalsIgnoreCase(name)) return type;
        }
        throw new ResourceNotFoundException("unknown type:" + name);
    }


}
