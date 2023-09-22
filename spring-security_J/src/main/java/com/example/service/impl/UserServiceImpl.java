package com.example.service.impl;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private UUID uuid;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public void add(User user) {
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        String password = user.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        user.setPassword(encodePassword);
        userMapper.insert(user);
    }

    @Override
    public User findUserName(String userName) {
        User user=userMapper.selectByUserName(userName);
        return user;
    }

    @Override
    public User findUserPhone(String phone) {
        User user=userMapper.selectByPhone(phone);
        return user;
    }

    @Override
    public User login(User user) {
        return userMapper.getByUserNameAndPwd(user);
    }

    @Override
    public void update(User user) {
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
    public User retrieveEmail(String email) {
        return userMapper.findEmail(email);
    }

    @Override
    public void updateByEmail(String email, String password) {
        userMapper.updateByEmail(email,password);
    }

    @Override
    public User retrieveMobile(String phone) {
        return userMapper.findMobile(phone);
    }

    @Override
    public void updateByMobile(String phone, String password) {
        userMapper.updateByMobile(phone,password);
    }
}
