package com.example.todoapi.todoitems;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TodoConfig {
    /**
     *
     * CommandLineRunner:
     * - CommandLineRunner is an interface used to indicate that a bean should run when it is contained within a SpringApplication
     */
    @Bean
    CommandLineRunner commandLineRunner(TodoItemRepository repo)
    {
        return args -> {
            repo.saveAll(List.of(
                  new TodoItem(1l, "Walk dog", false),
                  new TodoItem(2l, "Finish app", false),
                  new TodoItem(3l, "Eat breakfast", true)
            ));
        };
    }

}
