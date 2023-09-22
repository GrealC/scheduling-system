package com.scheduling_employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scheduling_employee.pojo.Overtime;

import java.util.List;

/**
* @author yy
* @description 针对表【overtime】的数据库操作Service
* @createDate 2023-08-04 19:14:25
*/
public interface OvertimeService extends IService<Overtime> {


    List<Overtime> selectByUserId(String userId);

    boolean addOvertime(Overtime overtime);
}
