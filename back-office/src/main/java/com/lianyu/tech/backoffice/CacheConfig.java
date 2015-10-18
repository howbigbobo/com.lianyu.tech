package com.lianyu.tech.backoffice;

import com.lianyu.tech.core.platform.DefaultCacheConfig;
import com.lianyu.tech.core.platform.cache.CacheProvider;
import com.lianyu.tech.core.platform.cache.CacheRegistry;
import com.lianyu.tech.core.platform.cache.CacheSettings;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Inject;

@Configuration
@EnableCaching(proxyTargetClass = true)
public class CacheConfig extends DefaultCacheConfig {
    @Inject
    Environment env;

    @Override
    public CacheSettings cacheSettings() {
        CacheSettings settings = new CacheSettings();
        settings.setCacheProvider(env.getProperty("cache.provider", CacheProvider.class, CacheProvider.EHCACHE));
        settings.setRemoteCacheServers(env.getProperty("cache.remoteCacheServers"));
        return settings;
    }

    @Override
    protected void addCaches(CacheRegistry registry) {

    }

}
