package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.BookMenu;
import com.example.mapper.BookMenuMapper;
import com.example.service.IBookMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liu
 * @since 2021-08-23
 */
@Service
public class BookMenuServiceImpl extends ServiceImpl<BookMenuMapper, BookMenu> implements IBookMenuService {

}
