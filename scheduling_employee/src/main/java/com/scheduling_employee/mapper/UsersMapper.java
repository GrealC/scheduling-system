package com.scheduling_employee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scheduling_employee.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yy
* @description 针对表【users】的数据库操作Mapper
* @createDate 2023-08-04 18:38:28
* @Entity com.example.arrange.domain.Users
*/
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}




