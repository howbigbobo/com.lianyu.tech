package com.lianyu.tech.backoffice.web.controller.description;

import com.lianyu.tech.backoffice.image.ImageEntity;
import com.lianyu.tech.backoffice.image.file.ImagePathUtil;
import com.lianyu.tech.backoffice.service.DescriptionItemService;
import com.lianyu.tech.backoffice.service.ImageFacadeService;
import com.lianyu.tech.backoffice.service.ImageService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import com.lianyu.tech.backoffice.web.request.DescriptionItemRequest;
import com.lianyu.tech.backoffice.web.response.DescriptionItemListResponse;
import com.lianyu.tech.common.domain.DescriptionItem;
import com.lianyu.tech.common.domain.Image;
import com.lianyu.tech.common.utils.Converter;
import com.lianyu.tech.common.utils.ListUtils;
import com.lianyu.tech.common.vo.DescriptionItemView;
import com.lianyu.tech.common.vo.converter.DescriptionItemConverter;
import com.lianyu.tech.common.vo.converter.ImageConverter;
import com.lianyu.tech.core.platform.exception.InvalidRequestException;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.inject.Inject;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    @Inject
    private ImageFacadeService imageFacadeService;

    @ResponseBody
    @RequestMapping(value = "/description/item/save", method = RequestMethod.POST)
    public DescriptionItemListResponse add(@Valid DescriptionItemRequest request, MultipartHttpServletRequest imageRequest) throws IOException {
        List<ImageEntity> imageEntities = getImageEntity(imageRequest);

        Image image = null;
        for (ImageEntity imageEntity : imageEntities) {
            image = imageFacadeService.add(imageEntity);
        }
        if (image == null && !StringUtils.hasText(request.getContent())) {
            throw new InvalidRequestException("图片和描述必须填写一个");
        }

        DescriptionItem item = convertDescriptionItem(request);
        if (image != null) item.setImageId(image.getId());

        descriptionItemService.save(item);

        imageConverter.buildImageFullUrl(Arrays.asList(image));

        DescriptionItemListResponse response = new DescriptionItemListResponse();
        response.setItems(Arrays.asList(DescriptionItemConverter.convert(item, image)));
        return response;
    }

    private DescriptionItem convertDescriptionItem(DescriptionItemRequest request) {
        DescriptionItem item = new DescriptionItem();
        item.setId(request.getId());
        item.setContent(request.getContent());
        item.setDescriptionId(request.getDescriptionId());
        item.setDisplayOrder(request.getDisplayOrder());
        return item;
    }

    @ResponseBody
    @RequestMapping(value = "/description/item/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable("id") Integer id) {
        descriptionItemService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/description/item/{id}/order/{order}", method = RequestMethod.POST)
    public void updateOrder(@PathVariable("id") int id, @PathVariable("order") int order) {
        descriptionItemService.updateOrder(id, order);
    }

    @ResponseBody
    @RequestMapping(value = "/description/item/update", method = RequestMethod.POST)
    public void update(@RequestBody DescriptionItemRequest request) {
        if ((request.getImageId() == null || request.getImageId() == 0) && !StringUtils.hasText(request.getContent())) {
            throw new InvalidRequestException("图片和描述至少要填写一个");
        }
        DescriptionItem item = convertDescriptionItem(request);
        descriptionItemService.save(item);
    }

    @ResponseBody
    @RequestMapping(value = "/description/item/list/{descriptionId}", method = RequestMethod.POST)
    public DescriptionItemListResponse listItems(@PathVariable("descriptionId") Integer descriptionId) {
        List<DescriptionItemView> list = buildDescriptionItemViews(descriptionId);
        return new DescriptionItemListResponse(list);
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
        return DescriptionItemConverter.convert(items, images);
    }

    private List<ImageEntity> getImageEntity(MultipartHttpServletRequest request) throws IOException {
        Map<String, MultipartFile> fileMap = request.getFileMap();
        List<ImageEntity> imageEntities = new ArrayList<>();
        for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
            MultipartFile file = entry.getValue();
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImageBytes(file.getBytes());
            imageEntity.setImageType(ImagePathUtil.getImageType(file.getName()));
            imageEntities.add(imageEntity);
        }
        return imageEntities;
    }
}
