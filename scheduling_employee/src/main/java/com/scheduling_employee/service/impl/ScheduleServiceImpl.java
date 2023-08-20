package com.scheduling_employee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scheduling_employee.mapper.ScheduleMapper;
import com.scheduling_employee.pojo.Schedule;
import com.scheduling_employee.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yy
* @description 针对表【schedule】的数据库操作Service实现
* @createDate 2023-08-15 08:16:20
*/
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
    implements ScheduleService{
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> selectByUserId(String userId) {
        return scheduleMapper.selectByUserId(userId);
    }

    @Override
    public boolean addSchedule(Schedule schedule) {
        Integer cnt=scheduleMapper.addSchedule(schedule);
        return cnt>0;
    }
}




