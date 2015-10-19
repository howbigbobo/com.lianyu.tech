package com.lianyu.tech.common.utils;

/**
 * @author bowen.zhang
 */
public interface Converter<T1, T2> {
    T2 convert(T1 t1);
}
