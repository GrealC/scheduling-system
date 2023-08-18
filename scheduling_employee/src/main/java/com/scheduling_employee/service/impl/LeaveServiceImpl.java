package com.scheduling_employee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scheduling_employee.mapper.LeaveMapper;
import com.scheduling_employee.pojo.Leave;
import com.scheduling_employee.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yy
* @description 针对表【leave】的数据库操作Service实现
* @createDate 2023-08-04 19:14:31
*/
@Service
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave>
    implements LeaveService{

    @Autowired
    private LeaveMapper leaveMapper;
    @Override
    public List<Leave> selectByUserId(String userId) {
        return leaveMapper.selectByUserId(userId);
    }

    @Override
    public boolean addLeave(Leave leave) {
        Integer cnt=leaveMapper.addLeave(leave);
        return cnt>0;
    }
}




