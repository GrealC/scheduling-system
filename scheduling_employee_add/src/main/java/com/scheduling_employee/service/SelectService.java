package com.scheduling_employee.service;

import com.scheduling_employee.pojo.ScheduleRules;
import com.scheduling_employee.pojo.Users;

import java.util.List;

public interface SelectService {

    /*
    * 通过uid获取员工信息
    * */
    Users selectUserInfo(String uid);
    /*
    * 通过店铺id获取排班规则
    * */
    List<ScheduleRules> selectSchedulesRules(String storeId);
}
