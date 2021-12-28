package com.example.todoapi.todoitems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/todoitems")
public class TodoItemsController {
    private final TodoItemService todoItemService;
    
    @Autowired
    public TodoItemsController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping
    public List<TodoItem> GetTodoItems() {
        return todoItemService.getTodoItems();
    }

    @GetMapping(path="{taskId}")
    public TodoItem getTodoItem(@PathVariable("taskId") Long taskId)
    {
        return todoItemService.findTodoItem(taskId);
    }

    @PostMapping("/add")
    public void addTodoItem(@RequestBody TodoItem todoItem)
    {
        todoItemService.addNewTodoItem(todoItem);
    }

    @DeleteMapping(path="{taskId}")
    public void deleteTodoItem(@PathVariable("taskId") Long taskId) {
        todoItemService.deleteTodoItem(taskId);
    }

    @PutMapping(path="{taskId}")
    public void updateTodoItem(@PathVariable("taskId") Long taskId, @RequestBody TodoItem todoItem)
    {
        todoItemService.updateTodoItem(taskId, todoItem);
    }
}
