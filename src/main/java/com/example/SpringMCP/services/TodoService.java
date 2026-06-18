package com.example.SpringMCP.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.SpringMCP.models.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;


@Service
@AllArgsConstructor
@Builder
@Slf4j
public class TodoService {    
    public final Map<String,Todo>todos=new HashMap<>();
    public Todo createTodo(String title,String description,Todo.Priority priority){
        Todo todo=Todo.builder().title(title).description(description).priority(priority).build();
        todos.put(todo.getId(), todo);
        return todo;
    }
    public Optional<Todo>getTodo(String id){
        return Optional.ofNullable(todos.get(id));
    }
    public List<Todo>getTodos(){
        return new ArrayList<>(todos.values());
    }
    public boolean deleteTodo(String id){
        return todos.remove(id)!=null;
    }
    public List<Todo>getTodosByStatus(Todo.Status Status){
        return todos.values()
        .stream().filter(todo->todo.getStatus()==Status)
        .collect(Collectors.toList());
    }
    public List<Todo>getTodosByPriority(Todo.Priority priority){
        return todos.values().stream().filter(todos->todos.getPriority()==priority).collect(Collectors.toList());
    }
    public Optional<Todo>updateStatus(String id,Todo.Status status){
        Todo todo=todos.get(id);
        if(todos==null){
            return Optional.empty();
        }
        todo.setStatus(status);
        todos.put(id,todo);
        return Optional.of(todo);
    }
}