package com.hitss.springboot.app_taskmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info().title("Task Api")
                        .version("1.0.0")
                        .description("Api Doc for TaskManager with SpringBoot 3.5.7"));
    }

}
