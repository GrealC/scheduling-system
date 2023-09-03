package com.scheduling_employee.mapper;


import com.scheduling_employee.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    @Select("select * from users")
    List<Users> getUsers();

    /*
     *  通过uid获取员工信息
     * */
    @Select("select * from users where user_id = #{uid}")
    Users getUserInfo(String uid);

    /**
     * @author yy
     * @description 针对表【users】的数据库操作Mapper
     * @createDate 2023-08-04 18:38:28
     * @Entity com.example.arrange.domain.Users
     */


    //JIANGWEN
    int insert(Users user);

    Users selectByUserName(String userName);

    Users selectByPhone(String phone);

    Users getByUserNameAndPwd(Users user);

    void update(Users user);

    void deleteByUsername(String username);

    Users findEmail(String email);

    void updateByEmail(String email, String password);

    Users findMobile(String phone);

    void updateByMobile(String phone, String password);
}