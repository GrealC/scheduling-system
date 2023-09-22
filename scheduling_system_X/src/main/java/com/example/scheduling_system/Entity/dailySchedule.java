package com.example.scheduling_system.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("daily_schedule")
public class dailySchedule {
    private String scheduleId;

    private String userId;

    private String storeId;

    private Date date;

    private Date startTime;

    private Date endTime;
}
