package com.conexia.dao.impl;

import com.conexia.dao.CustomersDAO;
import com.conexia.dao.TablesDAO;
import com.conexia.entity.CustomersEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersDAOImpl implements CustomersDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CustomersEntity selecyById(Long idCustomer) {
        CustomersEntity customersEntity = entityManager.find(CustomersEntity.class, idCustomer);
        return customersEntity;
    }

    @Override
    public List<CustomersEntity> selectAll() {
        Query query = entityManager.createQuery("from CustomersEntity");
        List<CustomersEntity> tablesEntities = new ArrayList<>();
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
