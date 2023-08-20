package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.Leave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LeaveMapper {

    /*
    *  获取员工休假时间
    * */
    @Select("select * from `leave`")
    List<Leave> getLeaveInfo();

}