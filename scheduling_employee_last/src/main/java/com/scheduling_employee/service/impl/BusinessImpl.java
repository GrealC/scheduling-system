package com.scheduling_employee.service.impl;


import com.scheduling_employee.mapper.BusinessMapper;
import com.scheduling_employee.pojo.Business;
import com.scheduling_employee.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessImpl  implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public List<Business> selectBusiness() {
        return businessMapper.getBusiness();
    }
}
