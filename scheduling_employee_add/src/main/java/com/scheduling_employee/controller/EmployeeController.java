package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.Result;
import com.scheduling_employee.pojo.DailySchedule;
import com.scheduling_employee.pojo.EmployeeWorkHours;
import com.scheduling_employee.service.DailyScheduleService;
import com.scheduling_employee.service.EmployeeWorkHoursService;
import com.scheduling_employee.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@RequestMapping("/employees")
@RestController
@Slf4j

public class EmployeeController {
    @Autowired
    private EmployeeWorkHoursService employeeWorkHoursService;
    @Autowired
    private DailyScheduleService dailyScheduleService;
    //员⼯可以查看⾃⼰的⼯作时⻓信息
    @GetMapping("/workTime")
    public Result workTime(){
        String jwt=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
        String userId= (String) JwtUtils.parseJWT(jwt).get("userId");
        List<EmployeeWorkHours> ewh=employeeWorkHoursService.selectWorkTime(userId);
        return Result.success(ewh);
    }
    //可视化工作
    @GetMapping("/selfSchedule")
    public  Result selfSchedule(){
        String jwt=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
        String userId= (String) JwtUtils.parseJWT(jwt).get("userId");
        List<DailySchedule> ds=dailyScheduleService.selectSchedule(userId);
        return Result.success(ds);
    }

}
