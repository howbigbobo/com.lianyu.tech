package com.lianyu.tech.website.builder;

import com.lianyu.tech.common.repository.AddressRepository;
import com.lianyu.tech.website.builder.converter.AddressConverter;
import com.lianyu.tech.website.vo.AddressView;
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

    public List<AddressView> find() {
        return AddressConverter.convert(addressRepository.findAll());
    }
}
