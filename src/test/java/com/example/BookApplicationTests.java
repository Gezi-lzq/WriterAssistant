package com.example;

import com.example.entity.Book;
import com.example.entity.User;
import com.example.mapper.BookMapper;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        List<Book> books = bookMapper.selectList(null);
        books.forEach(System.out::println);
    }

}
