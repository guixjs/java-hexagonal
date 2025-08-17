package com.projetos.todo.domain.task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {

  Task save(Task task);
  List<Task> findAll();
  void deleteById(UUID id);
  
}
