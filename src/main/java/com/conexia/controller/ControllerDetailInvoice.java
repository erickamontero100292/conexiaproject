package com.conexia.controller;

import com.conexia.dao.impl.DetailinvoicesDAOImpl;
import com.conexia.entity.DetailinvoicesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerDetailInvoice {

    @Autowired
    DetailinvoicesDAOImpl detailinvoicesDAO;

    public List<DetailinvoicesEntity> findAllDetailInvoce() {
        List<DetailinvoicesEntity> entityList = new ArrayList<>();
        entityList = detailinvoicesDAO.selectAll();
        return entityList;
    }

    public void save(DetailinvoicesEntity detailInvoicesEntity) {
        detailinvoicesDAO.insert(detailInvoicesEntity);
    }

    public void update(DetailinvoicesEntity detailInvoicesEntity) {
        detailinvoicesDAO.update(detailInvoicesEntity);
    }

    public void delete(DetailinvoicesEntity detailInvoicesEntity) {
        detailinvoicesDAO.delete(detailInvoicesEntity);
    }

    public List<DetailinvoicesEntity> selectByInvoice(Integer idInvoice) {
        List<DetailinvoicesEntity> entityList = new ArrayList<>();
        entityList = detailinvoicesDAO.selectByInvoice( idInvoice);
        return entityList;
    }

    public List<DetailinvoicesEntity> loadGroupByIdInvoice( ) {
        List<DetailinvoicesEntity> entityList = new ArrayList<>();
        entityList = detailinvoicesDAO.loadGroupByIdInvoice( );
        return entityList;
    }

    public List<Object> consultCustomerByAmount( ) {
        List<Object> entityList = new ArrayList<>();
        entityList = detailinvoicesDAO.consultCustomerByAmount( );
        return entityList;
    }
}
