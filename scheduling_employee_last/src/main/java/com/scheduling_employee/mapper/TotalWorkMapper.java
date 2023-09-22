package com.scheduling_employee.mapper;


import com.scheduling_employee.pojo.TotalWork;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TotalWorkMapper {
    List<TotalWork> allWorkTime();
    void updateSalary(TotalWork list);
}
