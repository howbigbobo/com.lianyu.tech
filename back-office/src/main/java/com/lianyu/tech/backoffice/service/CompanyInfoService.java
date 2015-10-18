package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.common.domain.CompanyInfo;
import com.lianyu.tech.common.repository.CompanyInfoRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author bowen.zhang
 */
@Service
public class CompanyInfoService {
    @Inject
    private CompanyInfoRepository companyInfoRepository;

    public CompanyInfo get() {
        return companyInfoRepository.get();
    }

    @Transactional
    public void save(CompanyInfo companyInfo) {
        Integer id = companyInfo.getId();
        CompanyInfo existsCompanyInfo = companyInfoRepository.get(id);
        if (existsCompanyInfo != null) {
            existsCompanyInfo.setName(companyInfo.getName());
            existsCompanyInfo.setLogoUrl(companyInfo.getLogoUrl());
            existsCompanyInfo.setDomain(companyInfo.getDomain());
            existsCompanyInfo.setSlogan(companyInfo.getSlogan());
            existsCompanyInfo.setUpdateUser("");
            existsCompanyInfo.setUpdateTime(new Date());
            companyInfoRepository.update(existsCompanyInfo);
        } else {
            companyInfo.setCreateUser("");
            companyInfo.setCreateTime(new Date());
            companyInfo.setUpdateUser("");
            companyInfo.setUpdateTime(new Date());
            companyInfoRepository.create(companyInfo);
        }
    }
}
