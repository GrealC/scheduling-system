package com.scheduling_employee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scheduling_employee.mapper.UsersMapper;
import com.scheduling_employee.pojo.Users;
import com.scheduling_employee.service.UsersService;
import org.springframework.stereotype.Service;

/**
* @author yy
* @description 针对表【users】的数据库操作Service实现
* @createDate 2023-08-04 18:38:28
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




