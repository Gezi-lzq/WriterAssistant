package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePassageVO {
    private Integer id;  //文章id
    private String passageName;  //(new) 文章名字
    private String stage;      //(new) 文章状态码
}
