package com.lianyu.tech.common.repository;

import com.lianyu.tech.common.domain.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bowen.zhang
 */
@Repository
public class ContactRepository extends CommonRepository {
    public List<Contact> findAll() {
        return jpaAccess.find("from " + Contact.class.getName() + " order by type,displayOrder", null);
    }

}
