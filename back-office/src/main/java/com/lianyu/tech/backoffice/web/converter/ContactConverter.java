package com.lianyu.tech.backoffice.web.converter;

import com.lianyu.tech.backoffice.web.vo.ContactView;
import com.lianyu.tech.common.domain.Contact;
import com.lianyu.tech.common.utils.Converter;
import com.lianyu.tech.common.utils.ListUtils;

import java.util.List;

/**
 * @author bowen.zhang
 */
public abstract class ContactConverter {
    
    public static ContactView convert(Contact contact) {
        if (contact == null) return null;
        ContactView view = new ContactView();
        view.setCompanyId(contact.getCompanyId());
        view.setId(contact.getId());
        view.setDisplayOrder(contact.getDisplayOrder());
        view.setType(contact.getType());
        view.setValue(contact.getValue());
        return view;
    }

    public static List<ContactView> convert(final List<Contact> contacts) {
        return ListUtils.convert(contacts, new Converter<Contact, ContactView>() {
            @Override
            public ContactView convert(Contact contact) {
                return ContactConverter.convert(contact);
            }
        });
    }
}
