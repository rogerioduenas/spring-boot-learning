package com.rogerio.resource_deletion.service;

import com.rogerio.resource_deletion.model.Task;
import com.rogerio.resource_deletion.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

  private final TaskRepository repository;

  public TaskService(TaskRepository repository) {
    this.repository = repository;
  }

  public Optional<Task> deleteById(final Long id) {
    Optional<Task> taskFound = repository.getTasks().stream()
        .filter(task -> task.id().equals(id))
        .findFirst();

    taskFound.ifPresent(task -> repository.deleteTaskById(id));

    return taskFound;
  }
}
