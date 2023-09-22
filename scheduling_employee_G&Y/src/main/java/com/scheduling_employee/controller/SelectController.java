package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.Result;
import com.scheduling_employee.pojo.Users;
import com.scheduling_employee.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelectController {

    @Autowired
    private SelectService selectService;

    /*
    * 获取员工信息
    * */
    @RequestMapping("/userInfo")
    public Result getUserInfo(String uid){
        return Result.success(selectService.selectUserInfo(uid));
    }

    /*
    * 获取店铺排班规则
    * */
    @RequestMapping("/getRule")
    public Result getRules(String storeId){

        return Result.success(selectService.selectSchedulesRules(storeId));
    }
}
