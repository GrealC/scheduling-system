package com.scheduling_employee.exception;

import com.scheduling_employee.pojo.CodeNum;
import com.scheduling_employee.pojo.ResBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobleException {

    @ExceptionHandler(Exception.class)
    public ResBean ExceptionHandle(){
        return new ResBean(CodeNum.EXCEPTION_ERROR,"服务器异常",null);
    }
}
