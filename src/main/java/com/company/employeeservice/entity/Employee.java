package com.company.employeeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DOB")
    private LocalDate dob;
    @Column(name = "SALARY")
    private double salary;
    @Transient
    private int age;
    private String imageUrl;

    public Employee(String name, String email, LocalDate dob, double salary, String imageUrl) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.salary = salary;
        this.imageUrl = imageUrl;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }
}
