package com.scheduling_employee.service;


import com.scheduling_employee.pojo.DailySchedule;

import java.util.List;

public interface DailyScheduleService {
    List<DailySchedule> selectSchedule(String userId);
}
