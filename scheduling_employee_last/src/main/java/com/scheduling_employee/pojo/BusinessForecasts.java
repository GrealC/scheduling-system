package com.scheduling_employee.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * business_forecasts
 */
@Data
public class BusinessForecasts implements Serializable {
    private int forecastId;

    private String storeId;

    private Date date;

    private Integer footTraffic;

    private static final long serialVersionUID = 1L;
}