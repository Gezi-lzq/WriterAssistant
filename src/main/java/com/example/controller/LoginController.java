package com.example.controller;


import com.example.vo.UserLoginVO;
import com.example.service.IUserService;
import com.example.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginVO loginDTO){

        return userService.login(loginDTO.getUsername(),loginDTO.getPassword());
    }
}
