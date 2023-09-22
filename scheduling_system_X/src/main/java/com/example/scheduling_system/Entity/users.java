package com.example.scheduling_system.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class users {
    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    private String email;

    private String phone;

    private String speciality;

    private int age;
    private enum gender{
        man,woman
    };
    private enum role{
        leader,classman
    };
    private double salary;
}
