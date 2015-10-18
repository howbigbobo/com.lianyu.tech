package com.lianyu.tech.backoffice.web.controller.company;

import com.lianyu.tech.backoffice.service.CompanyInfoService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import com.lianyu.tech.backoffice.web.request.CompanyInfoRequest;
import com.lianyu.tech.common.domain.CompanyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * @author bowen.zhang
 */
@Controller
public class CompanyInfoRestController extends BackOfficeRestController {
    @Inject
    private CompanyInfoService companyInfoService;

    @ResponseBody
    @RequestMapping(value = "/company/save", method = RequestMethod.POST)
    public void saveCompanyInfo(@Valid @RequestBody CompanyInfoRequest request) {
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setId(request.getId());
        companyInfo.setName(request.getName());
        companyInfo.setSlogan(request.getSlogan());
        companyInfo.setLogoUrl(request.getLogoUrl());
        companyInfo.setDomain(request.getDomain());

        companyInfoService.save(companyInfo);
    }
}
