package com.lianyu.tech.backoffice.web.vo;

import com.lianyu.tech.common.domain.DescriptionType;

import java.util.Date;

/**
 * @author bowen
 */
public class DescriptionView {
    private Integer id;

    private DescriptionType type;

    private String head;

    private String subhead;

    private Date descTime;

    private String location;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DescriptionType getType() {
        return type;
    }

    public void setType(DescriptionType type) {
        this.type = type;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public Date getDescTime() {
        return descTime;
    }

    public void setDescTime(Date descTime) {
        this.descTime = descTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
