package com.projetos.todo.domain.task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
  Task createTask(String title, String description);
  List<Task> getAllTasks();
  void deleteTask(UUID id);
}
