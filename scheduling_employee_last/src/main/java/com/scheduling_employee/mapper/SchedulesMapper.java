package com.scheduling_employee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scheduling_employee.pojo.DailySchedule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchedulesMapper extends BaseMapper<DailySchedule> {
}
