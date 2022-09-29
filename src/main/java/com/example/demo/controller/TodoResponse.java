package com.example.demo.controller;

import com.example.demo.entity.Todo;

import java.util.List;

public class TodoResponse {
    private int id;
    private String title;
    private String description;

    public TodoResponse(Todo todos) {
            this.id = todos.getId();
            this.title = todos.getTitle();
            this.description = todos.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoResponse(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
