package com.scheduling_employee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Business implements Serializable {
    private static final long serialVersionUID = 1L;
    private String storeName;
    private Date date;
    private Integer business;
}
