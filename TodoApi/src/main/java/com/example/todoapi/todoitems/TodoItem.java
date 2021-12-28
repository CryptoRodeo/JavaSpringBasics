package com.example.todoapi.todoitems;

import javax.persistence.*;

@Table
@Entity
public class TodoItem {

  @Id
  @SequenceGenerator(
          name="todo_sequence",
          sequenceName="todo_sequence",
          allocationSize=1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "todo_sequence"
  )
    private Long id;
    private String task;
    private Boolean completed;

    public TodoItem(Long id, String task, Boolean completed)
    {
        this.id = id;
        this.task = task;
        this.completed = completed;
    }


    public TodoItem(String task, Boolean completed)
    {
        this.task = task;
        this.completed = completed;
    }

    public TodoItem()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setStatus(Boolean isCompleted) {
        completed = isCompleted;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", completed=" + completed+
                '}';
    }
}
