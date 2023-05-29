package com.company.employeeservice.repository;

import com.company.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee, Long>, JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeByName(String name);
    Optional<Employee> findEmployeeByEmail(String email);
}