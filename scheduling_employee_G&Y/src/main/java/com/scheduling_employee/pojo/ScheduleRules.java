package com.scheduling_employee.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * schedule_rules
 */
@Data
public class ScheduleRules implements Serializable {
    private String rule_id;

    private String store_id;

    private Integer work_days_per_week;

    private Integer work_hours_per_day;

    private String days_work_period;

    private Integer max_work_hours_per_week;

    private Integer max_work_hours_per_month;

    private static final long serialVersionUID = 1L;
}