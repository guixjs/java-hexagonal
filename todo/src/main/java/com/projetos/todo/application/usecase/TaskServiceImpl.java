package com.projetos.todo.application.usecase;

import com.projetos.todo.domain.task.Task;
import com.projetos.todo.domain.task.TaskRepository;
import com.projetos.todo.domain.task.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

  private final TaskRepository repository;

  public TaskServiceImpl(TaskRepository repository) {
    this.repository = repository;
  }

  @Override
  public Task createTask(String title, String description) {
    Task task = new Task(null, title, description, false);
    return this.repository.save(task);
  }

  @Override
  public List<Task> getAllTasks() {
    return repository.findAll();
  }

  @Override
  public void deleteTask(UUID id) {
    repository.deleteById(id);
  }
}


