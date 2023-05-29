package com.company.employeeservice.config;

import com.company.employeeservice.entity.Employee;
import com.company.employeeservice.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee john = new Employee("John", "johnwright@gmail.com", LocalDate.of(1991, Month.AUGUST, 6), 1000.0,"8FnFvPl1q0YPgbBXMmeai0zMHNOZC5hc");
            Employee alex = new Employee("Alex", "alexsmith@gmail.com", LocalDate.of(1990, Month.JANUARY, 18), 1500.0,"rcC1zXOrLGYuNPVnCEq3b9F605GVKGhO");
            employeeRepository.saveAll(List.of(john, alex));
        };
    }
}
