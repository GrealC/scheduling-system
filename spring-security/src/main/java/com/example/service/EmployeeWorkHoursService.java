package com.example.service;

import com.example.domain.EmployeeWorkHours;
import java.util.List;

public interface EmployeeWorkHoursService {
    List<EmployeeWorkHours> selectWorkTime(String userId);

}
