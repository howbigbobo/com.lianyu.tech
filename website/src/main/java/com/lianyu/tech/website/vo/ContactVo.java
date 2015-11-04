package com.lianyu.tech.website.vo;

import com.lianyu.tech.common.domain.ContactType;
import com.lianyu.tech.common.vo.ContactView;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author bowen
 */
public class ContactVo {
    private List<ContactView> contacts;

    public List<ContactView> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactView> contacts) {
        this.contacts = contacts;
    }

    public ContactView getByType(ContactType contactType) {
        if (CollectionUtils.isEmpty(contacts)) return null;
        for (ContactView view : contacts) {
            if (contactType.equals(view.getType())) return view;
        }
        return null;
    }
}
