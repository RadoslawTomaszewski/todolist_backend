package com.todolist.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    private boolean isCompleted;
    private String name;
    private LocalDateTime deadline;


    public Long getId() {
        return id;
    }
    public boolean getIsCompleted() {
        return isCompleted;
    }
    public String getName() {
        return name;
    }
    public LocalDateTime getDeadline() {return deadline;}


    public void setId(Long id) {
        this.id = id;
    }
    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDeadline(LocalDateTime deadline) {this.deadline = deadline;}
}