package com.projetos.todo.adapters.inbound.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.todo.adapters.inbound.dtos.CreateTaskRequest;
import com.projetos.todo.adapters.inbound.dtos.TaskResponse;
import com.projetos.todo.adapters.inbound.mappers.TaskMapper;
import com.projetos.todo.domain.task.Task;
import com.projetos.todo.domain.task.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskService service;

  public TaskController(TaskService service) {
    this.service = service;
  }

  @PostMapping("/new")
  public TaskResponse create(@RequestBody CreateTaskRequest request) {
    Task task = service.createTask(request);
    return TaskMapper.toResponse(task);
  }

  @GetMapping("")
  public List<TaskResponse> getAllTasks() {
    return service.getAllTasks();
  }

  @DeleteMapping("/{id}")
  public void deleteTask(@PathVariable UUID id) {
    service.deleteTask(id);
  }

}
