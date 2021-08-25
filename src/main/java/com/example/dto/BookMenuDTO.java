package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookMenuDTO {
    private Integer id;
    private String passageName;
    private Integer articleLength;
    private String state;
    private LocalDateTime createTime;
    private LocalDateTime modificationTime;
}
