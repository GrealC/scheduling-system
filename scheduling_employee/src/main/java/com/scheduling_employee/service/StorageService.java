package com.scheduling_employee.service;

import java.util.Date;

public interface StorageService {

    void storageBusiness(String storeId, String time, String weather, Boolean isVacation, Integer business);
}
