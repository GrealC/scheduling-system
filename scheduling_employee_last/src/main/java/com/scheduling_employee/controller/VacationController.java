package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.Vacation;
import com.scheduling_employee.service.VacationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacation")
@Api(tags = "VacationController")
public class VacationController {
    @Autowired
    private VacationService vacationService;

    /**
     * 查看假期日历
     * @param userId
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("queryVacationByUserId")
    public List<Vacation> queryVacationByUserId(@PathVariable("id") String userId){
        return vacationService.selectByUserId(userId);
    }

    @PostMapping("/add")
    @ApiOperation("addVacation")
    public boolean addVacation(@RequestBody Vacation vacation){
        return vacationService.addVacation(vacation);
    }
}
