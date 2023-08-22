package com.scheduling_employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scheduling_employee.pojo.Vacation;

import java.util.List;

/**
* @author yy
* @description 针对表【employee_vacation_calendars】的数据库操作Service
* @createDate 2023-08-04 19:18:36
*/
public interface VacationService extends IService<Vacation> {

    List<Vacation> selectByUserId(String userId);

    boolean addVacation(Vacation vacation);
}
