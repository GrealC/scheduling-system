package com.scheduling_employee.controller;



import com.scheduling_employee.pojo.PasswordParam;
import com.scheduling_employee.pojo.Result;
import com.scheduling_employee.pojo.Users;
import com.scheduling_employee.service.UsersService;
import com.scheduling_employee.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UsersService userService;
    @Resource
    private PasswordEncoder passwordEncoder;
    //注册
    @PostMapping("/register")
    public Result add(@Valid @RequestBody Users user, BindingResult bindingResult
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError error : allErrors) {
                System.out.println(error);
                stringBuffer.append(error.getDefaultMessage()).append("; ");
            }
            return Result.error("注册失败");
        }
        String userName = user.getUsername();
        String phone=user.getPhone();
        Users user1 = userService.findUserName(userName);
        Users user2=userService.findUserPhone(phone);
        if (user1 != null) {
            return Result.error("用户名已被注册，请重新输入");
        }
        if (user2 != null) {
            return Result.error("电话号码已被注册，请重新输入");
        }
        userService.add(user);
        return Result.success();
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody  Users user){
        Users user1=userService.login(user);
        //登录成功，生成令牌，下发令牌
        if(user1!=null){
            if(passwordEncoder.matches(user.getPassword(),user1.getPassword()))
            {
                Map<String,Object> claims=new HashMap<>();
                claims.put("userId",user1.getUser_id());
                claims.put("username",user1.getUsername());
                String jwt= JwtUtils.generateJwt(claims);//jwt包含当前登录的员工信息
                return Result.success(jwt);
            }
        }
        //登陆失败
        return Result.error("用户名或密码错误");
    }

    //用户登录之后，修改用户密码
    @PostMapping("/loginUpdatePassword")
    public Result loginUpdatePassword(@Validated @RequestBody PasswordParam passwordParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                stringBuffer.append(objectError.getDefaultMessage()).append("; ");
            }
            String s = stringBuffer.toString();
            System.out.println(s);
            return Result.error("密码修改失败");
        }
        String jwt=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
        String username= (String) JwtUtils.parseJWT(jwt).get("username");
        Users user=userService.findUserName(username);
        //数据库密码
        String oldDataBasePassword = user.getPassword();
        //传过来的老密码
        String oldPassword = passwordParam.getOldPassword();
        //新密码
        String newPassword=passwordParam.getNewPassword();
        //确认密码
        String enPassword=passwordParam.getEnPassword();

        if (!passwordEncoder.matches(oldPassword, oldDataBasePassword)) {
            return Result.error("原密码输入错误");
        }
        if(!newPassword.equals(enPassword)){
            return Result.error("两次密码不匹配");
        }
        user.setUsername(username);
        user.setPassword(passwordParam.getNewPassword());
        userService.update(user);
        return Result.success();
    }


    //登陆后查看个人基本信息
    @GetMapping("/selectSelfInfo")
    public Result getByUserName(){
        String jwt=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
        String username= (String) JwtUtils.parseJWT(jwt).get("username");
        Users user=userService.findUserName(username);
        return Result.success(user);
    }

    //修改个人信息
    @PutMapping("/updateSelfInfo")
    public Result UpdateByUsername(@RequestBody Users user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError error : allErrors) {
                System.out.println(error);
                stringBuffer.append(error.getDefaultMessage()).append("; ");
            }
            System.out.println(stringBuffer);
            String errorInfo = stringBuffer.toString();
            return Result.error("修改失败");
        }
        String jwt=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
        String userid= (String) JwtUtils.parseJWT(jwt).get("userId");
        user.setUser_id(userid);
        userService.update(user);
        return Result.success();
    }

    //注销账户
    @DeleteMapping("/delete")
    public Result delete() {
        String jwt=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
        String username= (String) JwtUtils.parseJWT(jwt).get("username");
        userService.delete(username);
        return Result.success();
    }
}
