package com.example.demo.controller;

import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import com.example.demo.entity.UpdateTodo;
import com.example.demo.service.TodoService;
import java.time.ZonedDateTime;
import java.util.HashMap;
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

  private final TodoService todoService;

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
  public ResponseEntity<Map<String, String>> create(@RequestBody CreateTodo createTodo) {
    int createdNumber = todoService.create(createTodo);
    Map<String, String> message = new HashMap<String, String>();
    message.put("message", createdNumber + "件が正常に作成されました");
    return new ResponseEntity(message, HttpStatus.CREATED);
  }

  @PatchMapping("/todos/{id}")
  public ResponseEntity<Map<String, String>> update(@PathVariable int id,
                                                    @RequestBody UpdateTodo updateTodo) {
    todoService.update(id, updateTodo.getTitle(), updateTodo.getDescription(),
        updateTodo.isCompleted());
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/todos/{id}")
  public ResponseEntity<Map<String, String>> delete(@PathVariable int id) {
    int deletedNumber = todoService.deleteTodo(id);
    Map<String, String> message = new HashMap<String, String>();
    message.put("message", deletedNumber + "件が正常に削除されました");
    return new ResponseEntity(message, HttpStatus.OK);
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
