package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("/todos")
    public List<TodoResponse> getAll() {
        List<Todo> todos = todoService.findAll();
        return todos.stream().map(TodoResponse::new).toList();
    }

    @GetMapping("/todos/{id}")
    public TodoResponse getProductById(
            @PathVariable int id
    ) {
        Todo todo = todoService.findById(id);
        return new TodoResponse(todo);
    }
}
