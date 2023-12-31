package com.scheduling_employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class})
public class SchedulingEmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulingEmployeeApplication.class, args);
    }

}
