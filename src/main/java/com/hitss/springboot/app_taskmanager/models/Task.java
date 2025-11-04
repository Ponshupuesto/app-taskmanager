package com.hitss.springboot.app_taskmanager.models;

import com.hitss.springboot.app_taskmanager.validation.isRequired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    @isRequired(message = "{NotBlank.task.name}")
    @Size(min = 3, max = 200)
    private String name;

    @NotBlank
    @Size(min = 3, max = 200)
    private String description;

}
