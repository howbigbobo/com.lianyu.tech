package com.lianyu.tech.backoffice.web.request;

import com.lianyu.tech.core.platform.web.form.Form;
import com.lianyu.tech.core.platform.web.form.FormParam;

import javax.validation.constraints.NotNull;

/**
 * @author bowen
 */
@Form
public class DescriptionItemRequest {
    @FormParam("id")
    private Integer id;

    @NotNull(message = "descriptionId不能为空")
    @FormParam("descriptionId")
    private Integer descriptionId;

    @FormParam("imageId")
    private Integer imageId;

    @FormParam("content")
    private String content;

    @FormParam("displayOrder")
    private int displayOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
