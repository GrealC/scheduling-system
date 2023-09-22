package com.example.scheduling_system.Controller;


import com.example.scheduling_system.Entity.ResBean;
import com.example.scheduling_system.Entity.users;
import com.example.scheduling_system.Service.userService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private userService userService;

    @ApiOperation("增加用户")
    @PostMapping("/addUser")
    public ResBean addUser(@RequestBody users user){
        ResBean resBean = userService.insertUser(user);
        return resBean;
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/delectUser")
    public ResBean delectUser(int id){
        ResBean resBean = userService.delectUser(id);
        return resBean;
    }

    @ApiOperation("/查询用户")
    @GetMapping("/selectUsers")
    public ResBean selectAll(){
        ResBean resBean = userService.selectUsers();
        return resBean;
    }

}
