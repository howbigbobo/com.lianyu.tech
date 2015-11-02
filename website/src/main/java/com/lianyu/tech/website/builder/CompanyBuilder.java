package com.lianyu.tech.website.builder;

import com.lianyu.tech.common.domain.CompanyInfo;
import com.lianyu.tech.common.repository.CompanyInfoRepository;
import com.lianyu.tech.website.vo.CompanyView;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author bowen
 */
@Service
public class CompanyBuilder {
    @Inject
    private CompanyInfoRepository companyInfoRepository;

    public CompanyView get() {
        CompanyInfo companyInfo = companyInfoRepository.get();
        return convert(companyInfo);
    }

    private CompanyView convert(CompanyInfo companyInfo) {
        if (companyInfo == null) return new CompanyView();
        CompanyView view = new CompanyView();
        view.setId(companyInfo.getId());
        view.setDomain(companyInfo.getDomain());
        view.setLogoUrl(companyInfo.getLogoUrl());
        view.setName(companyInfo.getName());
        view.setSlogan(companyInfo.getSlogan());
        return view;
    }
}
