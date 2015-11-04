package com.lianyu.tech.website.vo;

import com.lianyu.tech.common.vo.AddressView;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author bowen
 */
public class AddressVo {
    private List<AddressView> addresses;

    private AddressView defaultAddress;

    public List<AddressView> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressView> addresses) {
        this.addresses = addresses;
        if (!CollectionUtils.isEmpty(addresses)) defaultAddress = addresses.get(0);
        else defaultAddress = new AddressView();
    }

    public AddressView getDefaultAddress() {
        return defaultAddress;
    }
}
