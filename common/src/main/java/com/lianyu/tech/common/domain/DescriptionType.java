package com.lianyu.tech.common.domain;

import com.lianyu.tech.core.platform.exception.ResourceNotFoundException;

/**
 * @author bowen.zhang
 */
public enum DescriptionType {
    CASES,
    INTRODUCE,
    NEWS;

    public static DescriptionType fromName(String name) {
        for (DescriptionType type : values()) {
            if (type.name().equalsIgnoreCase(name)) return type;
        }
        throw new ResourceNotFoundException("unknown type:" + name);
    }
}
