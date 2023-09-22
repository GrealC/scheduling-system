package com.scheduling_employee.service.impl;

import com.scheduling_employee.mapper.BusinessHistoryMapper;
import com.scheduling_employee.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private BusinessHistoryMapper businessHistoryMapper;
    @Override
    public void storageBusiness(String storeId, String time, String weather, Boolean isVacation, Integer business) {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = ft.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        businessHistoryMapper.insertBusinessHistory(storeId,date,weather,isVacation,business);
    }

}
