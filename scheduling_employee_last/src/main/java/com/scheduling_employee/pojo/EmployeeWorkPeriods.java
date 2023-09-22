package com.scheduling_employee.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * employee_work_periods
 */
@Data
public class EmployeeWorkPeriods implements Serializable {

    private int workPeriodId;

    private String userId;

    private Date startTime;

    private Date endTime;

    private static final long serialVersionUID = 1L;
}