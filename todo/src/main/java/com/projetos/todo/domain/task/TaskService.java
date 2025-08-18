package com.projetos.todo.domain.task;

import java.util.List;
import java.util.UUID;

import com.projetos.todo.adapters.inbound.dtos.CreateTaskRequest;
import com.projetos.todo.adapters.inbound.dtos.TaskResponse;

public interface TaskService {
  Task createTask(CreateTaskRequest request);

  List<TaskResponse> getAllTasks();

  void deleteTask(UUID id);
}
