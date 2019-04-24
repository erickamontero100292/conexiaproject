package com.conexia.dao;

import com.conexia.entity.TablesEntity;

import java.util.List;

public interface TablesDAO {

    public TablesEntity selecyById(Long idCook);

    public List<TablesEntity> selectAll();

    public void insert(TablesEntity tablesEntity);

    public void update(TablesEntity tablesEntity);

    public void delete(TablesEntity tablesEntity);

}
