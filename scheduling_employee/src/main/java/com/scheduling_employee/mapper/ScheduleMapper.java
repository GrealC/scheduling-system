package com.scheduling_employee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scheduling_employee.pojo.Schedule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author yy
* @description 针对表【schedule】的数据库操作Mapper
* @createDate 2023-08-15 08:16:20
* @Entity com.example.arrange.domain.Schedule
*/
@Mapper
public interface ScheduleMapper extends BaseMapper<Schedule> {

    @Select("select * from `schedule` where user_id = #{id}")
    List<Schedule> selectByUserId(@Param("id") String userId);
    @Insert("insert into `schedule`(schedule_id,user_id,store_id,start_time,end_time,type,status,reason) " +
            "values (#{scheduleId},#{userId},#{storeId},#{startTime},#{endTime},#{type},#{status},#{reason})")
    Integer addSchedule(Schedule schedule);
}




