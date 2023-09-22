package com.example.mapper;

import com.example.domain.DailySchedule;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface DailyScheduleMapper {
    List<DailySchedule> mySchedule(String userId);
}
