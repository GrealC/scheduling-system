package com.example.common;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result{
    private Integer code;    //响应码
    private String message; //返回消息
    private Object data;          //返回数据

    public static Result success(){ //增删改,响应成功
        return new Result(1,"success",null);
    }

    public static Result success(Object data){//查询 成功响应
        return  new Result(1,"success",data);
    }

    public static Result error(String msg){//失败响应
        return  new Result(0,msg,null);
    }
}
