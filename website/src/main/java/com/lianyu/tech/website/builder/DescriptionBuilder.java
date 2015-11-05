package com.lianyu.tech.website.builder;

import com.lianyu.tech.common.domain.Description;
import com.lianyu.tech.common.domain.DescriptionItem;
import com.lianyu.tech.common.domain.DescriptionType;
import com.lianyu.tech.common.domain.Image;
import com.lianyu.tech.common.repository.DescriptionItemRepository;
import com.lianyu.tech.common.repository.DescriptionRepository;
import com.lianyu.tech.common.repository.ImageRepository;
import com.lianyu.tech.common.utils.Converter;
import com.lianyu.tech.common.utils.ListUtils;
import com.lianyu.tech.common.vo.converter.DescriptionConverter;
import com.lianyu.tech.common.vo.converter.DescriptionItemConverter;
import com.lianyu.tech.common.vo.converter.ImageConverter;
import com.lianyu.tech.website.vo.DescriptionVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author bowen
 */
@Service
public class DescriptionBuilder {
    @Inject
    private DescriptionRepository descriptionRepository;
    @Inject
    private DescriptionItemRepository descriptionItemRepository;
    @Inject
    private ImageRepository imageRepository;
    @Inject
    private ImageConverter imageConverter;

    public List<DescriptionVo> findByType(DescriptionType descriptionType) {
        List<Description> descriptions = descriptionRepository.findByType(descriptionType);
        if (CollectionUtils.isEmpty(descriptions)) return Collections.EMPTY_LIST;

        List<Integer> descriptionIds = ListUtils.select(descriptions, new Converter<Description, Integer>() {
            @Override
            public Integer convert(Description description) {
                return description.getId();
            }
        });

        List<DescriptionItem> items = descriptionItemRepository.findByDescriptionIds(descriptionIds);
        Map<Integer, List<DescriptionItem>> itemMap = ListUtils.groupBy(items, new Converter<DescriptionItem, Integer>() {
            @Override
            public Integer convert(DescriptionItem item) {
                return item.getDescriptionId();
            }
        });

        List<Integer> imageIds = ListUtils.distinctSelect(items, new Converter<DescriptionItem, Integer>() {
            @Override
            public Integer convert(DescriptionItem item) {
                return item.getImageId();
            }
        });
        List<Image> images = imageRepository.findByIds(imageIds);
        imageConverter.buildImageFullUrl(images);

        List<DescriptionVo> vos = new ArrayList<>(descriptions.size());
        for (Description description : descriptions) {
            DescriptionVo vo = new DescriptionVo();
            vo.setInfo(DescriptionConverter.convert(description));
            List<DescriptionItem> descriptionItems = itemMap.get(description.getId());
            vo.setItems(DescriptionItemConverter.convert(items, images));
            vos.add(vo);
        }
        return vos;
    }

}
