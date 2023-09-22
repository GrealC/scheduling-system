package com.example.scheduling_system.Service;

import com.example.scheduling_system.Entity.ResBean;
import com.example.scheduling_system.Entity.store;

public interface storeService {
    ResBean addStore(store store);

    ResBean selectAll();

    ResBean delectById(int id);
}
