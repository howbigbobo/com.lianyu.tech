package com.lianyu.tech.common.repository;


import com.lianyu.tech.core.database.JPAAccess;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class CommonRepository extends NamedParameterJdbcDaoSupport {
    @Inject
    protected void init(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Inject
    protected JPAAccess jpaAccess;

    public <T> T get(Class<T> entityClass, Integer id) {
        return jpaAccess.get(entityClass, id);
    }

    public <T> void create(T t) {
        jpaAccess.save(t);
    }

    public <T> void delete(Class<T> entityClass, Integer id) {
        T object = get(entityClass, id);
        jpaAccess.delete(object);
    }

    public <T> void update(T t) {
        jpaAccess.update(t);
    }

    public <T> void delete(T t) {
        jpaAccess.delete(t);
    }

    protected <T> Long findCountByAttributes(Class<T> clazz, Map<String, Object> params) {
        CriteriaBuilder builder = jpaAccess.criteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<T> root = query.from(clazz);
        query.select(builder.countDistinct(root));
        if (!CollectionUtils.isEmpty(params)) {
            List<Predicate> predicateList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                predicateList.add(builder.equal(root.get(entry.getKey()), entry.getValue()));
            }
            query.where(predicateList.toArray(new Predicate[predicateList.size()]));
        }
        return jpaAccess.findUniqueResult(query);
    }

    protected <T> List<T> findByAttributes(Class<T> clazz, Map<String, Object> attributes) {
        final CriteriaBuilder builder = jpaAccess.criteriaBuilder();
        final CriteriaQuery<T> query = builder.createQuery(clazz);
        final Root<T> root = query.from(clazz);

        List<Predicate> predicates = new ArrayList<>();
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            predicates.add(builder.equal(root.get(entry.getKey()), entry.getValue()));
        }
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return jpaAccess.find(query);
    }
}
