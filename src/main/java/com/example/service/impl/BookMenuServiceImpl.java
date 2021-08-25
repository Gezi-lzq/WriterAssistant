package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dto.BookMenuDTO;
import com.example.entity.BookMenu;
import com.example.mapper.BookMenuMapper;
import com.example.service.IBookMenuService;
import com.example.util.Status;
import com.example.util.result.Result;
import com.example.util.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
public class BookMenuServiceImpl extends ServiceImpl<BookMenuMapper, BookMenu> implements IBookMenuService {

    @Autowired
    private BookMenuMapper bookMenuMapper;
    @Override
    public Result getAllPassages() {
        List<BookMenu> bookMenus = bookMenuMapper.selectList(null);
        List<BookMenuDTO> bookMenuDTOS=new ArrayList<>();
        for (BookMenu menu:bookMenus) {
            BookMenuDTO menuDTO=new BookMenuDTO();
            menuDTO.setId(menu.getId());
            menuDTO.setPassageName(menu.getPassageName());
            menuDTO.setArticleLength(menu.getArticleLength());
            menuDTO.setState(Status.makeStatus(menu.getState()));
            menuDTO.setCreateTime(menu.getCreateTime());
            menuDTO.setModificationTime(menu.getModificationTime());
            bookMenuDTOS.add(menuDTO);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("totalpage",bookMenus.size());
        map.put("catalogs",bookMenuDTOS);
        return Result.ok().data(map);
    }

    @Override
    public Result addOnePassage(Integer id, String passageName) {
        BookMenu bookMenu=new BookMenu(id,passageName,null,2,LocalDateTime.now(),null,null);
        int insert = bookMenuMapper.insert(bookMenu);
        if (insert!=1){
            return Result.error();
        }else {
            Map<String,Object> map=new HashMap<>();
            map.put("id",id);
            return Result.ok(ResultCode.CREATED).message("章节创建成功").data(map);
        }
    }

    @Override
    public Result updatePassage(Integer passageId, String passageName, String stage) {
        QueryWrapper<BookMenu> eq=new QueryWrapper<>();
        eq.eq("id",passageId);
        BookMenu bookMenu = bookMenuMapper.selectOne(eq);
        if (bookMenu==null){
            return Result.error(ResultCode.NOT_FOUND);
        }else{
            bookMenu.setPassageName(passageName);
            bookMenu.setState(Status.makeCode(stage));
            bookMenu.setModificationTime(LocalDateTime.now());
            int i = bookMenuMapper.updateById(bookMenu);
            if (i!=1){
                return Result.error();
            }else{
                BookMenu menu = bookMenuMapper.selectOne(eq);
                Map<String,Object> map=new HashMap<>();
                map.put("id",menu.getId());
                map.put("passageName",menu.getPassageName());
                map.put("articleLength",menu.getArticleLength());
                map.put("state",Status.makeStatus(menu.getState()));
                map.put("createTime",menu.getCreateTime());
                map.put("modificationTime",menu.getModificationTime());
                return Result.ok(ResultCode.CREATED).data(map);
            }
        }
    }

    @Override
    public Result deletePassage(Integer id) {
        QueryWrapper<BookMenu> eq=new QueryWrapper<>();
        eq.eq("id",id);
        int delete = bookMenuMapper.delete(eq);
        if (delete!=1){
            return Result.error();
        }else{
            return Result.ok(ResultCode.DELETED);
        }

    }

    @Override
    public Result getOnePassageContent(Integer id) {
        QueryWrapper<BookMenu> eq=new QueryWrapper<>();
        eq.eq("id",id);
        BookMenu bookMenu = bookMenuMapper.selectOne(eq);
        if (bookMenu==null){
            return Result.error();
        }else{
           Map<String,Object>map = new HashMap<>();
           map.put("passageContent",bookMenu.getPassageContent());
            return Result.ok(ResultCode.CREATED).message("文章获取成功").data(map);
        }

    }

    @Override
    public Result addOnePassageContent(Integer id, String passageContent) {
        QueryWrapper<BookMenu> eq=new QueryWrapper<>();
        eq.eq("id",id);
        BookMenu bookMenu = bookMenuMapper.selectOne(eq);
        if (bookMenu==null){
            return Result.error();
        }else{
            bookMenu.setPassageContent(passageContent);
            bookMenu.setModificationTime(LocalDateTime.now());
            int i = bookMenuMapper.updateById(bookMenu);
            if (i!=1){
                return Result.error();
            }else{
                return Result.ok(ResultCode.CREATED).message("保存成功");
            }
        }
    }


}
