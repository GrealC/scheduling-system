package com.example.mapper;

import com.example.domain.EmployeeWorkHours;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface EmployeeWorkHoursMapper {
    List<EmployeeWorkHours> selfWorkTime(String userId);
}
