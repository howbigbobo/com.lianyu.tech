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
        Map<String, Object> params = new HashMap<>(2);
        params.put("type", type);
        String sql = "from " + Description.class.getName() + " where type=:type order by descTime desc";
        return jpaAccess.find(sql, null, offset, size);
    }
}
