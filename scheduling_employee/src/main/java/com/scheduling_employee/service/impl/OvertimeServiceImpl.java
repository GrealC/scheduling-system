package com.scheduling_employee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scheduling_employee.mapper.OvertimeMapper;
import com.scheduling_employee.pojo.Overtime;
import com.scheduling_employee.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yy
* @description 针对表【overtime】的数据库操作Service实现
* @createDate 2023-08-04 19:14:25
*/
@Service
public class OvertimeServiceImpl extends ServiceImpl<OvertimeMapper, Overtime>
    implements OvertimeService{
    @Autowired
    private OvertimeMapper overtimeMapper;
    @Override
    public List<Overtime> selectByUserId(String userId) {
        return overtimeMapper.selectByUserId(userId);
    }

    @Override
    public boolean addOvertime(Overtime overtime) {
        Integer cnt=overtimeMapper.addOvertime(overtime);
        return cnt>0;
    }
}




