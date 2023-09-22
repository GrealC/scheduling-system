package com.example.service;

import com.example.domain.DailySchedule;
import java.util.List;

public interface DailyScheduleService {
    List<DailySchedule> selectSchedule(String userId);
}
