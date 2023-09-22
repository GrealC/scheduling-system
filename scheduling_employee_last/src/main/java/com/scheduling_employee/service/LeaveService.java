package com.scheduling_employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scheduling_employee.pojo.Leave;

import java.util.List;

/**
* @author yy
* @description 针对表【leave】的数据库操作Service
* @createDate 2023-08-04 19:14:31
*/

public interface LeaveService extends IService<Leave> {
    List<Leave> selectByUserId(String userId);

    boolean addLeave(Leave leave);
}
