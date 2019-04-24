package com.conexia.dao;

import com.conexia.entity.InvoicesEntity;

import java.util.List;

public interface InvoicesDAO {

    public InvoicesEntity  selecyById(Long idInvoice);

    public List<InvoicesEntity> selectAll();

    public void insert(InvoicesEntity invoicesEntity);

    public void update(InvoicesEntity invoicesEntity);

    public void delete(InvoicesEntity invoicesEntity);

}
