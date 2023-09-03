package com.scheduling_employee.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * employee_work_periods
 */
@Data
public class EmployeeWorkPeriods implements Serializable {

    private int workPeriod_id;

    private String user_id;

    private Date start_time;

    private Date end_time;

    private static final long serialVersionUID = 1L;
}