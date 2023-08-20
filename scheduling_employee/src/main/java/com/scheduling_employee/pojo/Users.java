package com.scheduling_employee.pojo;

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

    private BigDecimal salary;

    private static final long serialVersionUID = 1L;
}