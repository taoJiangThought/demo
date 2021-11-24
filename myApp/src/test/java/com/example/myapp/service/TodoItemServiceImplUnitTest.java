package com.example.myapp.service;

import com.example.myapp.entity.TododItem;
import com.example.myapp.repository.TodoItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


class TodoItemServiceImplUnitTest {

    TodoItemRepository todoItemRepositoryMock = mock(TodoItemRepository.class);

    ToDoItemServiceImpl toDoItemService;

    @Test
    void test_normal_add_todoItem() {
        toDoItemService = new ToDoItemServiceImpl(todoItemRepositoryMock);
        TododItem todoItem = new TododItem();
        todoItem.setEventName("test_a");
        todoItem.setStatus(1);
        when(todoItemRepositoryMock.save(ArgumentMatchers.argThat(todoItemArg -> todoItemArg.getStatus() <= 1))).thenReturn(todoItem);
        TododItem todoItemReturn = toDoItemService.addTodoItem(todoItem);
        Assertions.assertEquals(todoItem, todoItemReturn);
    }

    @Test
    void test_non_normal_add_todoItem() {
        toDoItemService = new ToDoItemServiceImpl(todoItemRepositoryMock);
        TododItem todoItem = new TododItem();
        todoItem.setEventName("test_a");
        todoItem.setStatus(2);
        boolean flag = false;
        try {
            when(todoItemRepositoryMock.save(ArgumentMatchers.argThat(todoItemArg -> todoItemArg.getStatus() > 1))).thenThrow(new Exception("parameters is illegel"));
            toDoItemService.addTodoItem(todoItem);
        } catch (Exception e) {
            flag = true;
        }
        Assertions.assertEquals(true, flag);
    }

    @Test
    void test_normal_update_todoItem() {
        toDoItemService = new ToDoItemServiceImpl(todoItemRepositoryMock);
        when(todoItemRepositoryMock.updateEventStatus(ArgumentMatchers.eq(1), ArgumentMatchers.eq(1l))).thenReturn(1);
        toDoItemService.updateTodoItemStatus(1l, 1);
    }

    @Test
    void test_normal_delete_todoItem() {
        toDoItemService = new ToDoItemServiceImpl(todoItemRepositoryMock);
        toDoItemService.deleteTodoItemById(1l);
    }

    @Test
    void test_normal_get_todoItem() {
        toDoItemService = new ToDoItemServiceImpl(todoItemRepositoryMock);
        List<TododItem> events = new ArrayList<>(0);
        when(todoItemRepositoryMock.findAll()).thenReturn(events);
        List<TododItem> allTodoEvent = toDoItemService.getAllTodoItem();
        Assertions.assertEquals(events, allTodoEvent);
    }
}