package com.conexia.controller;

import com.conexia.dao.impl.InvoicesDAOImpl;
import com.conexia.entity.InvoicesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerInvoice {

    @Autowired
    InvoicesDAOImpl invoicesDAO;

            public List<InvoicesEntity> findAllInvoce() {
        List<InvoicesEntity> entityList = new ArrayList<>();
        entityList = invoicesDAO.selectAll();
        return entityList;
    }

    public void save(InvoicesEntity invoicesEntity) {
        invoicesDAO.insert(invoicesEntity);
    }

    public void update(InvoicesEntity invoicesEntity) {
        invoicesDAO.update(invoicesEntity);
    }

    public void delete(InvoicesEntity invoicesEntity) {
        invoicesDAO.delete(invoicesEntity);
    }
}
