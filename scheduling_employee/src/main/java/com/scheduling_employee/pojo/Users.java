package com.scheduling_employee.pojo;

<<<<<<< HEAD
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * users
 */
@Data
public class Users implements Serializable {
    private String user_id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String speciality;

    private Integer age;

    private Object gender;

    private Object role;

=======
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @TableName users
 */
@Data
@ApiModel("用户实体")
public class Users implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("userId")
    private String userId;
    @ApiModelProperty("username")
    private String username;
    @ApiModelProperty("password")
    private String password;
    @ApiModelProperty("email")
    private String email;
    @ApiModelProperty("phone")
    private String phone;
    @ApiModelProperty("speciality")
    private String speciality;
    @ApiModelProperty("age")
    private Integer age;
    @ApiModelProperty("gender")
    private Object gender;
    @ApiModelProperty("role")
    private Object role;
    @ApiModelProperty("salary")
>>>>>>> 49b43898253f3622472d3d755702b2966d0380d8
    private BigDecimal salary;

    private static final long serialVersionUID = 1L;
}