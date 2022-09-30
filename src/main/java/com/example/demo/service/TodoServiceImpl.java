package com.example.demo.service;

import com.example.demo.controller.ResourceNotFoundException;
import com.example.demo.entity.CreateTodo;
import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

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

    @Override
    public Todo findById(int id) {
        Optional<Todo> todo = this.todoMapper.findById(id);
        if(todo.isPresent()){
            return todo.get();
        } else {
            throw new ResourceNotFoundException("resouce not found");
        }
    }

    @Override
    public int create(CreateTodo createTodo) {
        return todoMapper.createTodo(createTodo);
    }

    @Override
    public void update(int id, String title, String description) {
        todoMapper.updateTodo(id,title,description);
    }

    @Override
    public void deleteTodo(int id){
        todoMapper.deleteTodo(id);
    }

}
