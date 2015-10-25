package com.lianyu.tech.backoffice.web.controller.description;

import com.lianyu.tech.backoffice.service.DescriptionService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import com.lianyu.tech.backoffice.web.converter.DescriptionConverter;
import com.lianyu.tech.backoffice.web.request.DescriptionListRequest;
import com.lianyu.tech.backoffice.web.response.DescriptionListResponse;
import com.lianyu.tech.common.domain.Description;
import com.lianyu.tech.common.domain.DescriptionType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * @author bowen
 */
@Controller
public class DescriptionRestController extends BackOfficeRestController {

    @Inject
    private DescriptionService descriptionService;

    @ResponseBody
    @RequestMapping(value = "/description/list", method = RequestMethod.POST)
    public DescriptionListResponse list(@RequestBody DescriptionListRequest pageRequest) {
        DescriptionType descriptionType = DescriptionType.fromName(pageRequest.getType());
        List<Description> descriptions = descriptionService.findByType(descriptionType, pageRequest.getOffset(), pageRequest.getPageSize());
        DescriptionListResponse response = new DescriptionListResponse();
        response.setDescriptions(DescriptionConverter.convert(descriptions));
        response.setPageNo(pageRequest.getPage());
        response.setPageSize(pageRequest.getPageSize());
        response.setTotalCount(descriptionService.countByType(descriptionType));
        return response;
    }
}