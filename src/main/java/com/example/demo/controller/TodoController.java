package com.example.demo.controller;

import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import com.example.demo.entity.UpdateTodo;
import com.example.demo.service.TodoService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PatchMapping("/todos/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateTodo updateTodo){
        todoService.update(id, updateTodo.getTitle(), updateTodo.getDescription());
    }

}
