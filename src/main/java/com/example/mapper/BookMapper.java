package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liu
 * @since 2021-08-23
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
