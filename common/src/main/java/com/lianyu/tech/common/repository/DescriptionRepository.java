package com.lianyu.tech.common.repository;

import com.lianyu.tech.common.domain.Description;
import com.lianyu.tech.common.domain.DescriptionType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bowen.zhang
 */
@Repository
public class DescriptionRepository extends CommonRepository {
    public List<Description> findByType(DescriptionType type, int offset, int size) {
        Map<String, Object> params = new HashMap<>(1, 1);
        params.put("type", type);
        String sql = "from " + Description.class.getName() + " where type=:type order by beginTime desc";
        return jpaAccess.find(sql, params, offset, size);
    }

    public List<Description> findByType(DescriptionType type) {
        Map<String, Object> params = new HashMap<>(1, 1);
        params.put("type", type);
        String sql = "from " + Description.class.getName() + " where type=:type order by beginTime desc";
        return jpaAccess.find(sql, params);
    }

    public int countByType(DescriptionType descriptionType) {
        Map<String, Object> params = new HashMap<>(1, 1);
        params.put("type", descriptionType);
        String sql = "select count(1) from " + Description.class.getName() + " where type=:type ";
        Long count = jpaAccess.findUniqueResult(sql, params);
        return count.intValue();
    }
}
