package com.projetos.todo.adapters.outbound.entities;

import com.projetos.todo.domain.task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "task")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaTaskEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String title;
  private String description;
  private boolean done;


  public JpaTaskEntity(Task task) {
    this.id = task.getId();
    this.title = task.getTitle();
    this.description = task.getDescription();
    this.done = task.isDone();
  }
}
