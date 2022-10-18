package com.example.demo.entity;

import java.util.Objects;

public class Todo {

  private int id;
  private String title;
  private String description;
  private boolean isCompleted;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Todo todo = (Todo) o;
    return id == todo.id && Objects.equals(title, todo.title) &&
        Objects.equals(description, todo.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description);
  }

  public Todo(int id, String title, String description, boolean isCompleted) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.isCompleted = isCompleted;
  }

  @Override
  public String toString() {
    return "Todo{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", isCompleted='" + isCompleted + '\'' +
        '}';
  }

}
