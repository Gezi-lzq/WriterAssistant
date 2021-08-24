package com.example.util.result;

public interface CustomizeResult {

    /**
     * 返回状态码
     * @return
     */
    Integer getCode();

    /**
     * 返回状态信息
     * @return
     */
    String getMessage();
}
