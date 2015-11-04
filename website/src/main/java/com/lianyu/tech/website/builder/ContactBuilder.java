package com.lianyu.tech.website.builder;

import com.lianyu.tech.common.domain.Contact;
import com.lianyu.tech.common.repository.ContactRepository;
import com.lianyu.tech.common.vo.ContactView;
import com.lianyu.tech.common.vo.converter.ContactConverter;
import com.lianyu.tech.website.vo.ContactVo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author bowen
 */
@Service
public class ContactBuilder {
    @Inject
    private ContactRepository contactRepository;

    public ContactVo getContact() {
        List<Contact> contactList = contactRepository.findAll();
        List<ContactView> contactViews = ContactConverter.convert(contactList);
        ContactVo vo = new ContactVo();
        vo.setContacts(contactViews);
        return vo;
    }
}
