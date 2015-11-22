package com.lianyu.tech.backoffice.web.controller.verify;

import com.lianyu.tech.common.utils.ImageIOUtil;
import com.lianyu.tech.common.utils.MathVerifyCodeUtils;
import com.lianyu.tech.common.utils.VerifyCode;
import com.lianyu.tech.common.utils.VerifyCodeUtils;
import com.lianyu.tech.core.platform.web.rest.RESTController;
import com.lianyu.tech.core.platform.web.site.session.RequireSession;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author bowen
 */
@Controller
@RequireSession
public class VerifyCodeRestController extends RESTController {

    @Inject
    private VerifyCodeValidator verifyCodeValidator;

    @ResponseBody
    @RequestMapping(value = "/verify/code", method = RequestMethod.GET, produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    public byte[] getVerifyCode() {
        ThreadLocalRandom.current().nextInt(10);
        int i = ThreadLocalRandom.current().nextInt(10);
        VerifyCode verifyCode;
        if (i % 2 == 0) {
            verifyCode = VerifyCodeUtils.generate();
        } else {
            verifyCode = MathVerifyCodeUtils.generate();
        }
        verifyCodeValidator.setVerifyCode(verifyCode.getResult());
        return ImageIOUtil.getBytes(verifyCode.getImage());
    }
}
