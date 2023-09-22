package com.example.mapper;

import com.example.domain.TotalWork;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface TotalWorkMapper {
    List<TotalWork> allWorkTime();
    void updateSalary(TotalWork list);
}
