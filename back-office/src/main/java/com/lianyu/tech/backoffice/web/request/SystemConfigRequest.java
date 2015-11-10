package com.lianyu.tech.backoffice.web.request;

import com.lianyu.tech.backoffice.web.vo.KeyValueView;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bowen
 */
public class SystemConfigRequest {
    private List<KeyValueView> keyValues;

    public List<KeyValueView> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(List<KeyValueView> keyValues) {
        this.keyValues = keyValues;
    }

    public Map<String, String> toMap() {
        if (CollectionUtils.isEmpty(keyValues)) return Collections.EMPTY_MAP;
        Map<String, String> map = new HashMap<>(keyValues.size(), 1);
        for (KeyValueView valueView : keyValues) {
            map.put(valueView.getKey(), valueView.getValue());
        }
        return map;
    }
}
