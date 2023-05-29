package com.company.employeeservice.service;

import com.company.employeeservice.entity.Employee;
import com.company.employeeservice.exception.EmployeeNotFoundException;
import com.company.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee with id " + id + " does not exists!!!"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee with id " + id + " does not exists!!!"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDob(employee.getDob());
        existingEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    public String deleteEmployeeById(long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException("employee with id " + id + " does not exists!!!"));
        employeeRepository.deleteById(existingEmployee.getId());
        return "employee with id : " + id + " is removed!!!";
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
