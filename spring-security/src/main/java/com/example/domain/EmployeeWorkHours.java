package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWorkHours implements Serializable {
    private static final long serialVersionUID = 1L;
    private String workHoursId;
    private String userId;
    private Date date;
    private BigDecimal hoursWorked;
}
