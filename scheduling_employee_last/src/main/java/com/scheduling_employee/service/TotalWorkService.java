package com.scheduling_employee.service;


import com.scheduling_employee.pojo.TotalWork;

import java.util.List;

public interface TotalWorkService {

    List<TotalWork> selectAll();

    void setSalary(TotalWork totalWork);
}
