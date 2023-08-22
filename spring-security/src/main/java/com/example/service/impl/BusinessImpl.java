package com.example.service.impl;

import com.example.domain.Business;
import com.example.mapper.BusinessMapper;
import com.example.service.BusinessService;
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
