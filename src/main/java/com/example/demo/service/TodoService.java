package com.example.demo.service;

import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo findById(int id);

    int create(CreateTodo createTodo);

    void update(int id, String title, String description);

    void deleteTodo(int id);
}
