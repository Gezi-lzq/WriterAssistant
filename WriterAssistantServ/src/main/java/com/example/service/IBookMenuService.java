package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.BookMenu;
import com.example.util.result.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liu
 * @since 2021-08-23
 */
public interface IBookMenuService extends IService<BookMenu> {

    Result getAllPassages();

    Result addOnePassage(Integer id, String passageName);

    Result updatePassage(Integer passageId, String passageName, String stage);

    Result deletePassage(Integer id);

    Result getOnePassageContent(Integer id);

    Result addOnePassageContent(Integer id,String passageContent);
}
