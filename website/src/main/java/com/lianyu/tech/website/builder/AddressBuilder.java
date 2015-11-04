package com.lianyu.tech.website.builder;

import com.lianyu.tech.common.repository.AddressRepository;
import com.lianyu.tech.common.vo.AddressView;
import com.lianyu.tech.common.vo.converter.AddressConverter;
import com.lianyu.tech.website.vo.AddressVo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author bowen
 */
@Service
public class AddressBuilder {
    @Inject
    private AddressRepository addressRepository;

    public AddressVo find() {
        List<AddressView> addressViews = AddressConverter.convert(addressRepository.findAll());
        AddressVo v = new AddressVo();
        v.setAddresses(addressViews);
        return v;
    }
}
