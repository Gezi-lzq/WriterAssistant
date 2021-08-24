package com.example.controller;


import com.example.dto.UserLoginDTO;
import com.example.service.IUserService;
import com.example.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO loginDTO, HttpServletRequest request){

        return userService.login(loginDTO.getUsername(),loginDTO.getPassword(),loginDTO.getCode(),request);
    }
}
