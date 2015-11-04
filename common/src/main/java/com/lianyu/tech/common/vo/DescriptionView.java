package com.lianyu.tech.common.vo;

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

    private Date beginTime;

    private Date endTime;

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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
