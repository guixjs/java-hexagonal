package com.projetos.todo.adapters.outbound.repositories;

import com.projetos.todo.adapters.outbound.entities.JpaTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTaskRepository extends JpaRepository<JpaTaskEntity, UUID> {
}
