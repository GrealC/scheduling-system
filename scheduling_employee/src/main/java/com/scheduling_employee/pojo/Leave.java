package com.scheduling_employee.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * leave
 */
@Data
public class Leave implements Serializable {
    private String leave_id;

    private String user_id;

    private Date start_time;

    private Date end_time;

    private String type;

    private String status;

    private String reason;

    private static final long serialVersionUID = 1L;
}