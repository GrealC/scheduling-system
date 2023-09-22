package com.scheduling_employee.service.impl;

import com.scheduling_employee.pojo.EmployeeWorkHours;
import com.scheduling_employee.mapper.EmployeeWorkHoursMapper;
import com.scheduling_employee.service.EmployeeWorkHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeWorkHoursImpl implements EmployeeWorkHoursService {
    @Autowired
    private EmployeeWorkHoursMapper employeeWorkHoursMapper;
    @Override
    public List<EmployeeWorkHours> selectWorkTime(String userId) {
        return employeeWorkHoursMapper.selfWorkTime(userId);
    }

}
