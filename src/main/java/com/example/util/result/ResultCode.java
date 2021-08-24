package com.example.util.result;

public enum ResultCode implements CustomizeResult {

    OK(200,"请求成功"),
    CREATED(201,"创建成功"),
    DELETED(204,"删除成功"),
    BAD_REQUEST(400,"请求地址错误"),
    UNAUTHORIZED(401,"未登录"),
    FORBIDDEN(403,"权限不足"),
    NOT_FOUND(404,"未找到访问资源"),
    ERROR(500,"出现错误");
    ;

    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
