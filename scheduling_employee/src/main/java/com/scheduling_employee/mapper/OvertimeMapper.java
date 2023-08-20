package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.Overtime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface OvertimeMapper {

    /*
    *  获取员工加班信息
    * */
    @Select("select * from overtime")
    List<Overtime> getOverTime();
}