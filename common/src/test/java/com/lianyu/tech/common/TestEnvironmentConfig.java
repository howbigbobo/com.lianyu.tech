package com.lianyu.tech.common;

import com.lianyu.tech.core.database.JDBCAccess;
import com.lianyu.tech.core.database.JPAAccess;
import com.lianyu.tech.core.http.HTTPClient;
import com.lianyu.tech.core.platform.DefaultSiteConfig;
import com.lianyu.tech.core.platform.concurrent.TaskExecutor;
import org.hibernate.dialect.HSQLDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Profile("test")
@Configuration
@ComponentScan
public class TestEnvironmentConfig extends DefaultSiteConfig {
    @Inject
    Environment env;

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).setName("testDB").build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(TestEnvironmentConfig.class.getPackage().getName());
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(HSQLDialect.class.getName());
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPersistenceUnitName("testDB");
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource());
        transactionManager.setPersistenceUnitName("testDB");
        return transactionManager;
    }

    @Bean
    public JPAAccess jpaAccess() {
        return new JPAAccess() {
            @Override
            @PersistenceContext(unitName = "testDB")
            public void setEntityManager(final EntityManager entityManager) {
                super.setEntityManager(entityManager);
            }
        };
    }

    @Bean
    public JDBCAccess jdbcAccess() throws PropertyVetoException {
        JDBCAccess jdbcAccess = new JDBCAccess();
        jdbcAccess.setDataSource(dataSource());
        return jdbcAccess;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() throws PropertyVetoException {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public HTTPClient httpClient() {
        return new HTTPClient();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        return TaskExecutor.fixedSizeExecutor(25);
    }
}
