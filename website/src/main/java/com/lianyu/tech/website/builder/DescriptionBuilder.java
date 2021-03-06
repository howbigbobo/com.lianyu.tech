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
import com.lianyu.tech.common.vo.DescriptionItemView;
import com.lianyu.tech.common.vo.converter.DescriptionConverter;
import com.lianyu.tech.common.vo.converter.DescriptionItemConverter;
import com.lianyu.tech.common.vo.converter.ImageConverter;
import com.lianyu.tech.core.platform.exception.ResourceNotFoundException;
import com.lianyu.tech.website.vo.DescriptionVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
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

    public DescriptionVo get(int id) {
        Description description = descriptionRepository.get(Description.class, id);
        if (description == null) {
            throw new ResourceNotFoundException("description not exist. id=" + id);
        }
        List<DescriptionVo> vos = getDescriptionVos(Arrays.asList(description), 100, 0);
        return CollectionUtils.isEmpty(vos) ? new DescriptionVo() : vos.get(0);
    }

    public int count(DescriptionType descriptionType) {
        return descriptionRepository.countByType(descriptionType);
    }

    public List<DescriptionVo> findAllByType(DescriptionType descriptionType) {
        List<Description> descriptions = descriptionRepository.findByType(descriptionType);
        return getDescriptionVos(descriptions, DescriptionConfigFactory.getImageWidth(descriptionType), 0);
    }

    public List<DescriptionVo> findByType(DescriptionType descriptionType) {
        return findByType(descriptionType, 1);
    }

    public List<DescriptionVo> findByType(DescriptionType descriptionType, int page) {
        int size = DescriptionConfigFactory.getPageSize(descriptionType);
        int offset = (page - 1) * size;
        List<Description> descriptions = descriptionRepository.findByType(descriptionType, offset, size);
        return getDescriptionVos(descriptions, DescriptionConfigFactory.getImageWidth(descriptionType), 0);
    }

    private List<DescriptionVo> getDescriptionVos(List<Description> descriptions, int width, int height) {
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
            vo.setItems(DescriptionItemConverter.convert(descriptionItems, images));
            setImageThumbUrl(vo.getItems(), width, height);
            vos.add(vo);
        }
        return vos;
    }

    private void setImageThumbUrl(List<DescriptionItemView> descriptionItems, int width, int height) {
        if (CollectionUtils.isEmpty(descriptionItems)) return;
        for (DescriptionItemView item : descriptionItems) {
            item.setImageThumbUrl(imageConverter.getThumbUrl(item.getImageUrl(), width, height));
        }
    }


}
