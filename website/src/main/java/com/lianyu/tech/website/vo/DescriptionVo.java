package com.lianyu.tech.website.vo;

import com.lianyu.tech.common.vo.DescriptionItemView;
import com.lianyu.tech.common.vo.DescriptionView;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author bowen
 */
public class DescriptionVo {
    private DescriptionView info;
    private List<DescriptionItemView> items;
    private DescriptionItemView defaultItem;

    public DescriptionView getInfo() {
        return info;
    }

    public void setInfo(DescriptionView info) {
        this.info = info;
    }

    public List<DescriptionItemView> getItems() {
        return items;
    }

    public void setItems(List<DescriptionItemView> items) {
        this.items = items;
        defaultItem = CollectionUtils.isEmpty(items) ? null : items.get(0);
    }

    public DescriptionItemView getDefaultItem() {
        return defaultItem;
    }

    public void setDefaultItem(DescriptionItemView defaultItem) {
        this.defaultItem = defaultItem;
    }
}
