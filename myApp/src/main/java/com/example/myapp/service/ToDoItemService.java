package com.example.myapp.service;

import com.example.myapp.entity.TododItem;

import java.util.List;

/**
 * @author jiangtaotao
 */
public interface ToDoItemService {

    /**
     * 创建待办事项
     *
     * @param event
     * @return
     */
     TododItem addTodoItem(TododItem event);


    /**
     * 更新一个待办事项到完成状态
     *
     * @param id
     * @param status
     */
     void updateTodoItemStatus(Long id , int status);


    /**
     * 删除一个待办事项
     *
     * @param id
     * @return
     */
     void deleteTodoItemById(long id);


    /**
     * 获取所有的待办事项
     * @return
     */
     List<TododItem> getAllTodoItem();
}
