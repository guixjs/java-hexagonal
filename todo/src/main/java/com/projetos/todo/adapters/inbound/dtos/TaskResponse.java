package com.projetos.todo.adapters.inbound.dtos;

import java.util.UUID;

public class TaskResponse {

  private UUID id;
  private String title;
  private String description;
  private boolean done;

  public TaskResponse(UUID id, String title, String description, boolean done) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.done = done;
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public boolean isDone() {
    return done;
  }

}
