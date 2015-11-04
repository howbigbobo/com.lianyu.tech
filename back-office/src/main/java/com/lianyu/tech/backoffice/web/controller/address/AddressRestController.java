package com.lianyu.tech.backoffice.web.controller.address;

import com.lianyu.tech.backoffice.service.AddressService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import com.lianyu.tech.backoffice.web.request.AddressRequest;
import com.lianyu.tech.common.domain.Address;
import com.lianyu.tech.common.vo.AddressView;
import com.lianyu.tech.common.vo.converter.AddressConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * @author bowen.zhang
 */
@Controller
public class AddressRestController extends BackOfficeRestController {

    @Inject
    private AddressService addressService;

    @ResponseBody
    @RequestMapping(value = "/address/{addressId}", method = RequestMethod.GET)
    public AddressView get(@PathVariable("addressId") Integer addressId) {
        Address address = addressService.get(addressId);
        AddressView view = AddressConverter.convert(address);
        return view == null ? new AddressView() : view;
    }

    @ResponseBody
    @RequestMapping(value = "/address/save", method = RequestMethod.POST)
    public void save(@Valid @RequestBody AddressRequest addressRequest) {
        Address address = new Address();
        address.setId(addressRequest.getId());
        address.setCompanyId(addressRequest.getCompanyId());
        address.setProvince(addressRequest.getProvince());
        address.setCity(addressRequest.getCity());
        address.setRegion(addressRequest.getRegion());
        address.setStreet(addressRequest.getStreet());
        address.setAddress(addressRequest.getAddress());
        addressService.save(address);
    }

    @ResponseBody
    @RequestMapping(value = "/address/delete/{addressId}", method = RequestMethod.POST)
    public void delete(@PathVariable("addressId") Integer addressId) {
        addressService.delete(addressId);
    }
}
