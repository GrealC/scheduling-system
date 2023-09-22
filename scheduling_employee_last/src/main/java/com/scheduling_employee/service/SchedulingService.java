package com.scheduling_employee.service;

import com.scheduling_employee.pojo.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SchedulingService {

    //自动排班
    List<EmployeeWorkPeriods> setSchedule(String storeId, String date);
    //获取预测信息
    BusinessForecasts getBusinessForecasts(String storeId, String time, String periods);

    //获取排班规则
    List<ScheduleRules> getScheduleRules(String storeID);

    //获取成员信息
    List<Users> getUsersInfo();

    //获取工作时段信息
    List<EmployeeWorkPeriods> getWorkPeriodsInfo();

    //获取员工休假时间
    List<Leave> getEmployeeLeave();

    //获取员工加班时间
    List<Overtime> getEmployeeOverTime();

    //处理员工信息
    List<String> resolveEmployee(String storeIdPeriod, String period, List<Users> users, List<Leave> leave, List<Overtime> overtime, List<EmployeeWorkPeriods> employeeWorkPeriods, String date);

    boolean selectByStoreId(String storeId);

    ResBean createTable(DailySchedule schedule);

    ResBean updateTable(DailySchedule schedule);
}
