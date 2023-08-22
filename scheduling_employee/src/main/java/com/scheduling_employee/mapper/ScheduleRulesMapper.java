package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.EmployeeWorkPeriods;
import com.scheduling_employee.pojo.ScheduleRules;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ScheduleRulesMapper {

    /*
    * 获取排班规则
    * */
    @Select("select * from schedule_rules where store_id = #{storeID}")
    List<ScheduleRules> getScheduleRules(String storeID);

}