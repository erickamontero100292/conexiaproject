package com.conexia.controller;

import com.conexia.dao.impl.CustomersDAOImpl;
import com.conexia.entity.CustomersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerCustomer {

    @Autowired
    CustomersDAOImpl customersDAO;

    public List<CustomersEntity> findAllTables() {
        List<CustomersEntity> entityList = new ArrayList<>();
        entityList = customersDAO.selectAll();
        return entityList;
    }

    public void save(CustomersEntity customersEntity) {
        customersDAO.insert(customersEntity);
    }

    public void update(CustomersEntity customersEntity) {
        customersDAO.update(customersEntity);
    }

    public void delete(CustomersEntity customersEntity) {
        customersDAO.delete(customersEntity);
    }
}
