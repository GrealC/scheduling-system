package com.scheduling_employee.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * users
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体")
public class Users implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("userId")
    private String user_id;
    @ApiModelProperty("username")
    private String username;
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("password")
    private String password;
    @ApiModelProperty("email")
    private String email;
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3|4|5|7|8|9][0-9]{9}$",message = "请输入正确的手机号")
    @ApiModelProperty("phone")
    private String phone;
    @ApiModelProperty("speciality")
    private String speciality;
    @ApiModelProperty("age")
    private Integer age;
    @ApiModelProperty("gender")
    @Pattern(regexp = "^(男|女|其他)$",message = "设置性别请输入男|女|其他")
    private Object gender;
    @Pattern(regexp = "^(店⻓|服务员|后勤|管理员)$",message = "设置角色请输入店⻓|服务员|后勤|管理员角色")
    @ApiModelProperty("role")
    private Object role;
    @ApiModelProperty("salary")
    private BigDecimal salary;

    private static final long serialVersionUID = 1L;

}