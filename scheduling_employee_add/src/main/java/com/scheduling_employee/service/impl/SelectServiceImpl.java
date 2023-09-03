package com.scheduling_employee.service.impl;

import com.scheduling_employee.mapper.ScheduleRulesMapper;
import com.scheduling_employee.mapper.UsersMapper;
import com.scheduling_employee.pojo.ScheduleRules;
import com.scheduling_employee.pojo.Users;
import com.scheduling_employee.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ScheduleRulesMapper scheduleRulesMapper;

    @Override
    public Users selectUserInfo(String uid) {
        return usersMapper.getUserInfo(uid);
    }

    @Override
    public List<ScheduleRules> selectSchedulesRules(String storeId) {
        return scheduleRulesMapper.getScheduleRules(storeId);
    }
}
