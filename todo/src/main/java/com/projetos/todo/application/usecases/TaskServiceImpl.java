package com.projetos.todo.application.usecases;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.projetos.todo.adapters.inbound.dtos.CreateTaskRequest;
import com.projetos.todo.adapters.inbound.dtos.TaskResponse;
import com.projetos.todo.adapters.inbound.mappers.TaskMapper;
import com.projetos.todo.domain.task.Task;
import com.projetos.todo.domain.task.TaskRepository;
import com.projetos.todo.domain.task.TaskService;

public class TaskServiceImpl implements TaskService {

  private final TaskRepository repository;

  public TaskServiceImpl(TaskRepository repository) {
    this.repository = repository;
  }

  @Override
  public Task createTask(CreateTaskRequest request) {
    Task task = TaskMapper.toTaskDomain(request);
    return this.repository.save(task);
  }

  @Override
  public List<TaskResponse> getAllTasks() {
    return repository.findAll().stream()
        .map(taskRes -> TaskMapper.toResponse(taskRes))
        .collect(Collectors.toList());
  }

  @Override
  public void deleteTask(UUID id) {
    repository.deleteById(id);
  }
}
