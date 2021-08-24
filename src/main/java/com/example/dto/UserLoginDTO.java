package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    private String username;   //用户名
    private String password;    //密码
    private String code;     //验证码
}
