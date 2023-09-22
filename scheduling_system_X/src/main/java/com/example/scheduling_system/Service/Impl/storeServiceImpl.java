package com.example.scheduling_system.Service.Impl;

import com.example.scheduling_system.Dao.storeMapper;
import com.example.scheduling_system.Entity.CodeNum;
import com.example.scheduling_system.Entity.ResBean;
import com.example.scheduling_system.Entity.store;
import com.example.scheduling_system.Service.storeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class storeServiceImpl implements storeService {

    @Autowired
    private com.example.scheduling_system.Dao.storeMapper storeMapper;

    @Override
    public ResBean addStore(store store) {
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
            List<store> stores = storeMapper.selectList(null);
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
