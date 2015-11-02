package com.lianyu.tech.website.builder.converter;

import com.lianyu.tech.common.domain.DescriptionItem;
import com.lianyu.tech.common.domain.Image;
import com.lianyu.tech.common.utils.Converter;
import com.lianyu.tech.common.utils.ListUtils;
import com.lianyu.tech.website.vo.DescriptionItemView;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author bowen
 */
public abstract class DescriptionItemConverter {
    public static DescriptionItemView convert(DescriptionItem item, Image image) {
        if (item == null) return null;
        DescriptionItemView view = new DescriptionItemView();
        view.setId(item.getId());
        view.setDescriptionId(item.getDescriptionId());
        view.setImageId(item.getImageId());
        view.setImageUrl(image == null ? "" : image.getUrl());
        view.setContent(item.getContent());
        view.setDisplayOrder(item.getDisplayOrder());
        return view;
    }

    public static List<DescriptionItemView> convert(List<DescriptionItem> items, List<Image> images) {
        if (CollectionUtils.isEmpty(items)) return Collections.EMPTY_LIST;
        Map<Integer, Image> imageMap = ListUtils.toMap(images, new Converter<Image, Integer>() {
            @Override
            public Integer convert(Image image) {
                return image.getId();
            }
        });

        List<DescriptionItemView> views = new ArrayList<>(items.size());
        for (DescriptionItem item : items) {
            views.add(convert(item, imageMap.containsKey(item.getImageId()) ? imageMap.get(item.getImageId()) : null));
        }
        return views;
    }


}
