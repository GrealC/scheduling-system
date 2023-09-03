package com.scheduling_employee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scheduling_employee.mapper.VacationMapper;
import com.scheduling_employee.pojo.Vacation;
import com.scheduling_employee.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yy
* @description 针对表【employee_vacation_calendars】的数据库操作Service实现
* @createDate 2023-08-04 19:18:36
*/
@Service
public class VacationServiceImpl extends ServiceImpl<VacationMapper, Vacation>
    implements VacationService {

    @Autowired
    private VacationMapper vacationMapper;
    @Override
    public List<Vacation> selectByUserId(String userId) {
        return vacationMapper.selectByUserId(userId);
    }

    @Override
    public boolean addVacation(Vacation vacation) {
        Integer cnt=vacationMapper.addVacation(vacation);
        return cnt>0;
    }
}




