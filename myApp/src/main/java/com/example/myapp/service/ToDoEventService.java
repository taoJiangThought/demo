package com.example.myapp.service;

import com.example.myapp.Entity.ToDoEvent;

import java.util.List;

/**
 * @author jiangtaotao
 */
public interface ToDoEventService {

    /**
     * 创建待办事项
     *
     * @param event
     * @return
     */
    public boolean addEvent(ToDoEvent event);


    /**
     * 更新一个待办事项到完成状态
     *
     * @param id
     * @param status
     * @return
     */
    public boolean updateEventStatus(Long id ,int status);


    /**
     * 删除一个待办事项
     *
     * @param id
     * @return
     */
    public boolean deleteEventById(long id);


    /**
     * 获取所有的待办事项
     * @return
     */
    public List<ToDoEvent> getAllTodoEvent();
}
