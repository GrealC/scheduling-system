package com.scheduling_employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scheduling_employee.pojo.Users;

/**
* @author yy
* @description 针对表【users】的数据库操作Service
* @createDate 2023-08-04 18:38:28
*/
public interface UsersService extends IService<Users> {

    //JiangWen
    void add(Users user);

    Users findUserName(String userName);

    Users findUserPhone(String phone);

    Users login(Users user);

    void update(Users user);

    Users retrieveEmail(String email);

    void updateByEmail(String email, String password);

    Users retrieveMobile(String phone);

    void updateByMobile(String phone, String password);

    void delete(String username);
}
