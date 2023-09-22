package com.scheduling_employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scheduling_employee.pojo.Schedule;

import java.util.List;

/**
* @author yy
* @description 针对表【schedule】的数据库操作Service
* @createDate 2023-08-15 08:16:20
*/
public interface ScheduleService extends IService<Schedule> {

    List<Schedule> selectByUserId(String userId);

    boolean addSchedule(Schedule schedule);
}
