package com.example.scheduling_system.Controller;

import com.example.scheduling_system.Entity.CodeNum;
import com.example.scheduling_system.Entity.ResBean;
import com.example.scheduling_system.Entity.dailySchedule;
import com.example.scheduling_system.Service.scheduleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/schedule")
public class scheduleController {

    @Autowired
    private com.example.scheduling_system.Service.scheduleService scheduleService;

    @ApiOperation("创建排班表")
    @PostMapping("/create")
    public ResBean createTable(@RequestBody dailySchedule schedule){
        boolean result = scheduleService.selectByStoreId(schedule.getStoreId());
        if(!result)return new ResBean(CodeNum.ERROR_CODE,"该店铺的排班表已达上限,不能再排班",null);
        schedule.setScheduleId(UUID.randomUUID().toString());
        schedule.setDate(new Date());
        ResBean resBean = scheduleService.createTable(schedule);
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
    public ResBean updateTable(@RequestBody dailySchedule schedule){
        ResBean resBean = scheduleService.updateTable(schedule);
        return resBean;
    }
}
