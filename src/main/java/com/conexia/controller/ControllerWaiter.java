package com.conexia.controller;

import com.conexia.dao.impl.WaitersDAOImpl;
import com.conexia.entity.WaitersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ControllerWaiter {

    @Autowired
    WaitersDAOImpl waitersDAO;

    public List<WaitersEntity> findAllWaiter() {
        List<WaitersEntity> entityList ;
        entityList = waitersDAO.selectAll();
        return entityList;
    }

    public void save(WaitersEntity waitersEntity) {
        waitersDAO.insert(waitersEntity);
    }

    public void update(WaitersEntity waitersEntity) {
        waitersDAO.update(waitersEntity);
    }

    public void delete(WaitersEntity waitersEntity) {
        waitersDAO.delete(waitersEntity);
    }

    public List<Object> consultCustomerByInvoice( ) {
        List<Object> entityList;
        entityList = waitersDAO.consultWaiterByInvoice( );
        return entityList;
    }
}
