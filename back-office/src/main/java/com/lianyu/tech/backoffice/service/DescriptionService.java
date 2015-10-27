package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.common.domain.Description;
import com.lianyu.tech.common.domain.DescriptionType;
import com.lianyu.tech.common.repository.DescriptionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author bowen.zhang
 */
@Service
public class DescriptionService {
    @Inject
    private DescriptionRepository descriptionRepository;

    public List<Description> findByType(DescriptionType descriptionType, int offset, int size) {
        return descriptionRepository.findByType(descriptionType, offset, size);
    }

    public int countByType(DescriptionType descriptionType) {
        return descriptionRepository.countByType(descriptionType);
    }

    @Transactional
    public Description save(Description description) {
        Description existDescription = null;
        if (description.getId() != null && description.getId() > 0) {
            existDescription = get(description.getId());
        }
        if (existDescription != null) {
            update(existDescription, description);
            return existDescription;
        } else {
            create(description);
            return description;
        }
    }

    private void update(Description existDescription, Description description) {
        existDescription.setEndTime(description.getEndTime());
        existDescription.setBeginTime(description.getBeginTime());
        existDescription.setContent(description.getContent());
        existDescription.setHead(description.getHead());
        existDescription.setSubhead(description.getSubhead());
        existDescription.setLocation(description.getLocation());
        existDescription.setUpdateTime(new Date());
        existDescription.setUpdateUser("");
        descriptionRepository.update(existDescription);
    }

    private void create(Description description) {
        description.setUpdateTime(new Date());
        description.setCreateUser("");
        description.setUpdateUser("");
        description.setCreateTime(new Date());
        descriptionRepository.create(description);
    }

    public Description get(Integer id) {
        if (id == null) return null;
        return descriptionRepository.get(Description.class, id);
    }

    @Transactional
    public void delete(Integer id) {
        Description description = get(id);
        if (description != null) {
            descriptionRepository.delete(description);
        }
    }
}
