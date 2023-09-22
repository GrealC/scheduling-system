package com.example.service.impl;

import com.example.domain.DailySchedule;
import com.example.mapper.DailyScheduleMapper;
import com.example.service.DailyScheduleService;
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
