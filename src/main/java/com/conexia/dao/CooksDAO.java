package com.conexia.dao;

import com.conexia.entity.CooksEntity;

import java.util.List;

public interface CooksDAO {

    public CooksEntity  selecyById(Long idCook);

    public List<CooksEntity> selectAll();

    public void insert (CooksEntity cooksEntity);

    public void update (CooksEntity cooksEntity);

    public void delete (CooksEntity cooksEntity);

}
