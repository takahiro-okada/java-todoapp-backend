package com.example.demo.controller;

import com.example.demo.entity.Todo;

public class TodoResponse {

  private int id;
  private String title;
  private String description;
  private boolean isCompleted;

  public TodoResponse(Todo todo) {
    this.id = todo.getId();
    this.title = todo.getTitle();
    this.description = todo.getDescription();
    this.isCompleted = todo.isCompleted();
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

  public boolean isCompleted() {
    return isCompleted;
  }

  public void setCompleted(boolean isCompleted) {
    isCompleted = isCompleted;
  }

}
