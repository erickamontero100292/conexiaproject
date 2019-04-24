package com.conexia.dao.impl;

import com.conexia.dao.TablesDAO;
import com.conexia.entity.TablesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class TablesDAOImpl implements TablesDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public TablesEntity selecyById(Integer idTable) {
        TablesEntity tablesEntity = entityManager.find(TablesEntity.class, idTable);
        return tablesEntity;
    }

    @Override
    public List<TablesEntity> selectAll() {
        Query query = entityManager.createQuery("from TablesEntity");
        List<TablesEntity> tablesEntities = new ArrayList<>();
        tablesEntities = query.getResultList();
        return tablesEntities;
    }

    @Override
    @Transactional
    public void insert(TablesEntity tablesEntity) {
        entityManager.persist(tablesEntity);

    }

    @Override
    @Transactional
    public void update(TablesEntity tablesEntity) {
        entityManager.merge(tablesEntity);
    }

    @Override
    @Transactional
    public void delete(TablesEntity tablesEntity) {
        Object obj = entityManager.merge(tablesEntity);
        entityManager.remove(obj);
        entityManager.flush();

    }
}
