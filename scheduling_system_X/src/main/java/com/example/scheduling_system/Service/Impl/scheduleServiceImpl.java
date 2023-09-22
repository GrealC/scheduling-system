package com.example.scheduling_system.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.scheduling_system.Dao.scheduleMapper;
import com.example.scheduling_system.Entity.CodeNum;
import com.example.scheduling_system.Entity.ResBean;
import com.example.scheduling_system.Entity.dailySchedule;
import com.example.scheduling_system.Service.scheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class scheduleServiceImpl implements scheduleService {

    @Autowired
    private scheduleMapper scheduleMapper;

    @Override
    public boolean selectByStoreId(String storeId) {
        LambdaQueryWrapper<dailySchedule> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(dailySchedule::getStoreId,storeId);
        return scheduleMapper.selectList(queryWrapper).size()<3;
    }

    @Override
    public ResBean createTable(dailySchedule schedule) {
        try {
            int insert = scheduleMapper.insert(schedule);
            if(insert>0)return new ResBean(CodeNum.SUCCESS_CODE,"排班表生成成功",null);
            return new ResBean(CodeNum.ERROR_CODE,"排班表生成失败",null);
        }catch (Exception exception){
            return new ResBean(CodeNum.EXCEPTION_ERROR,"系统出现错误",exception.getMessage());
        }
    }

    @Override
    public ResBean updateTable(dailySchedule schedule) {
        try {
            int row = scheduleMapper.updateById(schedule);
            if(row>0)return new ResBean(CodeNum.SUCCESS_CODE,"排班表修改成功",null);
            return new ResBean(CodeNum.ERROR_CODE,"排班表修改失败",null);
        }catch (Exception exception){
            return new ResBean(CodeNum.EXCEPTION_ERROR,"系统出现错误",exception.getMessage());
        }
    }
}
