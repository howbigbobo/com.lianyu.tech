package com.lianyu.tech.backoffice.web.vo;

import com.lianyu.tech.core.platform.web.form.Form;
import com.lianyu.tech.core.platform.web.form.FormParam;

/**
 * @author Administrator
 */
@Form
public class ImageSaveView {
    @FormParam("description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
