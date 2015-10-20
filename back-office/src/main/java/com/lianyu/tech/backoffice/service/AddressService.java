package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.common.domain.Address;
import com.lianyu.tech.common.domain.CompanyInfo;
import com.lianyu.tech.common.repository.AddressRepository;
import com.lianyu.tech.common.repository.CompanyInfoRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author bowen.zhang
 */
@Service
public class AddressService {
    @Inject
    private AddressRepository addressRepository;
    @Inject
    private CompanyInfoRepository companyInfoRepository;

    public Address get(Integer id) {
        return addressRepository.get(id);
    }

    public List<Address> findByCompanyId(Integer companyId) {
        return addressRepository.findByCompanyId(companyId);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Transactional
    public void save(Address address) {
        if (address == null) return;
        Address existsAddress = null;
        if (address.getId() != null) {
            existsAddress = addressRepository.get(address.getId());
        }
        if (existsAddress != null) {
            update(existsAddress, address);
        } else {
            create(address);
        }
    }

    private void update(Address existsAddress, Address address) {
        existsAddress.setCompanyId(address.getCompanyId());
        existsAddress.setProvince(address.getProvince());
        existsAddress.setCity(address.getCity());
        existsAddress.setRegion(address.getRegion());
        existsAddress.setStreet(address.getStreet());
        existsAddress.setAddress(address.getAddress());
        existsAddress.setUpdateTime(new Date());
        existsAddress.setUpdateUser("");
        addressRepository.update(existsAddress);
    }

    private void create(Address address) {
        if (address.getCompanyId() == null) {
            CompanyInfo companyInfo = companyInfoRepository.get();
            if (companyInfo != null) address.setCompanyId(companyInfo.getId());
        }
        address.setCreateTime(new Date());
        address.setCreateUser("");
        address.setUpdateTime(new Date());
        address.setUpdateUser("");
        addressRepository.create(address);
    }

    @Transactional
    public void delete(Integer addressId) {
        if (addressId == null) return;
        Address address = addressRepository.get(addressId);
        if (address != null) addressRepository.delete(address);
    }
}
