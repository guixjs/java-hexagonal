package com.projetos.todo.adapters.outbound.repositories;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.projetos.todo.adapters.outbound.entities.JpaTaskEntity;
import com.projetos.todo.domain.task.Task;
import com.projetos.todo.domain.task.TaskRepository;

public class TaskRepositoryImpl implements TaskRepository {
  private final JpaTaskRepository jpaTaskRepository;

  public TaskRepositoryImpl(JpaTaskRepository jpaTaskRepository) {
    this.jpaTaskRepository = jpaTaskRepository;
  }

  @Override
  public Task save(Task task) {
    JpaTaskEntity taskEntity = new JpaTaskEntity(task);
    this.jpaTaskRepository.save(taskEntity);
    return new Task(taskEntity.getId(), taskEntity.getTitle(), taskEntity.getDescription(), taskEntity.isDone());
  }

  @Override
  public List<Task> findAll() {
    return this.jpaTaskRepository.findAll()
        .stream()
        .map(task -> new Task(task.getId(), task.getTitle(), task.getDescription(), task.isDone()))
        .collect(Collectors.toList());
  }

  @Override
  public void deleteById(UUID id) {
    this.jpaTaskRepository.deleteById(id);

  }
}
