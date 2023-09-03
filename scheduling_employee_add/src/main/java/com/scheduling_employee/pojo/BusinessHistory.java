package com.scheduling_employee.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * business_history
 */
@Data
public class BusinessHistory implements Serializable {
    private int historyId;

    private String storeId;

    private Date date;

    private String weather;

    private Boolean isVacation;

    private Integer business;

    private static final long serialVersionUID = 1L;
}