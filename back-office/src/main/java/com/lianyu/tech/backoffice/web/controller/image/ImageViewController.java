package com.lianyu.tech.backoffice.web.controller.image;

import com.lianyu.tech.backoffice.image.ImageEntity;
import com.lianyu.tech.backoffice.image.ImageHandlerService;
import com.lianyu.tech.backoffice.image.ImageSize;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * @author bowen
 */
@Controller
public class ImageViewController {

    @Inject
    private ImageHandlerService imageHandlerService;

    @RequestMapping(value = "/img/{imageFileName}.{ext}", method = RequestMethod.GET
            , produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    @ResponseBody
    public byte[] viewImage(@PathVariable("imageFileName") String imageFileName, @PathVariable("ext") String extend) {
        //imageFileName = e1ad1231231231.jpg!200x300
        String[] exts = imageFileName.split("[!_]");
        String fileName = exts[0];
        ImageSize imageSize = null;
        if (exts.length > 0) {
            fileName += "." + extend;
        }
        if (exts.length >= 2) {
            imageSize = buildImageSize(exts[1]);
        }
        ImageEntity image = imageHandlerService.get(fileName);
        if (image != null && imageSize != null) {
            image = imageHandlerService.resize(image, imageSize);
        }
        if (image != null && image.getImageBytes() != null && image.getImageBytes().length > 0) {
            return image.getImageBytes();
        } else {
            return new byte[0];
        }
    }

    private ImageSize buildImageSize(String sizeString) {
        String[] sizes = sizeString.split("x");
        int width = 0;
        int height = 0;
        if (sizes.length > 0) {
            width = Integer.parseInt(sizes[0]);
        }
        if (sizes.length > 1) {
            height = Integer.parseInt(sizes[1]);
        } else {
            height = width;
        }
        return new ImageSize(width, height);
    }
}
