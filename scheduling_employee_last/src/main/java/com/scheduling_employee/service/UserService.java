package com.scheduling_employee.service;

import com.scheduling_employee.pojo.ResBean;
import com.scheduling_employee.pojo.User;
import com.scheduling_employee.pojo.Users;

public interface UserService {

     void add(User user);

     User findUserName(String userName);

     User findUserPhone(String phone);

     User login(User user);

     void update(User user);

    User retrieveEmail(String email);

     void updateByEmail(String email, String password);

    User retrieveMobile(String phone);

    void updateByMobile(String phone, String password);

    void delete(String username);

    ResBean insertUser(Users user);

    ResBean deleteUser(int id);

    ResBean selectUsers();
}
