package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.CodeNum;
import com.scheduling_employee.pojo.DailySchedule;
import com.scheduling_employee.pojo.ResBean;
import com.scheduling_employee.pojo.Schedule;
import com.scheduling_employee.service.ScheduleService;
import com.scheduling_employee.service.SchedulingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedule")
@Api(tags = "ScheduleController")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private SchedulingService schedulingService;
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

    @ApiOperation("创建排班表")
    @PostMapping("/create")
    public ResBean createTable(@RequestBody DailySchedule schedule){
        boolean result = schedulingService.selectByStoreId(schedule.getStoreId());
        if(!result)return new ResBean(CodeNum.ERROR_CODE,"该店铺的排班表已达上限,不能再排班",null);
        schedule.setScheduleId(UUID.randomUUID().toString());
        schedule.setDate(new Date());
        ResBean resBean = schedulingService.createTable(schedule);
        return resBean;
    }

    /**
     * 管理员传入要修改的信息到schedule实体里，该controller对传入的参数进行修改，修改排班表与手动进行排班
     * 都可以使用该updateTable接口
     * @param schedule
     * @return
     */
    @ApiOperation("管理员修改排班表")
    @PostMapping("/update")
    public ResBean updateTable(@RequestBody DailySchedule schedule){
        ResBean resBean = schedulingService.updateTable(schedule);
        return resBean;
    }
}
