package com.lianyu.tech.backoffice.web.controller.image;

import com.lianyu.tech.backoffice.image.ImageEntity;
import com.lianyu.tech.backoffice.image.file.ImagePathUtil;
import com.lianyu.tech.backoffice.service.ImageFacadeService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeSiteController;
import com.lianyu.tech.backoffice.web.vo.ImageSaveView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
public class ImageDemoController extends BackOfficeSiteController {
    @Inject
    private ImageFacadeService imageFacadeService;

    @RequestMapping(value = "/image/demo", method = RequestMethod.GET)
    public String imageDemo() {
        return "image/image.demo";
    }

    @ResponseBody
    @RequestMapping(value = "/image/save", method = RequestMethod.POST)
    public Map<String, Object> imageSave(ImageSaveView imageSaveView, MultipartHttpServletRequest imageRequest) throws IOException {
        String description = imageSaveView.getDescription();
        List<ImageEntity> imageEntities = getImageEntity(imageRequest);

        for (ImageEntity imageEntity : imageEntities) {
            imageFacadeService.add(imageEntity);
        }

        Map<String, Object> map = new HashMap<>(1, 1);
        map.put("success", true);
        return map;
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
