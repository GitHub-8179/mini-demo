package com.reptile.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reptile.entity.ReptileEntity;

@Mapper
public interface ReptileDao {

    int insert(ReptileEntity record);
    
    int inserts(List<ReptileEntity> list);


}
