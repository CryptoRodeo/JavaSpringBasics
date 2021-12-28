package com.example.todoapi.todoitems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * The TodoItemRepository will be implemented by the Spring Data JPA during runtime
 * based on the SimpleJpaRepository class.
 * see: https://github.com/spring-projects/spring-data-jpa/blob/main/src/main/java/org/springframework/data/jpa/repository/support/SimpleJpaRepository.java
 */
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    // he ?1 element denotes the input parameter of the query.
    @Query("SELECT t FROM TodoItem t WHERE t.task = ?1")
    Optional<TodoItem> findByTask(String task);
}
