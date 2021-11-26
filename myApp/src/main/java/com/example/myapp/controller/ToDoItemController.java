package com.example.myapp.controller;

import com.example.myapp.dto.TodoItemDto;
import com.example.myapp.entity.TodoItem;
import com.example.myapp.service.ToDoItemService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author jiangtaotao
 */
@RestController
@RequestMapping("/todoItems")
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
    public TodoItemDto addTodoItem(@RequestBody @Valid TodoItemDto todoItemDto){
       return toDoItemService.addTodoItem(todoItemDto);
     }


    /**
     * - 更新一个待办事项到完成状态
     */
    @PutMapping
    public TodoItemDto updateTodoItemStatus(@RequestParam(value = "id") Long id , @RequestParam("status") @Valid @Max(1) Integer status){
       return toDoItemService.updateTodoItemStatus(id, status);
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
    public List<TodoItemDto> getAllTodoItem(){
        List<TodoItemDto> allTodoItem = toDoItemService.getAllTodoItem();
        return allTodoItem;
    }
}
