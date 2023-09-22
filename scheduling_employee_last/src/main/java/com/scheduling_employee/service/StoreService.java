package com.scheduling_employee.service;


import com.scheduling_employee.pojo.ResBean;
import com.scheduling_employee.pojo.Store;

public interface StoreService {
    ResBean addStore(Store store);

    ResBean selectAll();

    ResBean delectById(int id);
}
