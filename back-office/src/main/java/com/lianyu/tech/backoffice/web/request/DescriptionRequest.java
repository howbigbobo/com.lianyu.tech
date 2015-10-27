package com.lianyu.tech.backoffice.web.request;

import com.lianyu.tech.backoffice.web.converter.DescriptionTypeAdapter;
import com.lianyu.tech.backoffice.web.converter.StringDateAdapter;
import com.lianyu.tech.common.domain.DescriptionType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * @author bowen
 */
public class DescriptionRequest {
    private Integer id;

    @XmlJavaTypeAdapter(DescriptionTypeAdapter.class)
    private DescriptionType type;

    @NotEmpty(message = "标题不能为空")
    private String head;

    private String subhead;

    @XmlJavaTypeAdapter(StringDateAdapter.class)
    private Date beginTime;

    @XmlJavaTypeAdapter(StringDateAdapter.class)
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
