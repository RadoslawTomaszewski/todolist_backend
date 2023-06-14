package com.todolist.todolist.controller;

import com.todolist.todolist.exception.TodoNotFoundException;
import com.todolist.todolist.model.Todo;
import com.todolist.todolist.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TodoController {


    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/todo")
    Todo newTodo(@RequestBody Todo newTodo){
        return todoRepository.save(newTodo);
    }

    @GetMapping("/todos")
    List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    @GetMapping("/todo/{id}")
    Todo getTodoById(@PathVariable Long id){
        return todoRepository.findById(id)
                .orElseThrow(()->new TodoNotFoundException(id));
    }

    @PutMapping("/todo/{id}")
    Todo updateTodo(@RequestBody Todo newTodo,@PathVariable Long id){
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setIsCompleted(newTodo.getIsCompleted());
                    todo.setName(newTodo.getName());
                    todo.setDeadline(newTodo.getDeadline());
                    return todoRepository.save(todo);
                }).orElseThrow(()->new TodoNotFoundException(id));
    }

    @DeleteMapping("/todo/{id}")
    String deleteTodo(@PathVariable Long id){
        if(!todoRepository.existsById(id)){
            throw new TodoNotFoundException(id);
        }
        todoRepository.deleteById(id);
        return "Zadanie o id " + id + " zostalo usuniete.";
    }

}
