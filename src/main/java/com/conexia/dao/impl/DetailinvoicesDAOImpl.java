package com.conexia.dao.impl;

import com.conexia.dao.DetailinvoicesDAO;
import com.conexia.entity.DetailinvoicesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetailinvoicesDAOImpl implements DetailinvoicesDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public DetailinvoicesEntity selecyById(Integer idDetail) {
        DetailinvoicesEntity detailinvoicesEntity = entityManager.find(DetailinvoicesEntity.class, idDetail);
        return detailinvoicesEntity;
    }

    @Override
    public List<DetailinvoicesEntity> selectAll() {
        Query query = entityManager.createQuery("from DetailinvoicesEntity");
        List<DetailinvoicesEntity> detailinvoicesEntities = new ArrayList<>();
        detailinvoicesEntities = query.getResultList();
        return detailinvoicesEntities;
    }

    @Override
    @Transactional
    public void insert(DetailinvoicesEntity detailinvoicesEntity) {
        entityManager.persist(detailinvoicesEntity);

    }

    @Override
    @Transactional
    public void update(DetailinvoicesEntity detailinvoicesEntity) {
        entityManager.merge(detailinvoicesEntity);
    }

    @Override
    @Transactional
    public void delete(DetailinvoicesEntity detailinvoicesEntity) {
        Object obj = entityManager.merge(detailinvoicesEntity);
        entityManager.remove(obj);
        entityManager.flush();

    }
}
