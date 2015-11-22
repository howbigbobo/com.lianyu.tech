package com.lianyu.tech.common.repository;

import com.lianyu.tech.common.domain.Account;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bowen
 */
@Repository
public class AccountRepository extends CommonRepository {

    public Account getByName(String name) {
        if (!StringUtils.hasText(name)) return null;
        Map<String, Object> param = new HashMap<>(1, 1);
        param.put("name", name);
        return jpaAccess.findUniqueResult("from " + Account.class.getName() + " where name=:name", param);
    }
}
