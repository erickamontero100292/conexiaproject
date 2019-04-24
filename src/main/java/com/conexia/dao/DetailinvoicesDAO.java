package com.conexia.dao;

import com.conexia.entity.DetailinvoicesEntity;

import java.util.List;

public interface DetailinvoicesDAO {

    public DetailinvoicesEntity  selecyById(Integer idDetail);

    public List<DetailinvoicesEntity> selectAll();

    public void insert(DetailinvoicesEntity detailinvoicesEntity);

    public void update(DetailinvoicesEntity detailinvoicesEntity);

    public void delete(DetailinvoicesEntity detailinvoicesEntity);

}
