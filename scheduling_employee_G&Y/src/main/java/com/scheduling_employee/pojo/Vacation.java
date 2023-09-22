package com.scheduling_employee.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName employee_vacation_calendars
 */
@Data
@ApiModel("假期日历实体")
public class Vacation implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("calendarId")
    private String calendarId;
    @ApiModelProperty("userId")
    private String userId;
    @ApiModelProperty("date")
    private Date date;

    private static final long serialVersionUID = 1L;
}