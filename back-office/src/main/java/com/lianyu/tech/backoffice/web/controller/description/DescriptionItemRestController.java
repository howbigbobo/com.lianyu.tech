package com.lianyu.tech.backoffice.web.controller.description;

import com.lianyu.tech.backoffice.service.DescriptionItemService;
import com.lianyu.tech.backoffice.service.ImageService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import com.lianyu.tech.backoffice.web.converter.DescriptionItemConverter;
import com.lianyu.tech.backoffice.web.converter.ImageConverter;
import com.lianyu.tech.backoffice.web.request.DescriptionItemOrderRequest;
import com.lianyu.tech.backoffice.web.request.DescriptionItemRequest;
import com.lianyu.tech.backoffice.web.vo.DescriptionItemView;
import com.lianyu.tech.common.domain.DescriptionItem;
import com.lianyu.tech.common.domain.Image;
import com.lianyu.tech.common.utils.Converter;
import com.lianyu.tech.common.utils.ListUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.inject.Inject;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bowen
 */
@Controller
public class DescriptionItemRestController extends BackOfficeRestController {
    @Inject
    private DescriptionItemService descriptionItemService;
    @Inject
    private ImageService imageService;
    @Inject
    private ImageConverter imageConverter;

    @ResponseBody
    @RequestMapping(value = "/description/item/save", method = RequestMethod.POST)
    public void add(@Valid DescriptionItemRequest request, MultipartHttpServletRequest imageRequest) throws IOException {

    }

    @ResponseBody
    @RequestMapping(value = "/description/item/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable("id") Integer id) {
        descriptionItemService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/description/item/order/update", method = RequestMethod.POST)
    public void updateOrder(@RequestBody DescriptionItemOrderRequest request) {

    }

    @ResponseBody
    @RequestMapping(value = "/description/item/list/{descriptionId}", method = RequestMethod.POST)
    public Map<String, Object> listItems(@PathVariable("descriptionId") Integer descriptionId) {
        List<DescriptionItemView> list = buildDescriptionItemViews(descriptionId);
        Map<String, Object> map = new HashMap<>(1, 1);
        map.put("descriptionItems", list);
        return map;
    }

    private List<DescriptionItemView> buildDescriptionItemViews(Integer descriptionId) {
        List<DescriptionItem> items = descriptionItemService.findByDescriptionId(descriptionId);
        if (CollectionUtils.isEmpty(items)) return Collections.EMPTY_LIST;
        List<Integer> imageIds = ListUtils.select(items, new Converter<DescriptionItem, Integer>() {
            @Override
            public Integer convert(DescriptionItem item) {
                return item.getImageId();
            }
        });
        List<Image> images = imageService.findByIds(imageIds);
        imageConverter.buildImageFullUrl(images);
        List<DescriptionItemView> itemViews = DescriptionItemConverter.convert(items, images);
        return itemViews;
    }
}
