package com.lianyu.tech.backoffice.web.converter;

import com.lianyu.tech.core.util.Convert;
import com.lianyu.tech.core.util.StringUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author bowen
 */
public class StringDateAdapter extends XmlAdapter<String, Date> {
    private static final List<String> TIME_FORMATS = Arrays.asList("yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss");

    @Override
    public Date unmarshal(String v) throws Exception {
        if (!StringUtils.hasText(v)) return null;

        for (String format : TIME_FORMATS) {
            Date d = Convert.toDate(v, format, null);
            if (d != null) return d;
        }
        throw new IllegalArgumentException("unknown time format:" + v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        if (v == null) return null;
        return Convert.toString(v, TIME_FORMATS.get(1));
    }
}
