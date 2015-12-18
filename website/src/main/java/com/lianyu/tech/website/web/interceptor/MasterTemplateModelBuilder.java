package com.lianyu.tech.website.web.interceptor;


import com.lianyu.tech.core.platform.runtime.RuntimeEnvironment;
import com.lianyu.tech.core.platform.runtime.RuntimeSettings;
import com.lianyu.tech.core.platform.web.site.layout.ModelBuilder;
import com.lianyu.tech.website.builder.AddressBuilder;
import com.lianyu.tech.website.builder.CompanyBuilder;
import com.lianyu.tech.website.builder.ContactBuilder;
import com.lianyu.tech.website.builder.SystemConfigBuilder;
import com.lianyu.tech.website.web.SiteContext;

import javax.inject.Inject;
import java.util.Map;


public class MasterTemplateModelBuilder implements ModelBuilder {
    @Inject
    private SiteContext siteContext;

    @Inject
    private CompanyBuilder companyBuilder;
    @Inject
    private AddressBuilder addressBuilder;
    @Inject
    private ContactBuilder contactBuilder;
    @Inject
    private SystemConfigBuilder systemConfigBuilder;
    @Inject
    private RuntimeSettings runtimeSettings;

    @Override
    public void build(Map<String, Object> model) {
        model.put("company", companyBuilder.get());
        model.put("address", addressBuilder.find());
        model.put("contacts", contactBuilder.getContact());
        model.put("config", systemConfigBuilder.get());
        model.put("PROD", RuntimeEnvironment.PROD.equals(runtimeSettings.getEnvironment()));
        model.putAll(siteContext.getModel());
    }
}
