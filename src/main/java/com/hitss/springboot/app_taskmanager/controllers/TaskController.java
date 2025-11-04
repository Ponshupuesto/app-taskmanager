package com.hitss.springboot.app_taskmanager.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.Binding;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitss.springboot.app_taskmanager.models.Task;
import com.hitss.springboot.app_taskmanager.repositories.TaskRepository;
import com.hitss.springboot.app_taskmanager.services.TaskService;
import com.hitss.springboot.app_taskmanager.utils.UtilCrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks", description = "Endpoints for TaskManager")
public class TaskController {

    private final TaskRepository taskRepository;

    private TaskService taskService;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @Operation(summary = "Get All Tasks", description = "Retrieves all tasks to do")
    @GetMapping
    public List<Task> list() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Task> taskOptional = taskService.findById(id);
        if (taskOptional.isPresent()) {
            return ResponseEntity.ok(taskOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Task task, BindingResult result) {
        if (result.hasFieldErrors()) {
            return UtilCrud.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Task task, BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()) {
            return UtilCrud.validation(result);
        }
        Optional<Task> optional = taskService.update(id, task);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Task> optional = taskService.delete(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.orElseThrow());

        }

        return ResponseEntity.notFound().build();
    }

}
