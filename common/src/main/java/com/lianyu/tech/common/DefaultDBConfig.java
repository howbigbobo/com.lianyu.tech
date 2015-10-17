package com.lianyu.tech.common;

import com.lianyu.tech.core.crypto.EncryptionUtils;
import com.lianyu.tech.core.database.ConnectionPoolDataSource;
import com.lianyu.tech.core.database.JDBCAccess;
import com.lianyu.tech.core.database.JPAAccess;
import com.lianyu.tech.core.util.ClasspathResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;

public class DefaultDBConfig {

    @Inject
    Environment env;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {
        ConnectionPoolDataSource dataSource = new ConnectionPoolDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        if ("false".equalsIgnoreCase(env.getProperty("jdbc.password.encrypted"))) {
            dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        } else {
            dataSource.setPassword(EncryptionUtils.decrypt(env.getRequiredProperty("jdbc.password"), new ClasspathResource("private.key")));
        }
        dataSource.setValidationQuery("select 1");
        dataSource.setDatabaseName(env.getRequiredProperty("jdbc.databaseName"));
        dataSource.setMaxActive(50);
        dataSource.setMaxIdle(15);
        dataSource.setInitialSize(10);
        dataSource.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(DefaultDBConfig.class.getPackage().getName());
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(Boolean.parseBoolean(env.getRequiredProperty("jdbc.hibernate.showsql")));
        vendorAdapter.setGenerateDdl(Boolean.parseBoolean(env.getRequiredProperty("jdbc.hibernate.generateddl")));
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        return factoryBean;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public JPAAccess jpaAccess() {
        return new JPAAccess();
    }

    @Bean
    public JDBCAccess jdbcAccess() throws PropertyVetoException {
        JDBCAccess jdbcAccess = new JDBCAccess();
        jdbcAccess.setDataSource(dataSource());
        return jdbcAccess;
    }

}