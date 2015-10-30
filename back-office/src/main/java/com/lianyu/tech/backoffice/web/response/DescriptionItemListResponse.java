package com.lianyu.tech.backoffice.web.response;

import com.lianyu.tech.backoffice.web.vo.DescriptionItemView;

import java.util.List;

/**
 * @author bowen
 */
public class DescriptionItemListResponse {
    private List<DescriptionItemView> items;

    public List<DescriptionItemView> getItems() {
        return items;
    }

    public void setItems(List<DescriptionItemView> items) {
        this.items = items;
    }

    public DescriptionItemListResponse(List<DescriptionItemView> items) {
        this.items = items;
    }

    public DescriptionItemListResponse() {
    }
}
