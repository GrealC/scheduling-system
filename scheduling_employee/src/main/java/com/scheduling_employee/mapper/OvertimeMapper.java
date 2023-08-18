package com.scheduling_employee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scheduling_employee.pojo.Overtime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author yy
* @description 针对表【overtime】的数据库操作Mapper
* @createDate 2023-08-04 19:14:25
* @Entity com.example.arrange.domain.Overtime
*/
@Mapper
public interface OvertimeMapper extends BaseMapper<Overtime> {

    @Select("select * from overtime where user_id = #{id}")
    List<Overtime> selectByUserId(@Param("id") String userId);

    @Insert("insert into `overtime`(overtime_id,user_id,start_time,end_time,type,status,reason) " +
            "values (#{overtimeId},#{userId},#{startTime},#{endTime},#{type},#{status},#{reason})")
    Integer addOvertime(Overtime overtime);
}




