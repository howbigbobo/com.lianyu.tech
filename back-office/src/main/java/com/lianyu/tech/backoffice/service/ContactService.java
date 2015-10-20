package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.common.domain.CompanyInfo;
import com.lianyu.tech.common.domain.Contact;
import com.lianyu.tech.common.repository.CompanyInfoRepository;
import com.lianyu.tech.common.repository.ContactRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author bowen.zhang
 */
@Service
public class ContactService {
    @Inject
    private ContactRepository contactRepository;
    @Inject
    private CompanyInfoRepository companyInfoRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact get(Integer id) {
        if (id == null) return null;
        return contactRepository.get(Contact.class, id);
    }

    @Transactional
    public void delete(Integer id) {
        if (id == null) return;
        Contact contact = get(id);
        if (contact != null) contactRepository.delete(contact);
    }

    @Transactional
    public void save(Contact contact) {
        if (contact == null) return;
        if (contact.getDisplayOrder() == null) contact.setDisplayOrder(0);
        
        Contact existContact = null;
        if (contact.getId() != null) {
            existContact = get(contact.getId());
        }
        if (existContact != null) {
            update(existContact, contact);
        } else {
            create(contact);
        }
    }

    private void update(Contact existContact, Contact contact) {
        existContact.setCompanyId(contact.getCompanyId());
        existContact.setType(contact.getType());
        existContact.setValue(contact.getValue());
        existContact.setDisplayOrder(contact.getDisplayOrder());
        existContact.setUpdateTime(new Date());
        existContact.setUpdateUser("");
        contactRepository.update(existContact);
    }

    private void create(Contact contact) {
        contact.setUpdateTime(new Date());
        contact.setUpdateUser("");
        contact.setCreateTime(new Date());
        contact.setCreateUser("");
        if (contact.getCompanyId() == null) {
            CompanyInfo companyInfo = companyInfoRepository.get();
            if (companyInfo != null) contact.setCompanyId(companyInfo.getId());
        }
        contactRepository.create(contact);
    }
}
