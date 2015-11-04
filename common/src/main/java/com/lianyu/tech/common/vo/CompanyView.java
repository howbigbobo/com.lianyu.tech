package com.lianyu.tech.common.vo;

/**
 * @author bowen
 */
public class CompanyView {
    private Integer id;

    private String name;

    private String slogan;

    private String logoUrl;

    private String domain;

    private String leadDescription;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLeadDescription() {
        return leadDescription;
    }

    public void setLeadDescription(String leadDescription) {
        this.leadDescription = leadDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
