package com.conexia.dao.impl;

import com.conexia.dao.CustomersDAO;
import com.conexia.entity.CustomersEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class CustomersDAOImpl implements CustomersDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CustomersEntity selecyById(Integer idCustomer) {
        return entityManager.find(CustomersEntity.class, idCustomer);

    }

    @Override
    public List<CustomersEntity> selectAll() {
        Query query = entityManager.createQuery("from CustomersEntity");
        List<CustomersEntity> tablesEntities ;
        tablesEntities = query.getResultList();
        return tablesEntities;
    }

    @Override
    @Transactional
    public void insert(CustomersEntity customersEntity) {
        entityManager.persist(customersEntity);

    }

    @Override
    @Transactional
    public void update(CustomersEntity customersEntity) {
        entityManager.merge(customersEntity);
    }

    @Override
    @Transactional
    public void delete(CustomersEntity customersEntity) {
        Object obj = entityManager.merge(customersEntity);
        entityManager.remove(obj);
        entityManager.flush();

    }
}
