package com.lianyu.tech.backoffice.web.converter;

import com.lianyu.tech.backoffice.web.vo.DescriptionView;
import com.lianyu.tech.common.domain.Description;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author bowen
 */
public abstract class DescriptionConverter {
    public static DescriptionView convert(Description description) {
        if (description == null) return null;
        DescriptionView view = new DescriptionView();
        view.setId(description.getId());
        view.setType(description.getType());
        view.setHead(description.getHead());
        view.setSubhead(description.getSubhead());
        view.setDescTime(description.getDescTime());
        view.setLocation(description.getLocation());
        view.setContent(description.getContent());
        return view;
    }

    public static List<DescriptionView> convert(List<Description> descriptions) {
        if (CollectionUtils.isEmpty(descriptions)) return Collections.EMPTY_LIST;
        List<DescriptionView> descriptionViews = new ArrayList<>(descriptions.size());
        for (Description description : descriptions) {
            descriptionViews.add(convert(description));
        }
        return descriptionViews;
    }
}
