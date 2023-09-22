package com.example.service.impl;

import com.example.domain.EmployeeWorkHours;
import com.example.mapper.EmployeeWorkHoursMapper;
import com.example.service.EmployeeWorkHoursService;
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
