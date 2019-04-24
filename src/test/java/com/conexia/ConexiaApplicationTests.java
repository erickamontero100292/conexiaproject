package com.conexia;

import com.conexia.dao.CooksDAO;
import com.conexia.dao.impl.CooksDAOImpl;
import com.conexia.entity.CooksEntity;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConexiaApplicationTests {
    String[] names = {"Maria", "Pedro", "Juan"};
    String[] surnames = {"Montero", "Hernandez", "Martinez"};
    @Autowired
    CooksDAOImpl cooksDAO;

    @Test
    public void contextLoads() {
        testInsertMassiveCook();
        testSelectAllCook();
//        testDeleteCook();

    }

    private void testInsertCook() {
        CooksEntity cooksEntity = new CooksEntity();
        cooksEntity.setName("Ericka");
        cooksEntity.setLastname("Montero");
        cooksEntity.setSurname("Montero");
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

}
