package com.example.demo.service;

import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import com.example.demo.entity.UpdateTodo;
import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo findById(int id);

    void create(CreateTodo createTodo);

    void update(int id, String title, String description);

}
