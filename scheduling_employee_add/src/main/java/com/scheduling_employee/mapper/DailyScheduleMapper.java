package com.scheduling_employee.mapper;


import com.scheduling_employee.pojo.DailySchedule;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface DailyScheduleMapper {
    List<DailySchedule> mySchedule(String userId);
}
