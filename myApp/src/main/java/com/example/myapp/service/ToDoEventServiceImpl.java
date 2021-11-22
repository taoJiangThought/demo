package com.example.myapp.service;

import com.example.myapp.Entity.ToDoEvent;
import com.example.myapp.repository.TodoEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jiangtaotao
 */
@Service
public class ToDoEventServiceImpl implements ToDoEventService {

    @Autowired
    private TodoEventRepository todoEventRepository;

    @Override
    public boolean addEvent(ToDoEvent event) {
        ToDoEvent save = todoEventRepository.save(event);
        if (save == null){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateEventStatus(Long id, int status) {
        int i = todoEventRepository.updateEventStatus(status, id);
        if (i <= 0){
            return  false;
        }
        return true;
    }

    @Override
    public boolean deleteEventById(long id) {
        todoEventRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ToDoEvent> getAllTodoEvent() {
        return todoEventRepository.findAll();
    }
}
