package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.common.domain.Description;
import com.lianyu.tech.common.domain.DescriptionType;
import com.lianyu.tech.common.repository.DescriptionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
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
}
