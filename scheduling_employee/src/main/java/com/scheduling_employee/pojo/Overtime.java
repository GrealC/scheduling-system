package com.scheduling_employee.pojo;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * overtime
 */
@Data
public class Overtime implements Serializable {

    private String overtime_id;

    private String user_id;

    private Date start_time;

    private Date end_time;

    private String type;

    private String status;

=======
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName overtime
 */
@Data
@ApiModel("加班实体")
public class Overtime implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("overtimeId")
    private String overtimeId;
    @ApiModelProperty("userId")
    private String userId;
    @ApiModelProperty("startTime")
    private Date startTime;
    @ApiModelProperty("endTime")
    private Date endTime;
    @ApiModelProperty("type")
    private String type;
    @ApiModelProperty("status")
    private String status;
    @ApiModelProperty("reason")
>>>>>>> 49b43898253f3622472d3d755702b2966d0380d8
    private String reason;

    private static final long serialVersionUID = 1L;
}