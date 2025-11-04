package com.hitss.springboot.app_taskmanager.services;

import java.util.List;
import java.util.Optional;

import com.hitss.springboot.app_taskmanager.models.Task;

public interface TaskService {
    // CRUD

    List<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task task);

    Optional<Task> update(Long id, Task task);

    Optional<Task> delete(Long id);

}
