package com.lianyu.tech.backoffice.web.controller.company;

import com.lianyu.tech.backoffice.service.CompanyInfoService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeSiteController;
import com.lianyu.tech.common.domain.CompanyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author bowen.zhang
 */
@Controller
public class CompanyInfoController extends BackOfficeSiteController {

    @Inject
    private CompanyInfoService companyInfoService;

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String companyInfo(Map<String, Object> model) {
        return "company/company.info";
    }

    @RequestMapping(value = "/company/edit", method = RequestMethod.GET)
    public String companyInfoEdit(Map<String, Object> model) {
        CompanyInfo companyInfo = companyInfoService.get();
        if (companyInfo == null) companyInfo = new CompanyInfo();
        model.put("company", companyInfo);
        return "company/company.edit";
    }
}
