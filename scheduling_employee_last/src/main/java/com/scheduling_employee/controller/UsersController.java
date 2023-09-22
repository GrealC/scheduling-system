package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.ResBean;
import com.scheduling_employee.pojo.Users;
import com.scheduling_employee.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @ApiOperation("增加用户")
    @PostMapping("/addUser")
    public ResBean addUser(@RequestBody Users user){
        ResBean resBean = userService.insertUser(user);
        return resBean;
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/delectUser")
    public ResBean delectUser(int id){
        ResBean resBean = userService.deleteUser(id);
        return resBean;
    }

    @ApiOperation("/查询用户")
    @GetMapping("/selectUsers")
    public ResBean selectAll(){
        ResBean resBean = userService.selectUsers();
        return resBean;
    }

}
