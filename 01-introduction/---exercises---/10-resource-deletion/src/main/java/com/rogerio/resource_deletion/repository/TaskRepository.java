package com.rogerio.resource_deletion.repository;

import com.rogerio.resource_deletion.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

  private final List<Task> tasks = new ArrayList<>(List.of(
      new Task(1L, "Aleatory description"),
      new Task(2L, "Aleatory description"),
      new Task(3L, "Aleatory description")
  ));

  public List<Task> getTasks() {
    return tasks;
  }

  public Boolean deleteTaskById(Long id) {
    return tasks.removeIf(task -> task.id().equals(id));
  }
}
