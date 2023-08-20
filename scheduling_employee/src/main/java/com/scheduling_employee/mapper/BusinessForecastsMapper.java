package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.BusinessForecasts;
import com.scheduling_employee.pojo.BusinessHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
public interface BusinessForecastsMapper {

    /*
    * 存储预测信息
    * */
    @Insert("INSERT INTO business_forecasts (store_id, date, foot_traffic) VALUES (#{storeId},#{date},#{footTraffic})")
    void storagePredictCustomers(String storeId, Date date, int footTraffic);

    /*
    *  获取店铺的预测信息
    * */
    @Select("SELECT * from business_forecasts where store_id = #{storeId} and date = #{nowDate}")
    BusinessForecasts selectPredictCustomers(String storeId, Date nowDate);


}