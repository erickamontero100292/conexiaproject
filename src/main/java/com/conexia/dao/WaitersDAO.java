package com.conexia.dao;

import com.conexia.entity.WaitersEntity;

import java.util.List;

public interface WaitersDAO {

    public WaitersEntity  selecyById(Long idCook);

    public List<WaitersEntity> selectAll();

    public void insert(WaitersEntity waitersEntity);

    public void update(WaitersEntity waitersEntity);

    public void delete(WaitersEntity waitersEntity);

}
