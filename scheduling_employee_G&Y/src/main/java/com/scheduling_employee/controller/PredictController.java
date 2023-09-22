package com.scheduling_employee.controller;

import com.scheduling_employee.pojo.Result;
import com.scheduling_employee.service.PredictService;
import com.scheduling_employee.service.impl.PredictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 预测客流量
*/
@RestController
public class PredictController {

    @Autowired
    private PredictService predictService;

    @RequestMapping("/predict")
    public Result predictTraffic(String storeId, String time) {

        //数据处理
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Date date = null;

        try {
            date = ft.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String[][] customers = predictService.predictCustomer(storeId, date);

        return Result.success(customers);
    }

}
