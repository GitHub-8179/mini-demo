package com.reptile.service;

import java.util.List;
import java.util.Map;

import com.reptile.entity.ReptileEntity;

public interface IReptile {

    int insert(ReptileEntity record) throws Exception ;

    List getData(ReptileEntity record) throws Exception ;

}
