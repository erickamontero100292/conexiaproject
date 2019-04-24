package com.conexia;

import com.conexia.dao.impl.CooksDAOImpl;
import com.conexia.dao.impl.TablesDAOImpl;
import com.conexia.dao.impl.WaitersDAOImpl;
import com.conexia.entity.CooksEntity;
import com.conexia.entity.TablesEntity;
import com.conexia.entity.WaitersEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConexiaApplicationTests {
    String[] names = {"Maria", "Pedro", "Juan"};
    String[] surnames = {"Montero", "Hernandez", "Martinez"};
    String[] location = {"NORTE", "SUR", "ESTE", "OESTE"};
    @Autowired
    CooksDAOImpl cooksDAO;
    @Autowired
    WaitersDAOImpl waitersDAO;
    @Autowired
    TablesDAOImpl tablesDAO;


    @Test
    public void contextLoads() {
//        testInsertMassiveCook();
//        testSelectAllCook();
//        testDeleteCook();
        /*testInsertMassivetWaiters();
        testSelectAlltWaiters();
        testDeletetWaiters();*/
//        testUpdatetWaiters();

        testInsertMassivetTables();
        testSelectAlltTables();
        testDeletetTables();
        testUpdatetTables();

    }

    private void testInsertCook() {
        CooksEntity cooksEntity = new CooksEntity();
        cooksEntity.setName("Ericka");
        cooksEntity.setLastname("Montero");
        cooksEntity.setSurname("Montero");/**/
        cooksDAO.insert(cooksEntity);
    }

    private void testInsertMassiveCook() {
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int n = rand.nextInt(3);
            CooksEntity cooksEntity = new CooksEntity();
            cooksEntity.setName(names[n]);
            cooksEntity.setLastname(surnames[n]);
            cooksEntity.setSurname(surnames[n]);
            cooksDAO.insert(cooksEntity);
        }
    }

    private void testDeleteCook() {
        CooksEntity cooksEntity = cooksDAO.selecyById(1L);
        cooksDAO.delete(cooksEntity);
    }

    private void testSelectAllCook() {
        List<CooksEntity> cooksEntities = cooksDAO.selectAll();
        Iterator iterator = cooksEntities.iterator();
        while (iterator.hasNext()) {
            CooksEntity cooksEntity = (CooksEntity) iterator.next();
            System.out.println(cooksEntity.getName());
        }
    }

    private void testInsertWaiters() {
        WaitersEntity waitersEntity = new WaitersEntity();
        waitersEntity.setName("Ericka");
        waitersEntity.setLastname("Montero");
        waitersEntity.setSurname("Montero");/**/
        waitersDAO.insert(waitersEntity);
    }

    private void testInsertMassivetWaiters() {
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int n = rand.nextInt(3);
            WaitersEntity waitersEntity = new WaitersEntity();
            waitersEntity.setName(names[n]);
            waitersEntity.setLastname(surnames[n]);
            waitersEntity.setSurname(surnames[n]);
            waitersDAO.insert(waitersEntity);
        }
    }

    private void testDeletetWaiters() {
        WaitersEntity waitersEntity = waitersDAO.selecyById(1L);
        waitersDAO.delete(waitersEntity);
    }

    private void testSelectAlltWaiters() {
        List<WaitersEntity> waitersEntities = waitersDAO.selectAll();
        Iterator iterator = waitersEntities.iterator();
        while (iterator.hasNext()) {
            WaitersEntity waitersEntity = (WaitersEntity) iterator.next();
            System.out.println(waitersEntity.getName());
        }
    }

    private void testUpdatetWaiters() {
        WaitersEntity waitersEntity = waitersDAO.selecyById(2L);
        waitersEntity.setName("Luis");
        waitersDAO.update(waitersEntity);
    }

    private void testInsertMassivetTables() {
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int n = rand.nextInt(4);
            TablesEntity tablesEntity = new TablesEntity();
            tablesEntity.setLocation(location[n]);
            tablesEntity.setMaxdiners(4);
            tablesDAO.insert(tablesEntity);
        }
    }

    private void testDeletetTables() {
        TablesEntity tablesEntity = tablesDAO.selecyById(1L);
        tablesDAO.delete(tablesEntity);
    }

    private void testSelectAlltTables() {
        List<TablesEntity> tablesEntities = tablesDAO.selectAll();
        Iterator iterator = tablesEntities.iterator();
        while (iterator.hasNext()) {
            TablesEntity tablesEntity = (TablesEntity) iterator.next();
            System.out.println(tablesEntity.getIdtable() + " - " + tablesEntity.getLocation());
        }
    }

    private void testUpdatetTables() {
        TablesEntity tablesEntity = tablesDAO.selecyById(2L);
        tablesEntity.setMaxdiners(10);
        tablesDAO.update(tablesEntity);
    }
}
