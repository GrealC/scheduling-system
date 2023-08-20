package com.scheduling_employee.mapper;

<<<<<<< HEAD
import com.scheduling_employee.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    List<Users> getUsers();

    /*
    *  通过uid获取员工信息
    * */
    @Select("select * from users where user_id = #{uid}")
    Users getUserInfo(String uid);
}
=======
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scheduling_employee.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yy
* @description 针对表【users】的数据库操作Mapper
* @createDate 2023-08-04 18:38:28
* @Entity com.example.arrange.domain.Users
*/
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}




>>>>>>> 49b43898253f3622472d3d755702b2966d0380d8
