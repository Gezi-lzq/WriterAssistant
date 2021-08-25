package com.example.util.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
    private Boolean success;
    private Integer status;
    private String msg;
    private Map<String,Object> data=new HashMap<>();

    private Result(){

    }
    public static Result ok(){
        Result result=new Result();
        result.setSuccess(true);
        result.setStatus(ResultCode.OK.getCode());
        result.setMsg(ResultCode.OK.getMessage());
        return result;
    }
    public static Result ok(ResultCode resultCode){
        Result result=new Result();
        result.setSuccess(true);
        result.setStatus(resultCode.getCode());
        result.setMsg(resultCode.getMessage());
        return result;
    }
    public static Result error(){
        Result result=new Result();
        result.setSuccess(false);
        result.setStatus(ResultCode.ERROR.getCode());
        result.setMsg(ResultCode.ERROR.getMessage());
        return result;
    }
    public static Result error(ResultCode resultCode){
        Result result = new Result();
        result.setSuccess(false);
        result.setStatus(resultCode.getCode());
        result.setMsg(resultCode.getMessage());
        return result;
    }
    public Result success(Boolean success){
        this.success=success;
        return this;
    }
    public Result message(String message){
        this.msg=message;
        return this;
    }
    public Result data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
    public Result data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
