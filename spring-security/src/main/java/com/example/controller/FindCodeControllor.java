package com.example.controller;

import com.example.common.Result;
import com.example.config.SendMessageUtil;
import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RequestMapping("/findCode")
@RestController
@Slf4j
public class FindCodeControllor {
//    @Autowired
//    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Autowired
    RedisTemplate redisTemplate;
    @Resource
    UserService userService;

    /**
     * 通过前端ajax发送email进行验证码的发送，并生成code存入Redis,有效未3分钟,在此期间判断邮箱格式和是否被注册
     *
     * @param json
     * @return
     */
    @RequestMapping("/retrieveEmail")
    @ResponseBody
    public Result sendMailCode(@RequestParam Map<String, Object> json) {
        String message;
        try {
            String email = (String) json.get("email");
            SendMessageUtil sendMailUtil = new SendMessageUtil();
            if (!sendMailUtil.isEmail(email)) {
                message = "邮箱格式不正确";
                return Result.error(message);
            } else {
                User user = userService.retrieveEmail(email);
                if (user == null) {
                    message = "此邮箱未注册";
                    return Result.error(message);
                } else {
                    ValueOperations<String, String> operations = redisTemplate.opsForValue();
                    if (operations.get(email) != null) {
                        message = "验证码已发送,请三分钟后重试";
                        return Result.error(message);
                    } else {
                        StringBuilder code = sendMailUtil.CreateCode();
                        operations.set(email, String.valueOf(code));
                        redisTemplate.expire(email, 3, TimeUnit.MINUTES);
                        message = sendMailUtil.sendQQEmail("2797403402@qq.com", "akqmcajmwsycddbj", email, String.valueOf(code), user.getUsername());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);

            message = "出现未知错误";
            return Result.error(message);
        }
        return Result.success();
    }

    /**
     * 通过ajax发送数据,检查两次密码是否一致,邮箱是否和获取验证码的一致,验证码是否和redis中的一致,全通过则修改成功
     * @param json
     * @return
     * @throws Exception
     */
    @PostMapping("/changepwdEmail")
    @ResponseBody
    public Result changepwdEmail(@RequestParam Map<String, Object> json) throws Exception {
        String password= (String) json.get("password");
        String repassword= (String) json.get("repassword");
        String email= (String) json.get("email");
        String code= (String) json.get("code");
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String get_code= operations.get(email);
        SendMessageUtil sendMailUtil=new SendMessageUtil();
        String message="";
        int SureInformation=1;
        if(!sendMailUtil.CheckPassword(password,repassword)||password.length()<3) {
            SureInformation = 0;
            message= "两次密码不匹配";
            return Result.error(message);
        }
        if(get_code==null|| !Objects.equals(code, get_code)){
            SureInformation=0;
            message = "邮箱或验证码不正确";
            return Result.error(message);
        }
        if(SureInformation==1) {
//            String encodePassword = passwordEncoder.encode(password);
            User user=new User();
            String encodePassword = passwordEncoder.encode(password);
            user.setPassword(encodePassword);
            userService.updateByEmail(email,encodePassword);
        }
        return Result.success();
    }

    @RequestMapping("/retrieveMobile")
    @ResponseBody
    public Result sendMobileCode(@RequestParam Map<String, Object> json) {
        String message;
        try {
            String phone = (String) json.get("phone");
            System.out.println(phone);
            SendMessageUtil sendMailUtil = new SendMessageUtil();
            if (!sendMailUtil.isMobile(phone)) {
                message = "手机号格式不正确";
                return Result.error(message);
            } else {
                User user = userService.retrieveMobile(phone);
                if (user == null) {
                    message = "此手机号未注册";
                    return Result.error(message);
                } else {
                    ValueOperations<String, String> operations = redisTemplate.opsForValue();
                    if (operations.get(phone) != null) {
                        message = "验证码已发送,请三分钟后重试";
                        return Result.error(message);
                    } else {
                        StringBuilder code = sendMailUtil.CreateCode();
                        operations.set(phone, String.valueOf(code));
                        redisTemplate.expire(phone, 3, TimeUnit.MINUTES);
//                        签名  模板  手机号  验证码
                        message = sendMailUtil.sendMobile("阿里云短信测试","SMS_154950909",phone,String.valueOf(code));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            message = "出现未知错误";
            return Result.error(message);
        }
        return Result.success();
    }

    /**
     * 通过ajax发送数据,检查两次密码是否一致,邮箱是否和获取验证码的一致,验证码是否和redis中的一致,全通过则修改成功
     * @param json
     * @return
     * @throws Exception
     */
    @PostMapping("/changepwdMobile")
    @ResponseBody
    public Result changepwdMobile(@RequestParam Map<String, Object> json) throws Exception {
        String password= (String) json.get("password");
        String repassword= (String) json.get("repassword");
        String phone= (String) json.get("phone");
        String code= (String) json.get("code");
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String get_code= operations.get(phone);
        SendMessageUtil sendMailUtil=new SendMessageUtil();
        String message="";
        int SureInformation=1;
        if(!sendMailUtil.CheckPassword(password,repassword)||password.length()<3) {
            SureInformation = 0;
            message= "两次密码不匹配";
            return Result.error(message);
        }
        if(get_code==null|| !Objects.equals(code, get_code)){
            SureInformation=0;
            message = "手机号或验证码不正确";
            return Result.error(message);
        }
        if(SureInformation==1) {
            User user=new User();
            String encodePassword = passwordEncoder.encode(password);
            user.setPassword(encodePassword);
            userService.updateByMobile(phone,encodePassword);
        }
        return Result.success();
    }
}