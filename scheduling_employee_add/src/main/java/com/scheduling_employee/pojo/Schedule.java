package com.scheduling_employee.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName schedule
 */
@Data
@ApiModel("排班实体")
public class Schedule implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("scheduleId")
    private String scheduleId;
    @ApiModelProperty("userId")
    private String userId;
    @ApiModelProperty("storeId")
    private String storeId;
    @ApiModelProperty("startTime")
    private Date startTime;
    @ApiModelProperty("endTime")
    private Date endTime;
    @ApiModelProperty("type")
    private String type;
    @ApiModelProperty("status")
    private String status;
    @ApiModelProperty("reason")
    private String reason;

    private static final long serialVersionUID = 1L;
}