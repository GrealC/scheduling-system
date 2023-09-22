package com.example.scheduling_system.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.scheduling_system.Entity.dailySchedule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface scheduleMapper extends BaseMapper<dailySchedule> {
}
