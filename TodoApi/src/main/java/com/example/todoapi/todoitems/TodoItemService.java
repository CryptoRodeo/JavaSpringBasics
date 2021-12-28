package com.example.todoapi.todoitems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> getTodoItems() {
        return todoItemRepository.findAll();
    }

    public void addNewTodoItem(TodoItem todoItem) {
        Optional<TodoItem> todoItemOptional = todoItemRepository.findByTask(todoItem.getTask());
        if (todoItemOptional.isPresent())
        {
            throw new IllegalStateException("Task already exists");
        }
        todoItemRepository.save(todoItem);
    }

    public void deleteTodoItem(Long taskId)
    {
        if(!todoItemRepository.existsById(taskId)) {
            throw new IllegalStateException("Task with id (" + taskId + ") does not exist");
        }
        todoItemRepository.deleteById(taskId);
    }

    @Transactional
    public void updateTodoItem(Long taskId, TodoItem updatedTodoItem)
    {
        TodoItem todoItem = todoItemRepository
                .findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Todo item with id (" + taskId  + ") does not exist." ));

        String task = updatedTodoItem.getTask();
        Boolean status = updatedTodoItem.isCompleted();

        if (validTask(task, todoItem))
        {
            todoItem.setTask(task);
        }

        if (statusChanged(status, todoItem))
        {
            todoItem.setStatus(status);
        }
    }

    private boolean validTask(String task, TodoItem todoItem)
    {
        return (task != null) &&
                (task.length() > 0) &&
                (!Objects.equals(todoItem.getTask(), task));
    }

    private boolean statusChanged(Boolean status, TodoItem todoItem)
    {
        return (status != null) &&
                (todoItem.isCompleted() != status);
    }

    public TodoItem findTodoItem(Long taskId) {
        return todoItemRepository
                .findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Todo item with id (" + taskId + ") does not exist."));
    }
}
