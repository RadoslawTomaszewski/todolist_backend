package com.todolist.todolist.exception;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(Long id){
        super("Nie znaleziono zadania o id " + id);
    }
}
