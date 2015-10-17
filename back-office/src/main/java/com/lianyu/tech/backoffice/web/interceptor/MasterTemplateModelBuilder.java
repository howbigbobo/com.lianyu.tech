package com.lianyu.tech.backoffice.web.interceptor;


import com.lianyu.tech.core.platform.web.site.layout.ModelBuilder;
import com.lianyu.tech.backoffice.web.SiteContext;

import javax.inject.Inject;
import java.util.Map;


public class MasterTemplateModelBuilder implements ModelBuilder {
    @Inject
    private SiteContext siteContext;

    @Override
    public void build(Map<String, Object> model) {
        model.putAll(siteContext.getModel());
    }
}
