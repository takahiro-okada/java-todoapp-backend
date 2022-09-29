package com.example.demo.service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoMapper todoMapper;

    public TodoServiceImpl(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Override
    public List<Todo> findAll() {
        return todoMapper.findAll();
    }
}
