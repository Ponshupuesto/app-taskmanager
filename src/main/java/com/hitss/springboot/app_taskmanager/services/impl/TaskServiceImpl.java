package com.hitss.springboot.app_taskmanager.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitss.springboot.app_taskmanager.models.Task;
import com.hitss.springboot.app_taskmanager.repositories.TaskRepository;
import com.hitss.springboot.app_taskmanager.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Transactional
    @Override
    public Task save(Task task) {
        return taskRepository.save(task);

    }

    @Override
    public Optional<Task> update(Long id, Task task) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task taskDB = taskOptional.orElseThrow();
            taskDB.setName(task.getName());
            task.setDescription(task.getName());

            return Optional.of(taskRepository.save(taskDB));
        }

        return taskOptional;
    }

    @Override
    public Optional<Task> delete(Long id) {
        Optional<Task> optional = taskRepository.findById(id);
        optional.ifPresent(p -> taskRepository.delete(p));
        return optional;
    }

}
