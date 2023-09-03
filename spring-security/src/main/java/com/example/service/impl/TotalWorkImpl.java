package com.example.service.impl;

import com.example.domain.TotalWork;
import com.example.mapper.TotalWorkMapper;
import com.example.service.TotalWorkService;
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
