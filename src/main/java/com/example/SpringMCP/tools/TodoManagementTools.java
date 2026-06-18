package com.example.SpringMCP.tools;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;
import com.example.SpringMCP.models.Todo;
import com.example.SpringMCP.services.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
// Will act as a controller layer 
@Component
@AllArgsConstructor
@Slf4j
public class TodoManagementTools {
    private final TodoService todoService;
    @Tool(description = "Create a new todo with a title, description and priority levels are LOW,MEDIUM and HIGH")
    public String createTodo(
        @ToolParam(description = "The title of the todo")String title,
        @ToolParam(description = "The description of the todo")String description,
        @ToolParam(description = "The priority level of the todo can be LOW , MEDIUM or HIGH")String priority
    ) {
        Todo.Priority p;
        try{
            p=Todo.Priority.valueOf(priority.toUpperCase());
        }catch(Exception e){
            return "Invalid priority level. Please use LOW,MEDIUM or HIGH";
        }
        Todo todo=todoService.createTodo(title, description, p);
        return "Todo created successfully"+todo.toString();
    }
}


// 37:52