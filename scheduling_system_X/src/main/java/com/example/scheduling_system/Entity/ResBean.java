package com.example.scheduling_system.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResBean {
    /**
     * 状态码
     */
    @NotNull
    private int code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;
}
