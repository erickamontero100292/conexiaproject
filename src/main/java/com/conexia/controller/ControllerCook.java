package com.conexia.controller;

import com.conexia.dao.impl.CooksDAOImpl;
import com.conexia.entity.CooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ControllerCook {

    @Autowired
    CooksDAOImpl cooksDAO;

    public List<CooksEntity> findAllCook() {
        List<CooksEntity> entityList;
        entityList = cooksDAO.selectAll();
        return entityList;
    }

    public void save(CooksEntity cooksEntity) {
        cooksDAO.insert(cooksEntity);
    }

    public void update(CooksEntity eventEntitySelect) {
        cooksDAO.update(eventEntitySelect);
    }

    public void delete(CooksEntity eventEntitySelect) {
        cooksDAO.delete(eventEntitySelect);
    }
}
