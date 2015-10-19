package com.lianyu.tech.backoffice.web.controller.address;

import com.lianyu.tech.backoffice.service.AddressService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import com.lianyu.tech.backoffice.web.converter.AddressConverter;
import com.lianyu.tech.backoffice.web.vo.AddressView;
import com.lianyu.tech.common.domain.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

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
}
