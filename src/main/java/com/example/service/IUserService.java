package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.User;
import com.example.util.result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liu
 * @since 2021-08-23
 */
public interface IUserService extends IService<User> {

    Result login(String username, String password, String code, HttpServletRequest request);
}
