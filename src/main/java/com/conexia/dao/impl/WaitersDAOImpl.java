package com.conexia.dao.impl;

import com.conexia.dao.WaitersDAO;
import com.conexia.entity.WaitersEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class WaitersDAOImpl implements WaitersDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public WaitersEntity selecyById(Long idWaiter) {
        WaitersEntity waitersEntity = entityManager.find(WaitersEntity.class, idWaiter);
        return waitersEntity;
    }

    @Override
    public List<WaitersEntity> selectAll() {
        Query query = entityManager.createQuery("from WaitersEntity");
        List<WaitersEntity> waitersEntities = new ArrayList<>();
        waitersEntities = query.getResultList();
        return waitersEntities;
    }

    @Override
    @Transactional
    public void insert(WaitersEntity waitersEntity) {
        entityManager.persist(waitersEntity);

    }

    @Override
    @Transactional
    public void update(WaitersEntity waitersEntity) {
        entityManager.merge(waitersEntity);
    }

    @Override
    @Transactional
    public void delete(WaitersEntity waitersEntity) {
        Object obj = entityManager.merge(waitersEntity);
        entityManager.remove(obj);
        entityManager.flush();

    }
}
