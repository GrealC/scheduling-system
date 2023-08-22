package com.example.service;

import com.example.domain.TotalWork;
import java.util.List;

public interface TotalWorkService {

    List<TotalWork> selectAll();

    void setSalary(TotalWork totalWork);
}
