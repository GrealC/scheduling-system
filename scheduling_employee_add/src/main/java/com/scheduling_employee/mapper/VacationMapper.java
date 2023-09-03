package com.scheduling_employee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scheduling_employee.pojo.Vacation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author yy
* @description 针对表【employee_vacation_calendars】的数据库操作Mapper
* @createDate 2023-08-04 19:18:36
* @Entity com.example.arrange.domain.Vacation
*/
@Mapper
public interface VacationMapper extends BaseMapper<Vacation> {

    @Select("select * from employee_vacation_calendars where user_id=#{id}")
    List<Vacation> selectByUserId(@Param("id") String userId);

    @Insert("insert into employee_vacation_calendars(calendar_id,user_id,date) " +
            "values (#{calendarId},#{userId},#{date})")
    Integer addVacation(Vacation vacation);
}




