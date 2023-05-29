package com.company.employeeservice.config;

import com.company.employeeservice.handler.CustomExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomExceptionHandlerConfiguration {

    @Bean
    public CustomExceptionHandler customExceptionHandler() {
        return new CustomExceptionHandler();
    }

}
