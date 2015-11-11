package com.lianyu.tech.common.vo;

/**
 * @author bowen
 */
public class SystemConfigKey {

    private String name;
    private String text;
    private String content;
    private int order;

    public SystemConfigKey(String name, String text, String content, int order) {
        this.name = name;
        this.text = text;
        this.content = content;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
