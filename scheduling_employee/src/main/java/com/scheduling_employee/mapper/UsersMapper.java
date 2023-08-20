package com.scheduling_employee.mapper;

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