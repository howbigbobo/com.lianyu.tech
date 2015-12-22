package com.lianyu.tech.website.builder;

import com.lianyu.tech.common.domain.DescriptionType;

/**
 * @author bowen
 */
public class DescriptionConfigFactory {
    
    public static int getImageWidth(DescriptionType type) {
        switch (type) {
            case INTRODUCE:
                return 225;
        }
        return 310;
    }

    public static int getPageSize(DescriptionType type) {
        switch (type) {
            case INTRODUCE:
                return 9;
            case SERVICE:
                return 9;
            case NEWS:
                return 6;
            case CASES:
                return 6;
        }
        return 6;
    }
}
