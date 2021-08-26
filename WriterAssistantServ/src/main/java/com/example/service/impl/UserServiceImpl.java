package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Book;
import com.example.entity.User;
import com.example.mapper.BookMapper;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import com.example.util.result.Result;
import com.example.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Result login(String username, String password) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        User user = userMapper.selectOne(queryWrapper);

        if (user==null){
            return Result.error(ResultCode.FORBIDDEN);
        }else{
            List<Book> books = bookMapper.selectList(null);
            Map<String,Object> map = new HashMap<>();
            map.put("content",books);
            return Result.ok().data(map);
        }

    }
}
