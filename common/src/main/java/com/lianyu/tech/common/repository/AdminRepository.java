package com.lianyu.tech.common.repository;

import com.lianyu.tech.core.database.JPAAccess;
import com.lianyu.tech.common.domain.Admin;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminRepository {
    @Inject
    private JPAAccess jpaAccess;

    public Admin validInactive(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("admin_name", name);
        return jpaAccess.findUniqueResult("from " + Admin.class.getName() + " where admin_name=:admin_name and status='INACTIVE'", params);
    }

    public Admin adminUnique(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("admin_name", name);
        return jpaAccess.findUniqueResult("from " + Admin.class.getName() + " where admin_name=:admin_name", params);
    }


    public Integer save(Admin admin) {
        jpaAccess.save(admin);
        return admin.getAdminId();
    }

    public void update(Admin admin) {
        jpaAccess.update(admin);
    }
}
