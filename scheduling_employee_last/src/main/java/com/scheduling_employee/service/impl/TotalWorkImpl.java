package com.scheduling_employee.service.impl;

import com.scheduling_employee.pojo.TotalWork;
import com.scheduling_employee.mapper.TotalWorkMapper;
import com.scheduling_employee.service.TotalWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalWorkImpl implements TotalWorkService {
    @Autowired
    private TotalWorkMapper totalWorkMapper;

    @Override
    public List<TotalWork> selectAll() {
        return totalWorkMapper.allWorkTime();
    }

    @Override
    public void setSalary(TotalWork totalWork) {
        totalWorkMapper.updateSalary(totalWork);
    }
}
