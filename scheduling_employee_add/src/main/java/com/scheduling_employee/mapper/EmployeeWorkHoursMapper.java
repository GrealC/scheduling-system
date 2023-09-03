package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.EmployeeWorkHours;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface EmployeeWorkHoursMapper {
    List<EmployeeWorkHours> selfWorkTime(String userId);
}
