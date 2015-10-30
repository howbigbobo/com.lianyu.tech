package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.common.domain.DescriptionItem;
import com.lianyu.tech.common.repository.DescriptionItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author bowen
 */
@Service
public class DescriptionItemService {
    @Inject
    private DescriptionItemRepository descriptionItemRepository;

    @Transactional
    public void save(DescriptionItem item) {
        if (item == null) return;
        DescriptionItem existItem = null;
        if (item.getId() != null && item.getId() > 0) {
            existItem = descriptionItemRepository.get(DescriptionItem.class, item.getId());
        }
        if (existItem != null) {
            update(item, existItem);
        } else {
            create(item);
        }
    }

    private void update(DescriptionItem item, DescriptionItem existItem) {
        existItem.setUpdateTime(new Date());
        existItem.setUpdateUser("");
        existItem.setContent(item.getContent());
        existItem.setImageId(item.getImageId());
        descriptionItemRepository.update(existItem);
    }

    private void create(DescriptionItem item) {
        item.setCreateUser("");
        item.setCreateTime(new Date());
        item.setUpdateTime(new Date());
        item.setUpdateUser("");
        descriptionItemRepository.create(item);
    }

    @Transactional
    public void updateOrder(int id, int order) {
        DescriptionItem existItem = descriptionItemRepository.get(DescriptionItem.class, id);
        if (existItem != null) {
            existItem.setDisplayOrder(order);
            existItem.setUpdateTime(new Date());
            existItem.setUpdateUser("");
            descriptionItemRepository.update(existItem);
        }
    }

    @Transactional
    public void delete(Integer id) {
        DescriptionItem existItem = descriptionItemRepository.get(DescriptionItem.class, id);
        if (existItem != null) {
            descriptionItemRepository.delete(existItem);
        }
    }

    @Transactional
    public void deleteByDescriptionId(Integer descriptionId) {
        List<DescriptionItem> list = descriptionItemRepository.findByDescriptionId(descriptionId);
        if (!CollectionUtils.isEmpty(list)) {
            for (DescriptionItem item : list) {
                descriptionItemRepository.delete(item);
            }
        }
    }

    public List<DescriptionItem> findByDescriptionId(Integer descriptionId) {
        return descriptionItemRepository.findByDescriptionId(descriptionId);
    }
}
