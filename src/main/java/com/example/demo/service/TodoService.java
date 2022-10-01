package com.example.demo.service;

import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo findById(int id);

    int create(CreateTodo createTodo);

    int update(int id, String title, String description);

    int deleteTodo(int id);
}
