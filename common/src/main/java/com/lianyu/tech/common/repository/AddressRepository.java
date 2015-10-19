package com.lianyu.tech.common.repository;

import com.lianyu.tech.common.domain.Address;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bowen.zhang
 */
@Repository
public class AddressRepository extends CommonRepository {

    public Address get(Integer id) {
        if (id == null) return null;
        return jpaAccess.get(Address.class, id);
    }

    public List<Address> findByCompanyId(Integer companyId) {
        if (companyId == null) return Collections.EMPTY_LIST;
        Map<String, Object> params = new HashMap<>(1);
        params.put("companyId", companyId);
        return jpaAccess.find("from " + Address.class.getName() + " where companyId =:companyId", params);
    }

    public List<Address> findAll() {
        return jpaAccess.find("from " + Address.class.getName(), null);
    }
}
