package com.conexia.dao.impl;

import com.conexia.dao.CooksDAO;
import com.conexia.entity.CooksEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class CooksDAOImpl implements CooksDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CooksEntity selecyById(Integer idCook) {
        return entityManager.find(CooksEntity.class, idCook);
    }

    @Override
    public List<CooksEntity> selectAll() {
        Query query = entityManager.createQuery("from CooksEntity");
        List<CooksEntity> cooksEntities;
        cooksEntities = query.getResultList();
        return cooksEntities;
    }

    @Override
    @Transactional
    public void insert(CooksEntity cooksEntity) {
        entityManager.persist(cooksEntity);

    }

    @Override
    @Transactional
    public void update(CooksEntity cooksEntity) {
        entityManager.merge(cooksEntity);
    }

    @Override
    @Transactional
    public void delete(CooksEntity cooksEntity) {
        Object obj = entityManager.merge(cooksEntity);
        entityManager.remove(obj);
        entityManager.flush();

    }
}
