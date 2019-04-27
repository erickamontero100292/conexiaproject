package com.conexia.controller;

import com.conexia.dao.impl.TablesDAOImpl;
import com.conexia.entity.TablesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ControllerTable {

    @Autowired
    TablesDAOImpl tablesDAO;

    public List<TablesEntity> findAllTables() {
        List<TablesEntity> entityList ;
        entityList = tablesDAO.selectAll();
        return entityList;
    }

    public void save(TablesEntity entityEvent) {
        tablesDAO.insert(entityEvent);
    }

    public void update(TablesEntity eventEntitySelect) {
        tablesDAO.update(eventEntitySelect);
    }

    public void delete(TablesEntity eventEntitySelect) {
        tablesDAO.delete(eventEntitySelect);
    }
}
