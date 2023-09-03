package com.scheduling_employee.service.impl;

import com.scheduling_employee.pojo.DailySchedule;
import com.scheduling_employee.mapper.DailyScheduleMapper;
import com.scheduling_employee.service.DailyScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyScheduleImpl  implements DailyScheduleService {
   @Autowired
   private DailyScheduleMapper dailyScheduleMapper;
    @Override
    public List<DailySchedule> selectSchedule(String userId) {
        return dailyScheduleMapper.mySchedule(userId);
    }
}
