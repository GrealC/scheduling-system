package com.example.scheduling_system.Service;

import com.example.scheduling_system.Entity.ResBean;
import com.example.scheduling_system.Entity.dailySchedule;

public interface scheduleService {
    public boolean selectByStoreId(String storeId);

    public ResBean createTable(dailySchedule schedule);

    public ResBean updateTable(dailySchedule schedule);
}
