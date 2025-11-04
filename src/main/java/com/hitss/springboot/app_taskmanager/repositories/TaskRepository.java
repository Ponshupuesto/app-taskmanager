package com.hitss.springboot.app_taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hitss.springboot.app_taskmanager.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
