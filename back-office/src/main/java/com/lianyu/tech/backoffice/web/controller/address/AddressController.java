package com.lianyu.tech.backoffice.web.controller.address;

import com.lianyu.tech.backoffice.service.AddressService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeSiteController;
import com.lianyu.tech.common.domain.Address;
import com.lianyu.tech.common.vo.AddressView;
import com.lianyu.tech.common.vo.converter.AddressConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * @author bowen.zhang
 */
@Controller
public class AddressController extends BackOfficeSiteController {

    @Inject
    private AddressService addressService;

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String addressList(Map<String, Object> model) {
        List<Address> addresses = addressService.findAll();
        List<AddressView> addressViews = AddressConverter.convert(addresses);
        model.put("addresses", addressViews);
        return "address/address.list";
    }
}
