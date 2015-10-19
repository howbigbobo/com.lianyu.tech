package com.lianyu.tech.backoffice.web.converter;

import com.lianyu.tech.backoffice.web.vo.AddressView;
import com.lianyu.tech.common.domain.Address;
import com.lianyu.tech.common.utils.Converter;
import com.lianyu.tech.common.utils.ListUtils;

import java.util.List;

/**
 * @author bowen.zhang
 */
public abstract class AddressConverter {
    public static AddressView convert(Address address) {
        if (address == null) return null;
        AddressView view = new AddressView();
        view.setId(address.getId());
        view.setCompanyId(address.getCompanyId());
        view.setProvince(address.getProvince());
        view.setCity(address.getCity());
        view.setRegion(address.getRegion());
        view.setStreet(address.getStreet());
        view.setAddress(address.getAddress());
        return view;
    }

    public static List<AddressView> convert(final List<Address> addresses) {
        return ListUtils.convert(addresses, new Converter<Address, AddressView>() {
            @Override
            public AddressView convert(Address address) {
                return convert(address);
            }
        });
    }
}
