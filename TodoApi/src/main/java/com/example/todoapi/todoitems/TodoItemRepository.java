package com.example.todoapi.todoitems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Research why this needs to be an interface
 */
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    // he ?1 element denotes the input parameter of the query.
    @Query("SELECT t FROM TodoItem t WHERE t.task = ?1")
    Optional<TodoItem> findByTask(String task);
}
