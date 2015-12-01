package com.lianyu.tech.backoffice;

import com.lianyu.tech.backoffice.web.interceptor.LoginInterceptor;
import com.lianyu.tech.backoffice.web.interceptor.MasterLayout;
import com.lianyu.tech.backoffice.web.interceptor.MasterTemplateModelBuilder;
import com.lianyu.tech.common.DefaultDBConfig;
import com.lianyu.tech.core.platform.DefaultSiteConfig;
import com.lianyu.tech.core.platform.PlatformScopeResolver;
import com.lianyu.tech.core.platform.runtime.RuntimeEnvironment;
import com.lianyu.tech.core.platform.runtime.RuntimeSettings;
import com.lianyu.tech.core.platform.web.DeploymentSettings;
import com.lianyu.tech.core.platform.web.site.SiteSettings;
import com.lianyu.tech.core.platform.web.site.layout.ModelBuilderInterceptor;
import com.lianyu.tech.core.platform.web.site.session.SessionProviderType;
import com.lianyu.tech.core.platform.web.site.view.DefaultFreemarkerView;
import com.lianyu.tech.core.platform.web.site.view.DefaultFreemarkerViewResolver;
import com.lianyu.tech.core.util.TimeLength;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackageClasses = {WebConfig.class, DefaultDBConfig.class}, scopeResolver = PlatformScopeResolver.class)
public class WebConfig extends DefaultSiteConfig {
    @Inject
    Environment env;
    @Inject
    EntityManagerFactory entityManagerFactory;
    @Inject
    ServletContext servletContext;

    @Bean
    public SiteSettings siteSettings() {
        SiteSettings siteSettings = new SiteSettings();
        siteSettings.setCSSDir("/static/css");
        siteSettings.setJSDir("/static/js");
        siteSettings.setResourceNotFoundPage("forward:/404");
        siteSettings.setErrorPage("error");
        siteSettings.setSessionTimeOutPage("redirect:/login");
        siteSettings.setSessionTimeOut(TimeLength.minutes(env.getProperty("site.sessionTimeOut", int.class, 30)));
        siteSettings.setSessionProviderType(env.getProperty("site.sessionProvider", SessionProviderType.class, SessionProviderType.LOCAL));
        siteSettings.setRemoteSessionServers(env.getProperty("site.remoteSessionServer"));
        return siteSettings;
    }

    @Override
    public DeploymentSettings deploymentSettings() {
        DeploymentSettings settings = super.deploymentSettings();
        settings.setDeploymentContext(env.getProperty("site.deploymentContext"), servletContext);
        return settings;
    }

    @Override
    public RuntimeSettings runtimeSettings() {
        RuntimeSettings settings = super.runtimeSettings();
        settings.setEnvironment(env.getProperty("site.environment", RuntimeEnvironment.class, RuntimeEnvironment.PROD));
        settings.setVersion(version());
        return settings;
    }

    private String version() {
        String version = env.getProperty("runtime.version");
        if (!StringUtils.hasText(version) || version.contains("${"))
            return "current"; // for local build, where version is not populated by build
        return version;
    }

    @Bean
    DefaultFreemarkerViewResolver freeMarkerViewResolver() {
        DefaultFreemarkerViewResolver resolver = new DefaultFreemarkerViewResolver();
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html; charset=UTF-8");
        resolver.setViewClass(DefaultFreemarkerView.class);
        resolver.setExposeSpringMacroHelpers(false);
        resolver.setExposeRequestAttributes(true);
        resolver.setAllowRequestOverride(true);
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(exceptionInterceptor());
        registry.addInterceptor(requestContextInterceptor());
        registry.addInterceptor(httpSchemeEnforceInterceptor());
        registry.addInterceptor(cookieInterceptor());
        registry.addInterceptor(sessionInterceptor());
        registry.addInterceptor(loginInterceptor());
        registry.addInterceptor(modelBuilderInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/home");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // on server env, /mstatic will be handled by apache or CDN, this only apply to local dev
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/static/");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10 * 1024 * 1024);
        multipartResolver.setMaxInMemorySize(2048);
        multipartResolver.setResolveLazily(true);
        return multipartResolver;
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public ModelBuilderInterceptor modelBuilderInterceptor() {
        ModelBuilderInterceptor interceptor = new ModelBuilderInterceptor();
        interceptor.registerModelBuilder(MasterLayout.class, MasterTemplateModelBuilder.class);
        return interceptor;
    }
}
