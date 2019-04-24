package com.conexia.dao.impl;

import com.conexia.dao.InvoicesDAO;
import com.conexia.entity.InvoicesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoicesDAOImpl implements InvoicesDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public InvoicesEntity selecyById(Integer idInvoice) {
        InvoicesEntity invoicesEntity = entityManager.find(InvoicesEntity.class, idInvoice);
        return invoicesEntity;
    }

    @Override
    public List<InvoicesEntity> selectAll() {
        Query query = entityManager.createQuery("from InvoicesEntity");
        List<InvoicesEntity> waitersEntities = new ArrayList<>();
        waitersEntities = query.getResultList();
        return waitersEntities;
    }

    @Override
    @Transactional
    public void insert(InvoicesEntity invoicesEntity) {
        entityManager.persist(invoicesEntity);

    }

    @Override
    @Transactional
    public void update(InvoicesEntity invoicesEntity) {
        entityManager.merge(invoicesEntity);
    }

    @Override
    @Transactional
    public void delete(InvoicesEntity invoicesEntity) {
        Object obj = entityManager.merge(invoicesEntity);
        entityManager.remove(obj);
        entityManager.flush();

    }
}
