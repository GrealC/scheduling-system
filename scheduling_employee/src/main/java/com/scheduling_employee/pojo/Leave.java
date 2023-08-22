package com.scheduling_employee.pojo;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * leave
 */
@Data
public class Leave implements Serializable {
    private String leave_id;

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
 * @TableName leave
 */
@Data
@ApiModel("请假实体")
public class Leave implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("leaveId")
    private String leaveId;
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