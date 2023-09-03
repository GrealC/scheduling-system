package com.scheduling_employee.service;



import com.scheduling_employee.pojo.EmployeeWorkHours;

import java.util.List;

public interface EmployeeWorkHoursService {
    List<EmployeeWorkHours> selectWorkTime(String userId);

}
