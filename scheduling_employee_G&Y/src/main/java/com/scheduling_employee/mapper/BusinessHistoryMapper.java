package com.scheduling_employee.mapper;

import com.scheduling_employee.pojo.BusinessHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
public interface BusinessHistoryMapper {

    /*
    * 根据店铺id-时段 例如：1-1 店铺id=1、时段=1(上午)
    * 查询该店铺所有的历史客流量信息
    * */
    @Select("select * from business_history where store_id=#{storeId}")
    List<BusinessHistory> selectBusiness(String storeId);


    /*
    * 储存店铺客流量信息
    * */
    @Insert("INSERT INTO business_history (store_id, date, weather, is_vacation, business) VALUES (#{storeId},#{date},#{weather},#{isVacation},#{business})")
    void insertBusinessHistory(String storeId,Date date,String weather, Boolean isVacation, Integer business);
}