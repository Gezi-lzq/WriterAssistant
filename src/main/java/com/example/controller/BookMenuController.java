package com.example.controller;


import com.example.service.IBookMenuService;
import com.example.util.result.Result;
import com.example.vo.AddPassageContentVO;
import com.example.vo.AddPassageVO;
import com.example.vo.DeletePassageVO;
import com.example.vo.UpdatePassageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liu
 * @since 2021-08-23
 */
@RestController
@RequestMapping("/passage")
public class BookMenuController {

    @Autowired
    private IBookMenuService bookMenuService;

    @GetMapping()
    public Result getAllPassages(){
        return bookMenuService.getAllPassages();
    }

    @PostMapping()
    public Result addOnePassages(@RequestBody AddPassageVO addPassVO){
        return bookMenuService.addOnePassage(addPassVO.getId(),addPassVO.getPassageName());
    }

    @PutMapping()
    public Result updatePassage(@RequestBody UpdatePassageVO passageVO){
        return bookMenuService.updatePassage(passageVO.getId(),passageVO.getPassageName(),passageVO.getStage());
    }

    @DeleteMapping()
    public Result deletePassage(@RequestBody DeletePassageVO passageVO){
        return bookMenuService.deletePassage(passageVO.getId());
    }

    @GetMapping("/{id}")
    public Result getOnePassageContent(@PathVariable(name = "id") Integer id){
        return bookMenuService.getOnePassageContent(id);
    }

    @PostMapping("/{id}")
    public Result addOnePassageContent(@PathVariable(name = "id") Integer id, @RequestBody AddPassageContentVO passageContentVO){
        return bookMenuService.addOnePassageContent(id,passageContentVO.getPassageContent());
    }

}
