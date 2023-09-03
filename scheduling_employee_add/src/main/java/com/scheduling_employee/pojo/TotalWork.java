package com.scheduling_employee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TotalWork implements Serializable {
    private String username;
    private String role;
    private BigDecimal totalTime;
    private BigDecimal salary;
}
