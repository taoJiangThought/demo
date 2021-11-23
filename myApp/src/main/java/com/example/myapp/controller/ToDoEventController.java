package com.example.myapp.controller;

import antlr.StringUtils;
import com.example.myapp.Entity.ToDoEvent;
import com.example.myapp.Global.Response;
import com.example.myapp.Global.ResponseBuilder;
import com.example.myapp.Global.ResponseCode;
import com.example.myapp.service.ToDoEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.awt.*;
import java.util.List;

/**
 * @author jiangtaotao
 */
@RestController
@RequestMapping("/event")
@Validated
public class ToDoEventController {

    @Autowired
    private ToDoEventService toDoEvenService;

    /**
     *  - 创建待办事项
     *  TODO 校验和入参数
     */
     @PostMapping
    public String addEvent(@RequestBody @Valid ToDoEvent event){

         boolean b = toDoEvenService.addEvent(event);
         return b?"data save success":"data save failed";
     }


    /**
     * - 更新一个待办事项到完成状态
     */
    @PutMapping
    public String updateEventStatus(@RequestParam(value = "id") Long id ,@RequestParam("status") @Valid @Size(max = 1) Integer status){
        boolean b = toDoEvenService.updateEventStatus(id, status);
        return b?"data update success":"update data failed";
    }

    /**
     * - 删除一个待办事项
     */
    @DeleteMapping("/{id}")
    public String deleteEventById(@PathVariable long id){

        boolean b = toDoEvenService.deleteEventById(id);

        return b?"data delete success":"update delete failed";
    }

    /**
     *  - 创建待办事项
     * - 获取所有的待办事项
     */
    @GetMapping
    public List<ToDoEvent> getAllEvent(){

        List<ToDoEvent> allTodoEvent = toDoEvenService.getAllTodoEvent();

        return allTodoEvent;
    }
}
