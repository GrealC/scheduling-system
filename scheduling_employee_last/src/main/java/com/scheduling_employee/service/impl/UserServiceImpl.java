package com.scheduling_employee.service.impl;

import com.scheduling_employee.mapper.UserMapper;
import com.scheduling_employee.mapper.UsersMapper;
import com.scheduling_employee.pojo.CodeNum;
import com.scheduling_employee.pojo.ResBean;
import com.scheduling_employee.pojo.User;
import com.scheduling_employee.pojo.Users;
import com.scheduling_employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsersMapper usersMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public ResBean insertUser(Users user) {
        try{
            int insert = usersMapper.insert(user);
            if(insert==0)return new ResBean(CodeNum.ERROR_CODE,"插入失败",null);
            return new ResBean(CodeNum.SUCCESS_CODE,"插入成功",null);
        }catch (Exception exception){
            return new ResBean(CodeNum.ERROR_CODE,"系统出现异常",null);
        }
    }

    @Override
    public ResBean deleteUser(int id) {
        try{
            int i = usersMapper.deleteById(id);
            if(i==0)return new ResBean(CodeNum.ERROR_CODE,"该用户不存在",null);
            return new ResBean(CodeNum.SUCCESS_CODE,"删除成功",null);
        }catch (Exception exception){
            return new ResBean(CodeNum.ERROR_CODE,"系统出现异常",null);
        }
    }

    @Override
    public ResBean selectUsers() {
        try {
            List<Users> users = usersMapper.selectList(null);
            if (users.size()==0)return new ResBean(CodeNum.ERROR_CODE,"数据为空",null);
            return new ResBean(CodeNum.SUCCESS_CODE,"查询成功",users);
        }catch (Exception exception){
            return new ResBean(CodeNum.ERROR_CODE,"系统出现异常",null);
        }
    }

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
