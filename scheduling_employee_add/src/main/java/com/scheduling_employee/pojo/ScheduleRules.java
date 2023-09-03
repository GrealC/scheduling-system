package com.scheduling_employee.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * schedule_rules
 */
@Data
public class ScheduleRules implements Serializable {
    private String ruleId;

    private String storeId;

    private Integer workDaysPerWeek;

    private Integer workHoursPerDay;

    private String daysWorkPeriod;

    private Integer maxWorkHoursPerWeek;

    private Integer maxWorkHoursPerMonth;

    private static final long serialVersionUID = 1L;
}