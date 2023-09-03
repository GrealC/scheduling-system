package com.scheduling_employee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scheduling_employee.mapper.UsersMapper;
import com.scheduling_employee.pojo.Users;
import com.scheduling_employee.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
* @author yy
* @description 针对表【users】的数据库操作Service实现
* @createDate 2023-08-04 18:38:28
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

    //JiangWen
    @Autowired
    private UsersMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public void add(Users user) {
        user.setUser_id(UUID.randomUUID().toString().replace("-",""));
        String password = user.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        user.setPassword(encodePassword);
        userMapper.insert(user);
    }

    @Override
    public Users findUserName(String userName) {
        Users user=userMapper.selectByUserName(userName);
        return user;
    }

    @Override
    public Users findUserPhone(String phone) {
        Users user=userMapper.selectByPhone(phone);
        return user;
    }

    @Override
    public Users login(Users user) {
        return userMapper.getByUserNameAndPwd(user);
    }

    @Override
    public void update(Users user) {
        String password = user.getPassword();
        if(password!=null){
            String encodePassword = passwordEncoder.encode(password);
            user.setPassword(encodePassword);
        }
        userMapper.update(user);
    }

    @Override
    public void delete(String username) {
        userMapper.deleteByUsername(username);
    }

    @Override
    public Users retrieveEmail(String email) {
        return userMapper.findEmail(email);
    }

    @Override
    public void updateByEmail(String email, String password) {
        userMapper.updateByEmail(email,password);
    }

    @Override
    public Users retrieveMobile(String phone) {
        return userMapper.findMobile(phone);
    }

    @Override
    public void updateByMobile(String phone, String password) {
        userMapper.updateByMobile(phone,password);
    }
}




