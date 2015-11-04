package com.lianyu.tech.common.vo.converter;

import com.lianyu.tech.common.domain.DescriptionType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author bowen
 */
public class DescriptionTypeAdapter extends XmlAdapter<String, DescriptionType> {

    @Override
    public DescriptionType unmarshal(String v) throws Exception {
        return DescriptionType.fromName(v);
    }

    @Override
    public String marshal(DescriptionType v) throws Exception {
        return v.toString().toLowerCase();
    }
}
