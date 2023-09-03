package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.Leave;
import com.scheduling_employee.service.LeaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
@Api(tags = "LeaveController")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    /**
     * 请假情况查看
     * @param userId
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("queryLeaveByUserId")
    public List<Leave> queryLeaveByUserId(@PathVariable("id") String userId){
        return leaveService.selectByUserId(userId);
    }

    /**
     * 请假申请
     * @param leave
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("addLeave")
    public boolean addLeave(@RequestBody Leave leave){
        return leaveService.addLeave(leave);
    }

}
