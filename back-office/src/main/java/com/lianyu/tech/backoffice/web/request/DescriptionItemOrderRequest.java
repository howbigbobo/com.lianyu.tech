package com.lianyu.tech.backoffice.web.request;

import com.lianyu.tech.backoffice.web.vo.KeyValuePair;

import java.util.List;

/**
 * @author bowen
 */
public class DescriptionItemOrderRequest {
    private List<KeyValuePair> orders;

    public List<KeyValuePair> getOrders() {
        return orders;
    }

    public void setOrders(List<KeyValuePair> orders) {
        this.orders = orders;
    }
}
