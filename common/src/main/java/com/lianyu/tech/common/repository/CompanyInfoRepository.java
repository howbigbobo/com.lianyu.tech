package com.lianyu.tech.common.repository;

import com.lianyu.tech.common.domain.CompanyInfo;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author bowen.zhang
 */
@Repository
public class CompanyInfoRepository extends CommonRepository {

    public CompanyInfo get(Integer id) {
        if (id == null) return null;
        return jpaAccess.get(CompanyInfo.class, id);
    }

    public CompanyInfo get() {
        List<CompanyInfo> all = jpaAccess.find("from " + CompanyInfo.class.getName(), null);
        return CollectionUtils.isEmpty(all) ? null : all.get(0);
    }
}
