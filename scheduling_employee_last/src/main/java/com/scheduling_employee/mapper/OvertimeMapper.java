package com.scheduling_employee.mapper;


import com.scheduling_employee.pojo.Overtime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Param;


import java.util.List;


@Mapper
public interface OvertimeMapper extends BaseMapper<Overtime>{

    /*
    *  获取员工加班信息
    * */
    @Select("select * from overtime")
    List<Overtime> getOverTime();
    /**
     * @author yy
     * @description 针对表【overtime】的数据库操作Mapper
     * @createDate 2023-08-04 19:14:25
     * @Entity com.example.arrange.domain.Overtime
     */
    @Select("select * from overtime where user_id = #{id}")
    List<Overtime> selectByUserId(@Param("id") String userId);

    @Insert("insert into `overtime`(overtime_id,user_id,start_time,end_time,type,status,reason) " +
            "values (#{overtimeId},#{userId},#{startTime},#{endTime},#{type},#{status},#{reason})")
    Integer addOvertime(Overtime overtime);
}


//@Mapper
//public interface OvertimeMapper extends BaseMapper<Overtime> {
//
//    @Select("select * from overtime where user_id = #{id}")
//    List<Overtime> selectByUserId(@Param("id") String userId);
//
//    @Insert("insert into `overtime`(overtime_id,user_id,start_time,end_time,type,status,reason) " +
//            "values (#{overtimeId},#{userId},#{startTime},#{endTime},#{type},#{status},#{reason})")
//    Integer addOvertime(Overtime overtime);
//}
//
//
//
//
//>>>>>>> 49b43898253f3622472d3d755702b2966d0380d8
