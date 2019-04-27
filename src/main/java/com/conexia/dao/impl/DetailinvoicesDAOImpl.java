package com.conexia.dao.impl;

import com.conexia.dao.DetailinvoicesDAO;
import com.conexia.entity.DetailinvoicesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DetailinvoicesDAOImpl implements DetailinvoicesDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public DetailinvoicesEntity selecyById(Integer idDetail) {
        return  entityManager.find(DetailinvoicesEntity.class, idDetail);

    }

    @Override
    public List<DetailinvoicesEntity> selectAll() {
        Query query = entityManager.createQuery("from DetailinvoicesEntity");
        List<DetailinvoicesEntity> detailinvoicesEntities;
        detailinvoicesEntities = query.getResultList();
        return detailinvoicesEntities;
    }

    @Override
    public List<DetailinvoicesEntity> selectByInvoice(Integer idInvoice) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DetailinvoicesEntity> query = criteriaBuilder.createQuery(DetailinvoicesEntity.class);
        Root<DetailinvoicesEntity> root = query.from(DetailinvoicesEntity.class);
        Predicate predicate = null;
        predicate = criteriaBuilder.equal(root.get("idinvoice"), idInvoice);
        query.select(root).where(predicate);
        return entityManager.createQuery(query).getResultList();
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

    @Override
    public List<DetailinvoicesEntity> loadGroupByIdInvoice() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DetailinvoicesEntity> query = criteriaBuilder.createQuery(DetailinvoicesEntity.class);
        Root<DetailinvoicesEntity> root = query.from(DetailinvoicesEntity.class);
        query.select(root);
        query.groupBy(root.get("idinvoice"));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Object> consultCustomerByAmount() {

        return   entityManager.createQuery("select CONCAT(c.name,' ',c.surname), det.importe " +
                "from InvoicesEntity inv " +
                "inner join DetailinvoicesEntity det on inv.idinvoice = det.idinvoice " +
                "inner join CustomersEntity c on inv.idcustomer = c.idcustomer " +
                "group by c.idcustomer having sum(det.importe) > 100000").getResultList();


    }
}
