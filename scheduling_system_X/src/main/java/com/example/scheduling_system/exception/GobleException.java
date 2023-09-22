package com.example.scheduling_system.exception;

import com.example.scheduling_system.Entity.CodeNum;
import com.example.scheduling_system.Entity.ResBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobleException {

    @ExceptionHandler(Exception.class)
    public ResBean ExceptionHandle(){
        return new ResBean(CodeNum.EXCEPTION_ERROR,"服务器异常",null);
    }
}
