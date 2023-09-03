package com.scheduling_employee.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * overtime
 */
@Data
@ApiModel("加班实体")
public class Overtime implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("overtimeId")
    private String overtime_id;
    @ApiModelProperty("userId")
    private String user_id;
    @ApiModelProperty("startTime")
    private Date start_time;
    @ApiModelProperty("endTime")
    private Date end_time;
    @ApiModelProperty("type")
    private String type;
    @ApiModelProperty("status")
    private String status;
    @ApiModelProperty("reason")

    private static final long serialVersionUID = 1L;

}