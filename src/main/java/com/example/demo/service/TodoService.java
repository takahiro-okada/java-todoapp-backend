package com.example.demo.service;

import com.example.demo.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo findById(int id);
}
