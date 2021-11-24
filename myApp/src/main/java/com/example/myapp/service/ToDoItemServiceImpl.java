package com.example.myapp.service;

import com.example.myapp.entity.TododItem;
import com.example.myapp.repository.TodoItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jiangtaotao
 */
@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    private final TodoItemRepository todoEventRepository;


    public ToDoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoEventRepository = todoItemRepository;
    }

    @Override
    public TododItem addTodoItem(TododItem event) {
        TododItem save = todoEventRepository.save(event);
        return save;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTodoItemStatus(Long id, int status) {
        todoEventRepository.updateEventStatus(status, id);
    }

    @Override
    public void deleteTodoItemById(long id) {
        todoEventRepository.deleteById(id);
    }

    @Override
    public List<TododItem> getAllTodoItem() {
        return todoEventRepository.findAll();
    }
}
