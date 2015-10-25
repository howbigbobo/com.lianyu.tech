package com.lianyu.tech.common.repository;

import com.lianyu.tech.common.domain.Image;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Repository
public class ImageRepository extends CommonRepository {

    public List<Image> findByIds(List<Integer> imageIds) {
        if (CollectionUtils.isEmpty(imageIds)) return Collections.EMPTY_LIST;
        Map<String, Object> params = new HashMap<>(1, 1);
        params.put("imageIds", imageIds);
        String sql = "from " + Image.class.getName() + " where id in :imageIds";
        return jpaAccess.find(sql, params);
    }

    public Image getByUrl(String url) {
        if (!StringUtils.hasText(url)) return null;
        Map<String, Object> params = new HashMap<>(1, 1);
        params.put("url", url);
        String sql = "from " + Image.class.getName() + " where url = :url";
        List<Image> images = jpaAccess.find(sql, params);
        return CollectionUtils.isEmpty(images) ? null : images.get(0);
    }
}
