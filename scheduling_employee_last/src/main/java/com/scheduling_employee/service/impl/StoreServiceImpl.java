package com.scheduling_employee.service.impl;

import com.scheduling_employee.mapper.StoreMapper;
import com.scheduling_employee.pojo.CodeNum;
import com.scheduling_employee.pojo.ResBean;
import com.scheduling_employee.pojo.Store;
import com.scheduling_employee.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StoreServiceImpl implements StoreService {


    @Autowired
    private StoreMapper storeMapper;

    @Override
    public ResBean addStore(Store store) {
        try{
            int insert = storeMapper.insert(store);
            if(insert==0){
                return new ResBean(CodeNum.ERROR_CODE,"插入失败",null);
            }
            return new ResBean(CodeNum.SUCCESS_CODE,"插入成功",insert);
        }catch (Exception exception){
            return new ResBean(CodeNum.ERROR_CODE,"插入失败",null);
        }

    }

    @Override
    public ResBean selectAll() {
        try {
            List<Store> stores = storeMapper.selectList(null);
            if (stores.size() == 0) return new ResBean(CodeNum.SUCCESS_CODE, "没有店铺数据", null);
            return new ResBean(CodeNum.SUCCESS_CODE,"查询成功",stores);
        }catch (Exception exception){
            return new ResBean(CodeNum.ERROR_CODE,"出现异常",null);
        }
    }

    @Override
    public ResBean delectById(int id) {
        try {
            int code=storeMapper.deleteById(id);
            if(code==0)return new ResBean(CodeNum.ERROR_CODE,"该店铺不存在",null);
            return new ResBean(CodeNum.SUCCESS_CODE,"删除成功",null);
        }catch (Exception exception){
            return new ResBean(CodeNum.ERROR_CODE,"系统出现异常",null);
        }
    }
}