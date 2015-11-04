package com.lianyu.tech.backoffice.web.controller.description;

import com.lianyu.tech.backoffice.service.DescriptionItemService;
import com.lianyu.tech.backoffice.service.DescriptionService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import com.lianyu.tech.common.vo.converter.DescriptionConverter;
import com.lianyu.tech.backoffice.web.request.DescriptionListRequest;
import com.lianyu.tech.backoffice.web.request.DescriptionRequest;
import com.lianyu.tech.backoffice.web.response.DescriptionListResponse;
import com.lianyu.tech.common.domain.Description;
import com.lianyu.tech.common.domain.DescriptionType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Inject
    private DescriptionItemService descriptionItemService;

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

    @ResponseBody
    @RequestMapping(value = "/description/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable("id") int id) {
        descriptionService.delete(id);
        descriptionItemService.deleteByDescriptionId(id);
    }

    @ResponseBody
    @RequestMapping(value = "/description/save", method = RequestMethod.POST)
    public Integer saveDescription(@RequestBody DescriptionRequest request) {
        Description description = new Description();
        description.setId(request.getId());
        description.setType(request.getType());
        description.setHead(request.getHead());
        description.setSubhead(request.getSubhead());
        description.setBeginTime(request.getBeginTime());
        description.setEndTime(request.getEndTime());
        description.setLocation(request.getLocation());
        description.setContent(request.getContent());
        descriptionService.save(description);
        return description.getId();
    }
}
