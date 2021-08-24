package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liu
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("book_menu")
public class BookMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String passage_name;

    private String article_length;

    private Integer state;

    private LocalDateTime create_time;

    private LocalDateTime modification_time;

    private byte[] passage_content;


}
