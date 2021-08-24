package com.example.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import com.example.util.result.Result;
import com.example.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liu
 * @since 2021-08-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(String username, String password, String code, HttpServletRequest request) {
        String captcha = (String)request.getSession().getAttribute("captcha");
        if (StrUtil.isEmpty(captcha)||!captcha.equalsIgnoreCase(code)){
            return Result.error().message("验证码错误");
        }
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        User user = userMapper.selectOne(queryWrapper);

        if (user==null){
            return Result.error(ResultCode.FORBIDDEN);
        }
        return Result.ok();
    }
}
