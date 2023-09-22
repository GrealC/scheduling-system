package com.scheduling_employee.mapper;

<<<<<<< HEAD
import com.scheduling_employee.pojo.Leave;
import org.apache.ibatis.annotations.Mapper;
=======
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scheduling_employee.pojo.Leave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
>>>>>>> 49b43898253f3622472d3d755702b2966d0380d8
import org.apache.ibatis.annotations.Select;

import java.util.List;

<<<<<<< HEAD
@Mapper
public interface LeaveMapper {

    /*
    *  获取员工休假时间
    * */
    @Select("select * from `leave`")
    List<Leave> getLeaveInfo();

}
=======
/**
* @author yy
* @description 针对表【leave】的数据库操作Mapper
* @createDate 2023-08-04 19:14:31
* @Entity com.example.arrange.domain.Leave
*/
@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {
    @Select("select * from `leave` where user_id = #{userId}")
    List<Leave> selectByUserId(@Param("userId") String userId);

    @Insert("insert into `leave`(leave_id,user_id,start_time,end_time,type,status,reason) " +
            "values (#{leaveId},#{userId},#{startTime},#{endTime},#{type},#{status},#{reason})")
    Integer addLeave(Leave leave);
}




>>>>>>> 49b43898253f3622472d3d755702b2966d0380d8
