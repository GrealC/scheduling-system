package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.Overtime;
import com.scheduling_employee.service.OvertimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/overtime")
@Api(tags = "OvertimeController")
public class OvertimeController {
    @Autowired
    private OvertimeService overtimeService;

    /**
     * 加班情况查看
     * @param userId
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("queryOvertimeByUserId")
    public List<Overtime> queryOvertimeByUserId(@PathVariable("id") String userId){
        return overtimeService.selectByUserId(userId);
    }

    /**
     * 加班申请
     * @param overtime
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("addOvertime")
    public boolean addOvertime(@RequestBody Overtime overtime){
        return overtimeService.addOvertime(overtime);
    }
}
