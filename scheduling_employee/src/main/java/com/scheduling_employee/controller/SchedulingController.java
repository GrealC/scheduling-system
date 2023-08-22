package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.EmployeeWorkPeriods;
import com.scheduling_employee.pojo.Result;
import com.scheduling_employee.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    @RequestMapping("/scheduling")
        public Result schedule(String storeId, String[] date){

        List<EmployeeWorkPeriods> schedules = new ArrayList<>();

        for (int i = 0; i < date.length; i++) {

            List<EmployeeWorkPeriods> temp = schedulingService.setSchedule(storeId, date[i]);

            //把多个temp依次放入shcedules中
            schedules.addAll(temp);
        }
            return  Result.success(schedules);
        }

}
