package com.example.scheduling_system.Service.Impl;

import com.example.scheduling_system.Dao.userMapper;
import com.example.scheduling_system.Entity.CodeNum;
import com.example.scheduling_system.Entity.ResBean;
import com.example.scheduling_system.Entity.users;
import com.example.scheduling_system.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class userServiceImpl implements userService {

    @Autowired
    private userMapper userMapper;
    @Override
    public ResBean insertUser(users user) {
        try{
            int insert = userMapper.insert(user);
            if(insert==0)return new ResBean(CodeNum.ERROR_CODE,"插入失败",null);
            return new ResBean(CodeNum.SUCCESS_CODE,"插入成功",null);
        }catch (Exception exception){
            return new ResBean(CodeNum.ERROR_CODE,"系统出现异常",null);
        }
    }

    @Override
    public ResBean delectUser(int id) {
        try{
            int i = userMapper.deleteById(id);
            if(i==0)return new ResBean(CodeNum.ERROR_CODE,"该用户不存在",null);
            return new ResBean(CodeNum.SUCCESS_CODE,"删除成功",null);
        }catch (Exception exception){
            return new ResBean(CodeNum.ERROR_CODE,"系统出现异常",null);
        }
    }

    @Override
    public ResBean selectUsers() {
        try {
            List<users> users = userMapper.selectList(null);
            if (users.size()==0)return new ResBean(CodeNum.ERROR_CODE,"数据为空",null);
            return new ResBean(CodeNum.SUCCESS_CODE,"查询成功",users);
        }catch (Exception exception){
            return new ResBean(CodeNum.ERROR_CODE,"系统出现异常",null);
        }
    }


}
