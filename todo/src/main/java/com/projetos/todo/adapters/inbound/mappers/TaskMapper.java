package com.projetos.todo.adapters.inbound.mappers;

import com.projetos.todo.adapters.inbound.dtos.CreateTaskRequest;
import com.projetos.todo.adapters.inbound.dtos.TaskResponse;
import com.projetos.todo.domain.task.Task;

public class TaskMapper {

  public static Task toTaskDomain(CreateTaskRequest request) {
    return new Task(null, request.getTitle(), request.getDescription(), false);
  }

  public static TaskResponse toResponse(Task task) {
    return new TaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.isDone());
  }

}
