package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.EmployeeWorkPeriods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
public interface EmployeeWorkPeriodsMapper {
    /*
     *
     * 获取工作时段表
     * */
    @Select("select * from employee_work_periods")
    List<EmployeeWorkPeriods> getWorkPeriods();

    /*
    * 插入员工排班信息
    * */
    @Insert("insert into employee_work_periods (user_id, start_time, end_time) values (#{userId},#{startTime},#{endTime})")
    void insertScheduleInfo(String userId, Date startTime, Date endTime);
}