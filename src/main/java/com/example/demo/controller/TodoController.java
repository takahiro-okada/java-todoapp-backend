package com.example.demo.controller;

import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import com.example.demo.entity.UpdateTodo;
import com.example.demo.service.TodoService;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    public String create(@RequestBody CreateTodo createTodo){
        int createdNumber = todoService.create(createTodo);
        return createdNumber + "件が正常に投稿されました！";
    }

    @PatchMapping("/todos/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateTodo updateTodo){
        todoService.update(id, updateTodo.getTitle(), updateTodo.getDescription());
    }

    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable int id){
        todoService.deleteTodo(id);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
        ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
            "timestamp", ZonedDateTime.now().toString(),
            "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
            "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
            "message", e.getMessage(),
            "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }

}
