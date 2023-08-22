package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.Schedule;
import com.scheduling_employee.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@Api(tags = "ScheduleController")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    /**
     * 排班表查看
     * @param userId
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("queryScheduleByUserId")
    public List<Schedule> queryScheduleByUserId(@PathVariable("id") String userId){
        return scheduleService.selectByUserId(userId);
    }

    /**
     * 排班表修改申请
     * @param schedule
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("addSchedule")
    public boolean addSchedule(@RequestBody Schedule schedule){
        return scheduleService.addSchedule(schedule);
    }
}
