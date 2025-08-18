package com.projetos.todo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projetos.todo.adapters.outbound.repositories.JpaTaskRepository;
import com.projetos.todo.adapters.outbound.repositories.TaskRepositoryImpl;
import com.projetos.todo.application.usecases.TaskServiceImpl;
import com.projetos.todo.domain.task.TaskRepository;
import com.projetos.todo.domain.task.TaskService;

@Configuration
public class BeanConfig {

  @Bean
  public TaskRepository taskRepository(JpaTaskRepository jpaTaskRepository) {
    return new TaskRepositoryImpl(jpaTaskRepository);
  }

  @Bean
  public TaskService taskService(TaskRepository repository) {
    return new TaskServiceImpl(repository);
  }
}
