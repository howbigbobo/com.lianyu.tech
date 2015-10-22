package com.lianyu.tech.common.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author bowen.zhang
 */
@Entity(name = "description")
public class Description {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private DescriptionType type;

    @Column(name = "head")
    private String head;

    @Column(name = "subhead")
    private String subhead;

    @Column(name = "desc_time")
    private Date descTime;

    @Column(name = "location")
    private String location;

    @Column(name = "content")
    private String content;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private Date updateTime;

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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
