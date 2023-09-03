package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.Business;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessMapper {
    List<Business> getBusiness();
}
