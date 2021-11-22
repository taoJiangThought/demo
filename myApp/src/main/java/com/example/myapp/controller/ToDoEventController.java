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
    public Response addEvent(@RequestBody @Valid ToDoEvent event){
         if (event.getEventName()==null||event.getEventName().length()==0){
             return ResponseBuilder.createFailRes(ResponseCode.COMMON_PARAMS_ILLEGAL,"event name is blank","save failed");
         }
         if (event.getStatus()==null||(event.getStatus() != 0 && event.getStatus() != 1 )){
             return ResponseBuilder.createFailRes(ResponseCode.COMMON_PARAMS_ILLEGAL,"event status value is wrong","save failed");
         }
         boolean b = toDoEvenService.addEvent(event);
         String msg = b?"data save success":"data save failed";
         return ResponseBuilder.createSuccessRes( msg);
     }


    /**
     * - 更新一个待办事项到完成状态
     */
    @PutMapping
    public Response updateEventStatus(@RequestParam(value = "id") Long id ,@RequestParam("status") @Valid @Size(max = 1) Integer status){
        boolean b = toDoEvenService.updateEventStatus(id, status);
        String msg = b?"data update success":"update save failed";
        return ResponseBuilder.createSuccessRes( msg);
    }

    /**
     * - 删除一个待办事项
     */
    @DeleteMapping("/{id}")
    public Response deleteEventById(@PathVariable long id){

        boolean b = toDoEvenService.deleteEventById(id);
        String msg = b?"data delete success":"update delte failed";
        return ResponseBuilder.createSuccessRes( msg);
    }

    /**
     *  - 创建待办事项
     * - 获取所有的待办事项
     */
    @GetMapping
    public Response getAllEvent(){

        List<ToDoEvent> allTodoEvent = toDoEvenService.getAllTodoEvent();

        return ResponseBuilder.createSuccessRes(allTodoEvent);
    }
}
