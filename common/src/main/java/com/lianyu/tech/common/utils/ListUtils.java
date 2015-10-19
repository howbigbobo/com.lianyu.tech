package com.lianyu.tech.common.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author bowen.zhang
 */
public class ListUtils {
    public static <T, K> Map<K, T> toMap(List<T> list, Converter<T, K> selector) {
        if (CollectionUtils.isEmpty(list)) return Collections.emptyMap();
        Map<K, T> map = new HashMap<>(list.size());
        for (T t : list) {
            K key = selector.convert(t);
            if (key != null) map.put(key, t);
        }
        return map;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> list, Converter<T, K> selector) {
        if (CollectionUtils.isEmpty(list)) return Collections.emptyMap();
        Map<K, List<T>> map = new HashMap<>();
        for (T t : list) {
            K key = selector.convert(t);
            if (key == null) continue;
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<T>());
            }
            map.get(key).add(t);
        }
        return map;
    }

    public static <T, K> List<K> select(List<T> list, Converter<T, K> selector) {
        if (CollectionUtils.isEmpty(list)) return Collections.emptyList();
        List<K> filedList = new ArrayList<>(list.size());
        for (T t : list) {
            K key = selector.convert(t);
            if (key != null) filedList.add(key);
        }
        return filedList;
    }

    public static <T, K> List<K> distinctSelect(List<T> list, Converter<T, K> selector) {
        if (CollectionUtils.isEmpty(list)) return Collections.emptyList();
        Set<K> filedSet = new HashSet<>();
        for (T t : list) {
            K key = selector.convert(t);
            if (key != null) filedSet.add(key);
        }
        return new ArrayList<>(filedSet);
    }

    public static <X, Y> List<Y> convert(List<X> list, Converter<X, Y> converter) {
        if (CollectionUtils.isEmpty(list)) return Collections.EMPTY_LIST;
        List<Y> yList = new ArrayList<>(list.size());
        for (X x : list) {
            Y y = converter.convert(x);
            if (y != null) yList.add(y);
        }
        return yList;
    }
}
