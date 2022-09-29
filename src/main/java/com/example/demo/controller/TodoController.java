package com.example.demo.controller;

import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
    public TodoResponse getProductById(@PathVariable int id) {
        Todo todo = todoService.findById(id);
        return new TodoResponse(todo);
    }

    @PostMapping("/todos")
    public void create(@RequestBody CreateTodo createTodo){
        todoService.create(createTodo);
    }
}
