package com.scheduling_employee.controller;


import com.scheduling_employee.pojo.Business;
import com.scheduling_employee.pojo.Result;
import com.scheduling_employee.pojo.TotalWork;
import com.scheduling_employee.service.BusinessService;
import com.scheduling_employee.service.TotalWorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/admins")
@RestController
@Slf4j
public class AdminControllor {
    @Autowired
    private TotalWorkService totalWorkService;
    @Autowired
    private BusinessService businessService;
    //可视化业务量--
    @GetMapping("/getBusiness")
    public Result getBusiness(){
        List<Business> business=businessService.selectBusiness();
        return Result.success(business);
    }

    //可视化员工工作量
//    @GetMapping("/totalTime")
//    public Result totalTime(){
//        List<TotalWork> totalWork=totalWorkService.selectAll();
//       return Result.success(totalWork);
//    }
    //可视化员工工作量和薪资报表
    @GetMapping("/selectSalary")
    public  Result selectSalary(){
        List<TotalWork> totalWork=totalWorkService.selectAll();
        return Result.success(getSalary(totalWork));
    }
    public List<TotalWork> getSalary(List<TotalWork> list){
        BigDecimal a = new BigDecimal(15);
        BigDecimal b=new BigDecimal(20);
        for (TotalWork i : list) {
            if(i.getRole().equals("后勤") || i.getRole().equals("服务员")) i.setSalary(i.getTotalTime().multiply(a));
            if(i.getRole().equals("店长"))  i.setSalary(i.getTotalTime().multiply(b));
            totalWorkService.setSalary(i);
        }
        return  list;
    }
}
