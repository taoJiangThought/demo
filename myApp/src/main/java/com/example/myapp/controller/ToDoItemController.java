package com.example.myapp.controller;

import com.example.myapp.entity.TododItem;
import com.example.myapp.service.ToDoItemService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.HashMap;
import java.util.List;

/**
 * @author jiangtaotao
 */
@RestController
@RequestMapping("/todoItem")
@Validated
public class ToDoItemController {

    private final ToDoItemService toDoItemService;

    public ToDoItemController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    /**
     *  - 创建待办事项
     */
     @PostMapping
    public TododItem addTodoItem(@RequestBody @Valid TododItem tododItem){

       return toDoItemService.addTodoItem(tododItem);
     }

    /**
     *  - 创建待办事项
     */
    @GetMapping("/test")
    public HashMap test(){
        HashMap map = new HashMap();
        map.put("id",1);
        map.put("message","Hello World!!!");
        return map;
    }
    /**
     * - 更新一个待办事项到完成状态
     */
    @PutMapping
    public void updateTodoItemStatus(@RequestParam(value = "id") Long id , @RequestParam("status") @Valid @Max(1) Integer status){
       toDoItemService.updateTodoItemStatus(id, status);
    }

    /**
     * - 删除一个待办事项
     */
    @DeleteMapping("/{id}")
    public void deleteTodoItemById(@PathVariable long id){
       toDoItemService.deleteTodoItemById(id);
    }

    /**
     *  - 创建待办事项
     * - 获取所有的待办事项
     */
    @GetMapping
    public List<TododItem> getAllEvent(){

        List<TododItem> allTodoItem = toDoItemService.getAllTodoItem();

        return allTodoItem;
    }
}
