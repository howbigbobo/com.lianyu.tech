package com.lianyu.tech.backoffice.web.response;

import com.lianyu.tech.backoffice.web.vo.DescriptionView;

import java.util.List;

/**
 * @author bowen
 */
public class DescriptionListResponse extends PageResponse {
    
    List<DescriptionView> descriptions;

    public List<DescriptionView> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<DescriptionView> descriptions) {
        this.descriptions = descriptions;
    }
}
