package com.lianyu.tech.backoffice.web.controller.contact;

import com.lianyu.tech.backoffice.service.ContactService;
import com.lianyu.tech.backoffice.web.controller.BackOfficeRestController;
import com.lianyu.tech.backoffice.web.converter.ContactConverter;
import com.lianyu.tech.backoffice.web.request.ContactRequest;
import com.lianyu.tech.backoffice.web.vo.ContactView;
import com.lianyu.tech.common.domain.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * @author bowen.zhang
 */
@Controller
public class ContactRestController extends BackOfficeRestController {

    @Inject
    private ContactService contactService;

    @ResponseBody
    @RequestMapping(value = "/contact/{contactId}", method = RequestMethod.GET)
    public ContactView get(@PathVariable("contactId") Integer contactId) {
        ContactView view = ContactConverter.convert(contactService.get(contactId));
        return view == null ? new ContactView() : view;
    }

    @ResponseBody
    @RequestMapping(value = "/contact/delete/{contactId}", method = RequestMethod.POST)
    public void delete(@PathVariable("contactId") Integer contactId) {
        contactService.delete(contactId);
    }

    @ResponseBody
    @RequestMapping(value = "/contact/save", method = RequestMethod.POST)
    public void save(@Valid @RequestBody ContactRequest contactRequest) {
        Contact contact = new Contact();
        contact.setCompanyId(contactRequest.getCompanyId());
        contact.setId(contactRequest.getId());
        contact.setValue(contactRequest.getValue());
        contact.setType(contactRequest.getType());
        contact.setDisplayOrder(contactRequest.getDisplayOrder());
        contactService.save(contact);
    }
}
