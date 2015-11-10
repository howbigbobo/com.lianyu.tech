package com.lianyu.tech.common.repository;

import com.lianyu.tech.common.domain.SystemConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bowen
 */
@Repository
public class SystemConfigRepository extends CommonRepository {
    public List<SystemConfig> findAll() {
        return jpaAccess.find("from " + SystemConfig.class.getName(), null);
    }
}
