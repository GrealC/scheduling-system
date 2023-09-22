package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.BusinessHistory;
import com.scheduling_employee.pojo.Result;
import com.scheduling_employee.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class StorageController {

    /*
    * 存储历史客流量数据
    * */

    @Autowired
    private StorageService storageService;
    @RequestMapping("/storage")
    public Result storageCustomer(String storeId, String date, String weather, Boolean isVacation, Integer business){

        storageService.storageBusiness(storeId, date, weather, isVacation, business);

        return Result.success();
    }


}
