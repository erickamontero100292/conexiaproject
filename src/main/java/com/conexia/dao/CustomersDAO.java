package com.conexia.dao;

import com.conexia.entity.CustomersEntity;

import java.util.List;

public interface CustomersDAO {

    public CustomersEntity  selecyById(Integer idCustomer);

    public List<CustomersEntity> selectAll();

    public void insert(CustomersEntity customersEntity);

    public void update(CustomersEntity customersEntity);

    public void delete(CustomersEntity customersEntity);

}
