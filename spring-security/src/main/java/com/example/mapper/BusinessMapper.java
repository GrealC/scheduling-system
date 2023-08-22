package com.example.mapper;

import com.example.domain.Business;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface BusinessMapper {
    List<Business> getBusiness();
}
