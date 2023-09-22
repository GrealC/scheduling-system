package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String userId;
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    private String email;
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3|4|5|7|8|9][0-9]{9}$",message = "请输入正确的手机号")
    private String phone;
    private String speciality;
    private Integer age;
    @Pattern(regexp = "^(男|女|其他)$",message = "设置性别请输入男|女|其他")
    private String gender;
    @Pattern(regexp = "^(店⻓|服务员|后勤|管理员)$",message = "设置角色请输入店⻓|服务员|后勤|管理员角色")
    private String role;
    private BigDecimal salary;
}
