package com.lianyu.tech.common.repository;

import com.lianyu.tech.common.domain.DescriptionItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bowen.zhang
 */
@Repository
public class DescriptionItemRepository extends CommonRepository {
    public List<DescriptionItem> findByDescriptionId(Integer descriptionId) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("descriptionId", descriptionId);
        String sql = "from " + DescriptionItem.class.getName() + " where descriptionId=:descriptionId order by displayOrder";
        return jpaAccess.find(sql, params);
    }
}
