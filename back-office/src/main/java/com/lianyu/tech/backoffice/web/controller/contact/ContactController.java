package com.lianyu.tech.backoffice.web.controller.contact;

import com.lianyu.tech.backoffice.service.ContactService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeSiteController;
import com.lianyu.tech.backoffice.web.converter.ContactConverter;
import com.lianyu.tech.common.domain.Contact;
import com.lianyu.tech.common.domain.ContactType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author bowen.zhang
 */
@Controller
public class ContactController extends BackOfficeSiteController {

    @Inject
    private ContactService contactService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String list(Map<String, Object> model) {
        List<Contact> contacts = contactService.findAll();
        model.put("contacts", ContactConverter.convert(contacts));
        model.put("contactTypes", Arrays.asList(ContactType.values()));
        return "contact/contact.list";
    }
}
