package com.scheduling_employee.service;

import java.util.Date;

public interface PredictService {

    /*
    * 根据历史数据预测未来7天的客流量(分时段预测)
    * */
    String[][] predictCustomer(String storeId, Date date);

    /*
    * 存储预测数据
    * */
    void storagePredict(String storeId, Date date, int customers);
}
