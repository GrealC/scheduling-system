package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(User user);

    User selectByUserName(String userName);

    User selectByPhone(String phone);

    User getByUserNameAndPwd(User user);

    void update(User user);

    void deleteByUsername(String username);

    User findEmail(String email);

    void updateByEmail(String email, String password);

    User findMobile(String phone);

    void updateByMobile(String phone, String password);
}
