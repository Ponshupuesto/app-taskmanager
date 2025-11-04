package com.hitss.springboot.app_taskmanager.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = { RequiredValidation.class })
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface isRequired {

    String message() default "Es Requerido utilizando anotaciones";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
