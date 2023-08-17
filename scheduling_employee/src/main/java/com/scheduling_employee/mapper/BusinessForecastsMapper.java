package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.BusinessForecasts;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
public interface BusinessForecastsMapper {

    /*
    * 存储预测信息
    * */
    @Insert("INSERT INTO business_forecasts (store_id, date, foot_traffic) VALUES (#{storeId},#{date},#{footTraffic})")
    void storagePredictCustomers(String storeId, Date date, int footTraffic);

}