package com.scheduling_employee.pojo;

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
    private BigDecimal salary;

    private static final long serialVersionUID = 1L;
}